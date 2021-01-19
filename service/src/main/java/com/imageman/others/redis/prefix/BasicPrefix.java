package com.imageman.others.redis.prefix;

/**
 * <p>
 *
 * @description: 认证用户信息
 * </p>
 * @author: ZengGuangfu
 */
public class BasicPrefix extends BasePrefix{

    public BasicPrefix(int expireTime, String prefixStr){
        super(expireTime, prefixStr);
    }

    public BasicPrefix(String prefixStr){
        super(0, prefixStr);
    }

    public static BasicPrefix CATEGORY_STORE_KEY = new BasicPrefix(-1, "category:all:");

    public static BasicPrefix DAILY_RECOMMENDED_PRODUCT = new BasicPrefix(24 * 60 * 60 + 60, "daily:recommend:");
}
