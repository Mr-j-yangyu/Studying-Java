package com.jwx.springcloud.consumer.web;

import com.jwx.springcloud.feignclient.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 消费者controller
 * <p>
 * PackageName:com.jwx.springcloud.consumer.web
 * FileName: ConsumerController.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/26
 */
@RefreshScope
@RestController
@RequestMapping("/hello")
public class ConsumerController {

    @Autowired
    HelloClient helloClient;

    @RequestMapping(value = "/chinese/{user}" ,method = RequestMethod.GET)
    public String sayChinese(@PathVariable String user) {
        return helloClient.sayChineseHello(user);
    }

    @RequestMapping(value = "/english/{user}" ,method = RequestMethod.GET)
    public String sayEnglish(@PathVariable String user) {
        return helloClient.sayChineseHello(user);
    }
}