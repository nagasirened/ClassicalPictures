package com.imageman.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imageman.common.config.system.CustomException;
import com.imageman.common.config.system.MsgExample;
import com.imageman.common.example.AccessStatus;
import com.imageman.mapper.EmployeeMapper;
import com.imageman.pojo.Employee;
import com.imageman.pojo.EmployeeRole;
import com.imageman.pojo.bo.EmployeePageBO;
import com.imageman.pojo.vo.EmployeeVO;
import com.imageman.service.EmployeeRoleService;
import com.imageman.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 用户  服务实现类
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    @SuppressWarnings("all")
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRoleService employeeRoleService;

    /**
     * 新增用户
     * @param employee
     */
    @Override
    public void insertEmployee(Employee employee) {
        employee.setAccountStatus(AccessStatus.USEFUL.getStatus());
        employeeMapper.insert(employee);

        EmployeeRole employeeRole = EmployeeRole.builder()
                .employeeId(employee.getId())
                .roleId(2)
                .build();
        employeeRoleService.save(employeeRole);
    }

    /**
     * 解冻/ 冻结  用户
     * @param employee
     */
    @Override
    public void thawEmployee(Employee employee) {
        Integer accountStatus = employee.getAccountStatus();
        if (Objects.isNull(accountStatus) || (accountStatus != AccessStatus.USEFUL.getStatus() &&
                accountStatus != AccessStatus.FREEZE.getStatus())) {
            throw new CustomException(MsgExample.PARAM_ERROR);
        }
        employeeMapper.updateById(employee);
    }

    /**
     * 设置为管理员
     * @param employeeId
     */
    @Override
    public void setAdministor(String employeeId) {
        UpdateWrapper<EmployeeRole> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("role_id", 1);
        updateWrapper.eq("employee_id", employeeId);
        employeeRoleService.update(updateWrapper);
    }

    @Override
    public void resetNormal(String employeeId) {
        UpdateWrapper<EmployeeRole> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("role_id", 2);
        updateWrapper.eq("employee_id", employeeId);
        employeeRoleService.update(updateWrapper);
    }

    /**
     * 获取用户信息
     * @param employeeId
     * @return
     */
    @Override
    public EmployeeVO getEmployeeById(String employeeId) {
        EmployeeVO employeeVO = employeeMapper.getDetailById(employeeId);
        Integer accountStatus = employeeVO.getAccountStatus();
        employeeVO.setAccessStatusInfo(AccessStatus.getStatusName(accountStatus));
        return employeeVO;
    }

    /**
     * 分页查询用户信息
     * @param employeePageBO
     * @return
     */
    @Override
    public IPage<EmployeeVO> getPageEmployees(EmployeePageBO employeePageBO) {
        Page<EmployeeVO> page = new Page<>(employeePageBO.getPageNo(), employeePageBO.getPageSize());
        IPage<EmployeeVO> employeeVOIpage = employeeMapper.selectPageByParam(page, employeePageBO);

        Map<Integer, String> accessStatusMap = AccessStatus.convertToMap();
        employeeVOIpage.getRecords().forEach(item -> {
            item.setAccessStatusInfo(accessStatusMap.get(item.getAccountStatus()));
        });
        return employeeVOIpage;
    }
}
