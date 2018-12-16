package com.jwx.studying.jdk.innerclass;

import java.util.ArrayList;

/**
 * Description: Java内部类 <a href="https://blog.csdn.net/zhangjg_blog/article/details/20000769">参考链接</a>
 *
 * <pre>
 *
 *   可以拿到外部类引用
 *
 *     1 编译器自动为内部类添加一个成员变量， 这个成员变量的类型和外部类的类型相同， 这个成员变量就是指向外部类对象的引用；
 *
 *     2 编译器自动为内部类的构造方法添加一个参数， 参数的类型是外部类的类型， 在构造方法内部使用这个参数为1中添加的成员变量赋值；
 *
 *     3 在调用内部类的构造函数初始化内部类对象时， 会默认传入外部类的引用
 *
 * </pre>
 *
 *
 * <p>
 * PackageName:com.jwx.studying.jdk.innerclass
 * FileName: Outer.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/8/15
 */
public class Outer {

    private  Integer privateOut;

    public Integer pulicOut;

    private static Integer staticOut;

    public Inner returnInner(){
        return  new Inner();
    }

    /**
     * 可以拿到内部类所有成员变量属性值、方法
     */
    public void getInnerParam(){
        Integer a=  new Inner().privateIn;
        Integer b= new  StaticInner().pulicStaticIn;
    }


    private  class Inner{

        private Integer privateIn;

        public Integer pulicIn;

        /**
         * 拿到外部类成员变量属性值、方法
         *
         * <p>
         *  list数组和iterator迭代器关系 {@link ArrayList#iterator()}.
         *  通过返回实现iterator接口的私有内部类，在函数中引用父类List中数据
         *
         */
        public void getOuterParam(){
            privateIn = Outer.this.privateOut;
        }

    }

    /**
     * 1.静态内部类可以有静态成员(方法，属性)，而非静态内部类则不能有静态成员(方法，属性)。
     * 2.静态内部类只能够访问外部类的静态成员,而非静态内部类则可以访问外部类的所有成员(方法，属性)。
     *
     */
    private static class StaticInner{

        private static  Integer privateStaticIn;

        public Integer pulicStaticIn;

    }

    
    public static void main(String[] args){
       Outer.Inner o = new Outer().returnInner();
       Outer.StaticInner si = new Outer.StaticInner();

    }  
}