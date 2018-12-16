package com.jwx.studying.jdk.equals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * Description: 自定义重写equals 方法
 *
 *
 *   首先equals与hashcode（Object hanshcode返回的是当前对象的内存地址）间的关系是这样的：
 *      1、比较方法一致，都是比较对象的内存地址
 *
 *   why 重写equals必须重写 hashcode？
 *      1、如果两个对象根据equals（Object）方法相等，则对两个对象中的每一个调用hashCode方法必须生成相同的整数结果。
 *      2、如果两个对象根据equals（java.lang.Object）方法不相等，则不需要在两个对象中的每一个上调用hashCode方法必须生成不同的整数结果
 *      在HashSet和Map集合类型中，根据对象的hashCode 的值决定存储位置，在这类集合中，通过equals 和hashCode 比较都相等，判定对象相等
 *
 * <p>
 * PackageName:com.jwx.studying.jdk.equals
 * FileName: Student.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/11/1
 */
public class Student {

    private Integer id;

    private String name;

    private String score;


    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;
        if (obj == null) return false;

        if (!(obj instanceof Student)) {
            return false;
        }

        Student st = (Student)obj;
        return Objects.equals(id, st.id) &&
                Objects.equals(name, st.name) &&
                Objects.equals(score, st.score);

    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name,score);
    }

    @Override
    public String toString(){
        return Objects.toString(this);
    }
}