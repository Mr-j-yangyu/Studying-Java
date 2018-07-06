package com.jwx.studying.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Optional;

/**
 * PackageName:com.jwx.studying.guava
 * FileName: GuavaTest.java
 * Description: TODO
 * Copyright: Copyright (c)2018
 * Company: songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/6
 */
public class GuavaTest {

    public void _Optional(){
        Integer value1 =  null;
        Integer value2 =  new Integer(10);
        Optional<Integer> a = Optional.fromNullable(value1);
        System.out.println("_Optional()：a{}");
        Optional<Integer> b = Optional.of(value2);


    }

    public static void main(String[] args){  

    }  
}
