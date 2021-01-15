package com.imageman.common.config.mp;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: ZGF
 * 06-2020/6/29 : 17:08
 * context : 配置文件
 */

@Configuration
public class MPconfiguration {

    /**
     * 分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
