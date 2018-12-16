package com.jwx.studying.spring.FactoryBean;

import com.jwx.studying.spring.Student;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.spring.FactoryBean
 * FileName: DemoFactoryBean.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/11/22
 */
@com.alibaba.dubbo.config.annotation.Service
public class DemoFactoryBean implements FactoryBean<Student>{


    @Override
    public Student getObject() throws Exception {
        return new Student("jwx", 21);
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}