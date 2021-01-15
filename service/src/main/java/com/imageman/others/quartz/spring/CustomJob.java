package com.imageman.others.quartz.spring;

import com.imageman.service.ProductService;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.StringJoiner;

/**
 * author: ZGF
 */

public class CustomJob extends QuartzJobBean {

    /**
     * springBoot-Quartz 可以注入Bean
     */
    @Autowired
    private ProductService productService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("=============================");
        StringJoiner joiner = new StringJoiner(" ");
        joiner.add(Thread.currentThread().getName())
              .add(String.valueOf(System.currentTimeMillis()))
              .add(productService.toString());
        System.out.println(joiner.toString());
        System.out.println("=============================");
    }
}
