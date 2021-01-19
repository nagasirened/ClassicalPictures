package com.imageman.common.example;

import lombok.Getter;

/**
 * 账号状态
 */
@Getter
public enum Sexy {

    MALE(1, "男"),
    FEMALE(2, "女"),
    ;

    private Integer code;

    private String gender;

    Sexy(Integer code, String gender) {
        this.code = code;
        this.gender = gender;
    }



}
