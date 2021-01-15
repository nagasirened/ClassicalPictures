package com.imageman.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 分类 分类
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
@Data
@Builder
@TableName("i_category")
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class Category extends Model<Category> {

    private static final long serialVersionUID=1L;

    /**
     * 主键 主键
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    @ApiModelProperty("主键")
    private String id;

    /**
     * 名
     */
    @NotEmpty
    @ApiModelProperty(value = "分类名", required = true)
    @Length(max = 30, min = 1, message = "分类名长度不对")
    private String name;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 父类
     */
    @ApiModelProperty(value = "父类")
    private String parentId;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介")
    @Length(max = 128, message = "简介长度过长")
    private String slogan;

    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String logo;

    /**
     * 创建时间 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", hidden = true)
    private LocalDateTime createdTime;

    /**
     * 更新时间 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间", hidden = true)
    private LocalDateTime updatedTime;

    /**
     * 逻辑删除标志
     */
    @TableLogic
    @ApiModelProperty(value = "逻辑删除标志", hidden = true)
    private Integer flag;

}
