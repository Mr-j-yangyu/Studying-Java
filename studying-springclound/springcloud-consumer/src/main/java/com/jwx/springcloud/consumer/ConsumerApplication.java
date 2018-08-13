package com.jwx.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description: springcloud消费者启动类
 * <p>
 * PackageName:com.jwx.springcloud.consumer
 * FileName: ConsumerApplication.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/26
 */
@EnableEurekaClient
@EnableFeignClients  //开启feign客户端
@SpringBootApplication
@ComponentScan(basePackages={"com.jwx.springcloud.feignclient"})
public class ConsumerApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}