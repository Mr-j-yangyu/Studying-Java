package com.jwx.studying.spring;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * PackageName:com.jwx.studying.spring
 * FileName: Start.java
 * Description: TODO
 * Copyright: Copyright (c)2018
 * Company: songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/10
 */
public class Start implements ApplicationContextAware{

    ApplicationContext applicationContext;
    
    public static void main(String[] args){
        Start s =new Start();
        s.applicationContext.getBean("ReferenceBean");
        System.out.println(s.applicationContext.getBean("ServiceBean"));

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
