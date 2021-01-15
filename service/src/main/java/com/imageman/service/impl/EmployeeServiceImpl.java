package com.imageman.service.impl;

import com.imageman.mapper.EmployeeMapper;
import com.imageman.pojo.Employee;
import com.imageman.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
