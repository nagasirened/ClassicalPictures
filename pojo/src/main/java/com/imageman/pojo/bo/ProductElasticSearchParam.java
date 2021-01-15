package com.imageman.pojo.bo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author: ZGF
 * context : 查询商品请求参数
 */
@Data
@ApiModel
public class ProductElasticSearchParam extends PageCondition {

    /**
     * 大分类
     */
    @ApiModelProperty("大分类")
    private String rootCatId;

    /**
     * 小分类
     */
    @ApiModelProperty("小分类")
    private String catId;

    /**
     * 搜索内容
     */
    private String searchInfo;

    /**
     * 搜索排序条件
     */
    private Integer sortType;
}
