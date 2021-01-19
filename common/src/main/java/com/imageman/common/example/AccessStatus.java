package com.imageman.common.example;

import com.google.common.collect.Maps;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 账号状态
 */
@Getter
public enum AccessStatus {

    USEFUL(0, "可用"),
    FREEZE(1, "冻结"),
    ;

    private Integer status;

    private String describe;

    AccessStatus(Integer status, String describe) {
        this.status = status;
        this.describe = describe;
    }

    public static String getStatusName(Integer status){
        for (AccessStatus accessStatus : AccessStatus.values()) {
            if (accessStatus.getStatus() == status) {
                return accessStatus.getDescribe();
            }
        }
        return "";
    }

    public static Map<Integer, String> convertToMap(){
        HashMap<Integer, String> map = Maps.newHashMap();
        for (AccessStatus item : AccessStatus.values()) {
            map.put(item.getStatus(), item.getDescribe());
        }
        return map;
    }

}
