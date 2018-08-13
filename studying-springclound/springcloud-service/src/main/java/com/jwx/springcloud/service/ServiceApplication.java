package com.jwx.springcloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description: springcloud服务提供者启动类
 *      http://localhost:8895/swagger-ui.html 查看api定义
 *
 * <p>
 * PackageName:com.jwx.springcloud.service
 * FileName: ServerApplication.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/25
 */
@SpringBootApplication
@EnableEurekaClient  //开启服务注册中心 @EnableEurekaClient ，eureka中心
public class ServiceApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServiceApplication.class, args);

    }
}