package com.imageman.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imageman.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imageman.pojo.bo.EmployeePageBO;
import com.imageman.pojo.vo.EmployeeVO;

/**
 * <p>
 * 用户  服务类
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 新增用户
     * @param employee
     */
    void insertEmployee(Employee employee);

    /**
     * 冻结，解冻
     * @param employee
     */
    void thawEmployee(Employee employee);

    /**
     * 设置为管理员
     * @param employeeId
     */
    void setAdministor(String employeeId);

    /**
     * 设置为普通用户
     * @param employeeId
     */
    void resetNormal(String employeeId);

    /**
     * 获取单个用户信息
     * @param employeeId
     * @return
     */
    EmployeeVO getEmployeeById(String employeeId);

    /**
     * 分页查询
     * @param employeePageBO
     * @return
     */
    IPage<EmployeeVO> getPageEmployees(EmployeePageBO employeePageBO);
}
