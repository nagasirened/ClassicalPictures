package com.imageman.others.quartz.spring;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * author: ZGF
 */

@Component
public class JobDetailInit  {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void initJob() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(CustomJob.class)
                .withIdentity("productJob", "prod")
                .build();

        Trigger build = TriggerBuilder.newTrigger().withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(100)
                .repeatForever()
        ).build();

        scheduler.scheduleJob(jobDetail, build);
    }
}
