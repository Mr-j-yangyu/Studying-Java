package com.jwx.studying.jdk.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Description: java 泛型示例 <a href="https://blog.csdn.net/briblue/article/details/76736356">参考链接</a>
 *
 * <pre>
 *     1.广泛适用的类型，又称为参数化类型，将类型当做参数传递给一个类或者方法
 *     2.传统方法使用Object类型接受，运行后得到结果需要强转，不安全
 *     3.泛型信息存在于编译阶段，在jvm的Class中，类型擦除，替换成Object或者最高父类
 *     4.不能创建具体类型的泛型数组，无法确定数组元素的具体类型，只能通过通配符
 * </pre>
 *
 * <p>
 * PackageName:com.jwx.studying.jdk.generics <br/>
 * FileName: GenericeDemo.java <br/>
 * Copyright: Copyright (c)2018. songxiaocai <br/>
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/8/10
 */
public class GenericeDemo {

   /**
    * 包含了泛型类、泛型方法、泛型接口
    */
   static class Generics<T> {

      void method1(T t){

      }

      <E> void  method2(E e){

      }
   }

   /**
    * 通配符,collection不能写操作
    */
   static class Vildcard{
      void method1(Collection<? extends String> collection){
         //collection.add("1");
         //List<Integer>[] li2 = new ArrayList<Integer>[];
         //List<?>[] li3 = new ArrayList<?>[10];
      }
   }

   /**
    * 利用反射机制，绕过泛型限制
    */
   void test(){
      List<Integer> ls = new ArrayList<>();
      ls.add(23);
      try {
         Method method = ls.getClass().getDeclaredMethod("add", Object.class);
         method.invoke(ls, "test");
         method.invoke(ls, 42.9f);
      }catch (Exception e){
         e.printStackTrace();
      }
      for ( Object o: ls){
         System.out.println(o);
      }

   }

   public static void main(String[] args){

   }
}