package com.imageman.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * author: ZGF
 * context : 分页查询用户信息
 */

@Data
@ApiModel
public class EmployeePageBO extends PageCondition {

    @ApiModelProperty("用户姓名/邮箱")
    private String searchInfo;

    @ApiModelProperty("起始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

}
