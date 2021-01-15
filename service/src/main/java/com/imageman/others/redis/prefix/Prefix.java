package com.imageman.others.redis.prefix;


/**
 * 前置条件接口
 */
public interface Prefix {

    public int expire();

    public void setExpire(int expire);

    public String getPrefix();
}
