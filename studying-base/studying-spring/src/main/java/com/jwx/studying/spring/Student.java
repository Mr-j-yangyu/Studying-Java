package com.jwx.studying.spring;

import com.jwx.studying.spring.FactoryBean.DemoFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.spring.FactoryBean
 * FileName: Student.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/11/22
 */

public class Student {

    String  name;

    int age;

    public Student(String name, int age){
        this.age=age;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}