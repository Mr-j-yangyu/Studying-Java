package com.jwx.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description: dubbo生产者启动类
 * <p>
 * PackageName:com.jwx.dubbo.provider
 * FileName: Start.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/23
 */
public class Start {
    public static void main(String[] args){
        try{
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context-provider.xml");
            System.out.println(context.getDisplayName() + ": here");
            context.start();
            System.out.println("服务已经启动...");
            System.in.read();
        }catch(Exception e){
            e.printStackTrace();
        }
    }  
}