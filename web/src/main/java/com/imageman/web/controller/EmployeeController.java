package com.imageman.web.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imageman.common.config.system.ResponseVO;
import com.imageman.pojo.Employee;
import com.imageman.pojo.bo.EmployeePageBO;
import com.imageman.pojo.group.InsertGroup;
import com.imageman.pojo.group.UpdateGroup;
import com.imageman.pojo.vo.EmployeeVO;
import com.imageman.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 用户  前端控制器
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
@RestController
@RequestMapping("/employee")
@Api(tags = "用户管理")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    @ApiOperation("新增用户，默认都是普通访客")
    public ResponseVO insertEmployee(@RequestBody @Validated(InsertGroup.class) Employee employee){
        employeeService.insertEmployee(employee);
        return ResponseVO.succ();
    }

    @PutMapping("thaw")
    @ApiOperation("解冻/冻结")
    public ResponseVO thawEmployee(@RequestBody @Validated(UpdateGroup.class) Employee employee) {
        employeeService.thawEmployee(employee);
        return ResponseVO.succ();
    }

    @PutMapping("admin")
    @ApiOperation("给予生杀予夺的权力")
    public ResponseVO setAdministor(String employeeId) {
        employeeService.setAdministor(employeeId);
        return ResponseVO.succ();
    }

    @PutMapping("normal")
    @ApiOperation("使之变得平凡")
    public ResponseVO resetNormal(String employeeId) {
        employeeService.resetNormal(employeeId);
        return ResponseVO.succ();
    }

    @GetMapping
    @ApiOperation("透视这个人")
    public ResponseVO<EmployeeVO> getEmployeeById(String employeeId) {
        EmployeeVO employeeVO = employeeService.getEmployeeById(employeeId);
        return ResponseVO.succ(employeeVO);
    }

    @PostMapping("page")
    @ApiOperation("集合训话")
    public ResponseVO<IPage<EmployeeVO>> getPageEmployees(@RequestBody EmployeePageBO employeePageBO) {
        IPage<EmployeeVO> employeeVOPage = employeeService.getPageEmployees(employeePageBO);
        return ResponseVO.succ(employeeVOPage);
    }
}

