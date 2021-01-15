package com.imageman.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.imageman.pojo.group.InsertGroup;
import com.imageman.pojo.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 商品表 商品表
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
@Data
@Builder
@ApiModel
@TableName("i_product")
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Model<Product> {

    private static final long serialVersionUID=1L;

    /**
     * 主键 主键
     */
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    @NotEmpty(message = "主键不能为空", groups = UpdateGroup.class)
    private String id;

    /**
     * 商品名
     */
    @ApiModelProperty("商品名")
    @NotEmpty(message = "商品名不能为空", groups = InsertGroup.class)
    private String itemName;

    /**
     * 大分类
     */
    @ApiModelProperty("大分类")
    @NotEmpty(message = "大分类不能为空", groups = InsertGroup.class)
    private String rootCatId;

    /**
     * 小分类
     */
    @ApiModelProperty("小分类")
    @NotEmpty(message = "小分类不能为空", groups = InsertGroup.class)
    private String catId;

    /**
     * 卖出数量
     */
    @ApiModelProperty(value = "卖出数量", hidden = true)
    private Integer sellCounts;

    /**
     * 状态0冻结1上架
     */
    @ApiModelProperty(value = "状态0冻结1上架", hidden = true)
    private Integer status;

    /**
     * 详情
     */
    @ApiModelProperty("详情")
    private String content;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除", hidden = true)
    private Integer flag;

}
