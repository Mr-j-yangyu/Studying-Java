package com.jwx.studying.spring.LoadingOrder;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.spring.LoadingOrder
 * FileName: Start.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018-12-25
 */

@ComponentScan(value = {"com.jwx.studying.spring"})
public class Start  {


    public static void main(String[] args){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Start.class);
        MyBean myBean =ctx.getBean(MyBean.class);

        System.out.println(myBean.getClass());
        ctx.close();

    }

}