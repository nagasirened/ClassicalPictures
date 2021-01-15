package com.imageman.others.quartz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * author: ZGF
 * 01-2021/1/15 : 15:01
 * context :
 */
public class CustomSpringBeanUtils implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CustomSpringBeanUtils.applicationContext = applicationContext;
    }
}
