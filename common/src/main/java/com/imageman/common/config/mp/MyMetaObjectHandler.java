package com.imageman.common.config.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setFieldValByName("createdTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updatedTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("flag", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatedTime", LocalDateTime.now(), metaObject);
    }
}