package com.imageman.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imageman.pojo.Employee;
import com.imageman.pojo.bo.EmployeePageBO;
import com.imageman.pojo.vo.EmployeeVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户  Mapper 接口
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    EmployeeVO getDetailById(String employeeId);

    IPage<EmployeeVO> selectPageByParam(Page<EmployeeVO> page, @Param("param") EmployeePageBO employeePageBO);
}
