package com.jwx.springcloud.feignclient;

import com.jwx.springcloud.feignclient.Hystrix.CustomHystrix;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//默认启用ribbon轮询机制，客户端实现负载均衡
//fallback ,服务不可用时，避免阻塞，启用熔断器机制 ，在消费者配置文件中开启
@Component
@FeignClient(value = "springcloud-service",fallback = CustomHystrix.class)
public interface HelloClient {

    @RequestMapping(value = "/hello/chinese",method = RequestMethod.POST)
    String sayChineseHello(@RequestParam String user);

    @RequestMapping(value = "/hello/english",method = RequestMethod.POST)
    String sayEnglishHello(@RequestParam String user);

}
