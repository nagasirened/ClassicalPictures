package com.imageman.common.config.aspect;

import com.imageman.common.config.system.CustomException;
import com.imageman.common.config.system.MsgExample;
import com.imageman.common.config.system.ResponseVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: ZGF
 * 06-2020/6/29 : 17:38
 * context : 全局的错误拦截器
 */
@ResponseBody
@ControllerAdvice
public class ControllerAdvance {

    @ExceptionHandler(Exception.class)
    public ResponseVO handle(Exception e){
        e.printStackTrace();
        if (e instanceof CustomException){
            CustomException exception = (CustomException)e;
            return ResponseVO.error(exception, "");
        }else if (e instanceof NullPointerException){
            return new ResponseVO(MsgExample.REQUEST_FAILD.getCode(), "空指针异常");
        }else {
            return new ResponseVO(MsgExample.SERVER_ERROR);
        }
    }
}
