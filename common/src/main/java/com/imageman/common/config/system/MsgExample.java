package com.imageman.common.config.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * author: ZGF
 * 06-2020/6/29 : 17:49
 * context : 返回结果初始类
 */

@AllArgsConstructor
public class MsgExample {

    @Getter
    private Integer code;

    @Getter
    private String msg;

    public static MsgExample SUCCESS = new MsgExample(200, "成功");

    /**
     * 以下是错误分类，自定义新增
     */
    public static MsgExample SERVER_ERROR = new MsgExample(500, "系统出错");
    public static MsgExample PARAM_ERROR = new MsgExample(100001, "参数有问题");
    public static MsgExample OBJECT_NOT_EXIT = new MsgExample(100002, "对象不存在");
    public static MsgExample USER_NOT_EXIT = new MsgExample(100003, "用户不存在");
    public static MsgExample SESSION_MANAGER_ERROR = new MsgExample(100004, "session出错，请重新登录");
    public static MsgExample REQUEST_FAILD = new MsgExample(100005, "操作失败");

    // 用户
    public static MsgExample LOGINNAME_EXIT_YET = new MsgExample(200001, "用户名已存在");
    public static MsgExample NEED_LOGIN = new MsgExample(200002, "需要登录");
}
