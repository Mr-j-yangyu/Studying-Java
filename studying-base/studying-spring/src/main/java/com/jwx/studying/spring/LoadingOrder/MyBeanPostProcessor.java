package com.jwx.studying.spring.LoadingOrder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.spring.LoadingOrder
 * FileName: MyBeanPostProcessor.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018-12-25
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("BeanPostProcessor...postProcessBeforeInitialization:"+beanName+"..."+bean+"..bean class"+bean.getClass()+"bean superclass" + bean.getClass().getSuperclass());
        return bean;
    }




    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("BeanPostProcessor...postProcessAfterInitialization:"+beanName+"..."+bean);
        return bean;

    }
}