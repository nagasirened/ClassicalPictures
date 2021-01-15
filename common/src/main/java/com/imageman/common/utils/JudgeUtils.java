package com.imageman.common.utils;


import com.imageman.common.config.system.CustomException;
import com.imageman.common.config.system.MsgExample;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * author: ZGF
 * 06-2020/6/30 : 17:25
 * context : 验证
 */

public class JudgeUtils {

    public static void isNull(Object... arg){
        for (int i = 0; i < arg.length; i++) {
            if (Objects.isNull(arg[i])){
                throw new CustomException(MsgExample.PARAM_ERROR);
            }
        }
    }

    public static void isEmpty(String... arg){
        for (int i = 0; i < arg.length; i++) {
            if (StringUtils.isEmpty(arg[i])){
                throw new CustomException(MsgExample.PARAM_ERROR);
            }
        }
    }
}
