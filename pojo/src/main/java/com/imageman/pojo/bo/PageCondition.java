package com.imageman.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author: ZGF
 * context : 分页查询
 */

@Data
@ApiModel
public class PageCondition {

    @ApiModelProperty(value = "页号", required = true)
    private Integer pageNo = 1;

    @ApiModelProperty(value = "每个数据量", required = true)
    private Integer pageSize = 10;
}
