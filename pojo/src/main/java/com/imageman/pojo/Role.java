package com.imageman.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * <p>
 * 角色表 
 * </p>
 *
 * @author ZengGuangfu
 * @since 2021-01-18
 */
@Data
@TableName("i_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 创建人
     */
    @TableField("CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField("CREATED_TIME")
    private LocalDateTime createdTime;

    /**
     * 更新人
     */
    @TableField("UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField("UPDATED_TIME")
    private LocalDateTime updatedTime;

    /**
     * 描述
     */
    private String description;

}
