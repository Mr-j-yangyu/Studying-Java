package com.jwx.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.jwx.dubboclient.provider.ProviderA;

/**
 * Description: dubbo提供者类
 * <p>
 * PackageName:com.jwx.dubbo.provider
 * FileName: ProviderAImpl.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/22
 */
@Service(version = "1.0.0.dev")
public class ProviderAImpl  implements ProviderA{

    /**
     * 测试方法
     *
     * @param
     * @return
     * @author jiwenxiang
     * @date 2018/7/22
     */
    @Override
    public String sayHello(String consumer) {
        return "hello " +consumer;
    }
}