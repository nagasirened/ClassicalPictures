package com.imageman.pojo.bo;

import lombok.Data;

/**
 * author: ZGF
 * context : 分页查询
 */

@Data
public class PageCondition {

    private Integer pageNo = 1;

    private Integer pageSize = 10;
}
