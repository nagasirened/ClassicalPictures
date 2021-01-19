package com.imageman.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.access.annotation.Secured;

import java.io.Serializable;

/**
 * <p>
 * 用户角色表 用户角色表
 * </p>
 *
 * @author ZengGuangfu
 * @since 2021-01-18
 */
@Data
@TableName("i_employee_role")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRole extends Model<EmployeeRole> {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户
     */
    private String employeeId;

    /**
     * 角色
     */
    private Integer roleId;

}
