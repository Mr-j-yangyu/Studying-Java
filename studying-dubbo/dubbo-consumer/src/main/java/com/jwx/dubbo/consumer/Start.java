package com.jwx.dubbo.consumer;
import com.jwx.dubboclient.provider.ProviderA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Description: dubbo消费者启动类
 * <p>
 * PackageName:com.jwx.dubbo.consumer
 * FileName: Start.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/23
 */
public class Start {
    public static void main(String[] args){
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("application-context-consumer.xml");
            ProviderA a = (ProviderA) context.getBean("providerA");
            System.out.println(a.sayHello("jwx"));
            System.in.read();
        }catch(Exception e){
            e.printStackTrace();
        }
    }  
}