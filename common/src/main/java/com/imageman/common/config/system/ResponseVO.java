package com.imageman.common.config.system;

import lombok.Data;

/**
 * author: ZGF
 * 06-2020/6/29 : 17:46
 * context : 统一结果返回
 */

@Data
public class ResponseVO<T> {

    private Integer code;

    private String msg;

    private T result;

    public ResponseVO(){ }

    public ResponseVO(T result){
        this.result = result;
    }

    public ResponseVO(Integer code, String msg){
        this.code = code;
        this.msg = msg;
        this.result = null;
    }

    public ResponseVO(MsgExample msgExample){
        this.code = msgExample.getCode();
        this.msg = msgExample.getMsg();
        this.result = null;
    }

    public ResponseVO(Integer code, String msg, T sth){
        this.code = code;
        this.msg = msg;
        this.result = sth;
    }

    public ResponseVO(MsgExample msgExample, T result){
        this.code = msgExample.getCode();
        this.msg = msgExample.getMsg();
        this.result = result;
    }

    public static <T> ResponseVO succ(T result){
        return new ResponseVO(MsgExample.SUCCESS.getCode(), MsgExample.SUCCESS.getMsg(), result);
    }

    public static <T> ResponseVO succ(){
        return new ResponseVO(MsgExample.SUCCESS.getCode(), MsgExample.SUCCESS.getMsg(), null);
    }

    public static <T> ResponseVO error(T result){
        return new ResponseVO(MsgExample.SERVER_ERROR.getCode(), MsgExample.SERVER_ERROR.getMsg(), result);
    }

    public static <T> ResponseVO error(CustomException e, T result){
        return new ResponseVO(e.getCode(), e.getMsg(), result);
    }

}
