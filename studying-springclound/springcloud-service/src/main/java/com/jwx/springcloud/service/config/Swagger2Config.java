package com.jwx.springcloud.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description: RESTful API文档自动生成工具Swagger2配置类
 * <p>
 * PackageName:com.jwx.springcloud.server.config
 * FileName: Swagger2Config.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/25
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jwx.springcloud.service.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建 RESTful APIs")
                .description("更多相关信息请访问：https://github.com/Mr-j-yangyu")
                .termsOfServiceUrl("https://github.com/Mr-j-yangyu")
                .contact(new Contact("纪文翔", "https://github.com/Mr-j-yangyu", "jwx_email@163.com"))
                .version("1.0")
                .build();
    }
}