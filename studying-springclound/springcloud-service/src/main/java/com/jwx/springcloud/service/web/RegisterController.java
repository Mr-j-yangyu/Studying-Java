package com.jwx.springcloud.service.web;

import com.jwx.studying.common.utils.HostUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: eurka注册测试Controller
 * <p>
 * PackageName:com.jwx.springcloud.server.web
 * FileName: RegisterController.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/25
 */
@RefreshScope
@RestController
public class RegisterController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a) {
        List<ServiceInstance> instance = discoveryClient.getInstances(HostUtil.getHostAddress());
        instance.stream().forEach(
             param->System.out.println(param.getUri())
        );
        return 0;

    }
}