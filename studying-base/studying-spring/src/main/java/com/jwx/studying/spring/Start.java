package com.jwx.studying.spring;

import com.google.common.collect.Lists;
import com.jwx.studying.spring.FactoryBean.DemoFactoryBean;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
