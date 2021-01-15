package com.imageman.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * author: ZGF
 * context : 启动类
 */
@ComponentScan(basePackages = {"com.imageman"/*, "org.springframework.boot.autoconfigure.admin", "com.katouyi.securitytest"*/ })
@MapperScan(basePackages = "com.imageman.mapper")
@SpringBootApplication
@EnableSwagger2
public class ImageManApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageManApplication.class, args);
    }

    @Value("${swagger.enabled}")
    private boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.imageman.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api文档的详细信息函数
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("迈图网")
                .description("接口文档")
                .version("1.0")
                .build();
    }
}
