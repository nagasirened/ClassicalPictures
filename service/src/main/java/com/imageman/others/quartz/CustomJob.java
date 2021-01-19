package com.imageman.others.quartz;

import com.imageman.service.ProductService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.IOException;

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
        try {
            productService.dailyRecommended();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
