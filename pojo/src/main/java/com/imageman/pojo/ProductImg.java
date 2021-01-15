package com.imageman.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;

import com.imageman.pojo.group.InsertGroup;
import com.imageman.pojo.group.UpdateGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <p>
 * 图片 图片
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
@Data
@Builder
@TableName("i_product_img")
@AllArgsConstructor
@NoArgsConstructor
public class ProductImg extends Model<ProductImg> {

    private static final long serialVersionUID=1L;

    /**
     * 主键 主键
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 商品主键
     */
    private String productId;
    /**
     * 列表预览图
     */
    @NotEmpty(message = "主键不能为空", groups = InsertGroup.class)
    private String previewLittle;

    /**
     * 详情预览
     */
    @NotEmpty(message = "主键不能为空", groups = InsertGroup.class)
    private String previewDetail;

    /**
     * 实际图
     */
    @NotEmpty(message = "主键不能为空", groups = InsertGroup.class)
    private String actual;

    /**
     * 编号
     */
    private String number;

    /**
     * 分辨率
     */
    private String resolution;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 模式
     */
    private String mode;

    /**
     * 文件格式
     */
    private String format;

    /**
     * 版本推荐
     */
    private String version;

    /**
     * 创建时间 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 更新时间 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;

}
