package com.jwx.studying.spring.LoadingOrder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.spring.LoadingOrder
 * FileName: MyBean.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018-12-25
 */

@Component
public class MyBeanImpl implements MyBean,BeanNameAware, BeanFactoryAware, ApplicationContextAware,InitializingBean, DisposableBean {


    private MySubBean mySubBean;

    public MySubBean getMySubBean() {
        return mySubBean;
    }

    @Autowired
    public void setMySubBean(MySubBean mySubBean) {
        System.out.println("property init");
        this.mySubBean = mySubBean;
    }

    public MyBeanImpl(){

        System.out.println("MyBean instance");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean....destroy");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean...afterPropertiesSet");

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware...setBeanFactory()");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware...setBeanName: "+s);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware...setApplicationContext()");
    }

    @PostConstruct
    public void init(){
        System.out.println("MyBean....@PostConstruct...");
    }

    //容器移除对象之前
    @PreDestroy
    public void detory(){
        System.out.println("MyBean....@PreDestroy...");
    }


}