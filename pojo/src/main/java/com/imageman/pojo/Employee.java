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
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "参数出错，请重试", groups = UpdateGroup.class)
    private String id;

    /**
     * 昵称
     */
    @NotEmpty(message = "姓名不能为空", groups = InsertGroup.class)
    private String username;

    /**
     * 密码
     */
    @NotEmpty(groups = InsertGroup.class, message = "密码不能为空")
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
    private LocalDateTime birthday;

    /**
     * 其他异常状态 0正常  1冻结  待拓展
     */
    private Integer accountStatus;

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
