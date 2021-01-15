package com.imageman.others.quartz.spring;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * author: ZGF
 */
// @Configuration
public class JobDetailInit2 {
    @Bean
    public JobDetail jobDetail2(){
        return JobBuilder.newJob(CustomJob.class)
                .storeDurably()
                .withIdentity("productJob", "prod")
                .build();
    }

    @Bean
    public Trigger trigger2(){
        return TriggerBuilder.newTrigger()
                .withIdentity("tragger1", "prod")
                .forJob("productJob", "prod")
                .startNow().build();
    }

}
