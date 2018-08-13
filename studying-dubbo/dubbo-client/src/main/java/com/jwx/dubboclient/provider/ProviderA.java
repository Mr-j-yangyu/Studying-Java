package com.jwx.dubboclient.provider;

/**
 * Description: dubbo测试接口类
 * <p>
 * PackageName:com.jwx.dubboclient.provider
 * FileName: ProviderA.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/20
 */
public interface ProviderA {
    /**
     * 测试方法
     *
     * @param consumer
     * @return String
     * @author jiwenxiang
     * @date 2018/7/22
     */
    String sayHello(String consumer);

}