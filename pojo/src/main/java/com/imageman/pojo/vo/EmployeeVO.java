package com.imageman.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * author: ZGF
 * context : 用户信息拓展返回
 */
@Data
public class EmployeeVO {

    /**
     * 主键 主键
     */
    private String id;

    /**
     * 昵称
     */
    private String username;

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
     * 其他状态 0正常  1冻结  待拓展
     */
    private Integer accountStatus;

    /**
     * 创建时间 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间 更新时间
     */
    private LocalDateTime updatedTime;

    /**
     * 其他状态
     */
    private String accessStatusInfo;

    /**
     * 角色
     */
    private String roleName;
}
