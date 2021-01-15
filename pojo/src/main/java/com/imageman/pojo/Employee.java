package com.imageman.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 用户 
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
@Data
@Builder
@TableName("i_employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Model<Employee> {

    private static final long serialVersionUID=1L;

    /**
     * 主键 主键
     */
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 昵称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String face;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 生日
     */
    private String birthday;

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

    @TableLogic
    private Integer flag;

}
