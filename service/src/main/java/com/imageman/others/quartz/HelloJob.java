package com.imageman.others.quartz;

import com.imageman.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.StringJoiner;

public class HelloJob implements Job {

    /**
     * 曲线救国：获取一个Bean
     */
    private ProductService productService;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // StringUtils.uncapitalize(String)  首字母小写
        productService = (ProductService)CustomSpringBeanUtils.applicationContext
                .getBean(StringUtils.uncapitalize(ProductService.class.getSimpleName()));

        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add(jobExecutionContext.getTrigger().getKey().getName())
                .add("当前时间" + System.currentTimeMillis())
                .add(Thread.currentThread().getName());
        System.out.println(stringJoiner.toString());
    }
}