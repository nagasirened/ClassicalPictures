package com.imageman.common.config.system;

import lombok.Data;

/**
 * author: ZGF
 * 06-2020/6/29 : 18:01
 * context :
 */

@Data
public class CustomException extends RuntimeException {

    private Integer code;

    private String msg;

    public CustomException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public CustomException(MsgExample msgExample){
        this.code = msgExample.getCode();
        this.msg = msgExample.getMsg();
    }

    public CustomException(String msg){
        this.code = MsgExample.SERVER_ERROR.getCode();
        this.msg = msg;
    }
}
