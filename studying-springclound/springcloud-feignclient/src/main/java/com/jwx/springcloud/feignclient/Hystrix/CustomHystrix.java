package com.jwx.springcloud.feignclient.Hystrix;

import com.jwx.springcloud.feignclient.HelloClient;
import org.springframework.stereotype.Component;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.springcloud.feignclient.Hystrix
 * FileName: CustomHystrix.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/26
 */
@Component
public class CustomHystrix implements HelloClient{
    public String sayChineseHello(String user) {
        return "sory,,";
    }

    public String sayEnglishHello(String user) {
        return "sory,,";
    }
}