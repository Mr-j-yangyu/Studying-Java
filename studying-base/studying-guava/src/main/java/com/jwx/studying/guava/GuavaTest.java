package com.jwx.studying.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.*;
import com.google.common.collect.*;
import com.jwx.studying.guava.entity.Student;
import sun.net.dns.ResolverConfiguration.Options;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * PackageName:com.jwx.studying.guava
 * FileName: GuavaTest.java
 * Description: guava库学习
 * Copyright: Copyright (c)2018
 * Company: songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/6
 */
public class GuavaTest {

    /**
     *  利用Optional 使用或者避免null值
     *
     * @param
     * @return void
     * @author jiwenxiang
     * @date 2018/8/3
     */
    public void _Optional(){
        Integer rs = 1;

        //如果非空，返回一个包含引用Optional实例
        Optional<Integer> a = Optional.fromNullable(rs);

        //返回true，如果包含一个(非空)的实例
        a.isPresent();

        //返回包含给定的非空引用Optional实例
        Optional<Integer> b= Optional.of(rs);

        //返回包含的实例
        b.get();

        //返回所包含的实例(如果存在);否则为默认值
        Integer c = b.or(1);

        //返回所包含的实例(如果存在);否则返回null
        Integer d = b.orNull();

        System.out.println(String.format("Optional.of()：%s", JSON.toJSONString(b)));

    }

    /**
     * 利用Preconditions 进行参数前置校验
     *
     * @param
     * @return void
     * @author jiwenxiang
     * @date 2018/8/3
     */
    public void _Preconditions(){
        List<Integer> tmpList = Lists.newArrayList(1,2,3,4);
        Integer tmp =1;

        //检查表达式是否为true
        Preconditions.checkArgument(tmp!=null,"表达式false" );

        //检查对象是否为空
        Preconditions.checkNotNull(tmp,"参数为空");

        //校验元素的索引值是否有效，index大于等于0小于size
        Preconditions.checkElementIndex(3,tmpList.size(),"数组越界");

        //校验大于等于start，小于end的list的长度是否为size。
        Preconditions.checkPositionIndexes(0,2, tmpList.size());

    }

    /**
     * 利用Joiner 对字符串进行分割合并（线程安全，返回新实例）
     *
     * @param
     * @return void
     * @author jiwenxiang
     * @date 2018/8/3
     */
    public void _Joiner(){
        String tmpStr ="";

        /**
         * 字符串拼接
         * Before:
         *      StringBuilder builder= new StringBuilder();
         *      for (String s : strings) {
         *          builder.append(s);
         *          if (strings.indexOf(s) + 1 != strings.size()) {
         *              builder.append(",");
         *          }
         *      }
         */
        List<String> tmpStrList = Lists.newArrayList("a",null,"b","c");
        tmpStr = Joiner.on(",")
                        .skipNulls()
                        //.useForNull("空")
                        .join(tmpStrList);


        Map<String,String> map = Maps.newHashMap();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        tmpStr = Joiner.on("&")
                        .withKeyValueSeparator("=")
                        .join(map);
        System.out.println(tmpStr);
    }

    /**
     * 分割操作字符串，对象 （线程安全，返回新实例）
     *
     * @param
     * @return void
     * @author jiwenxiang
     * @date 2018/8/3
     */
    public void _Splitter(){

        List<String> tmpList =null;
        //分割字符串
        tmpList = Splitter.on("&")
                        .trimResults() //去首尾空格
                        .omitEmptyStrings() //去空字符串
                        .limit(3)  //限制分割个数，超过停止分割
                        .trimResults(CharMatcher.DIGIT) //过滤数字字符，或者给正则表达式
                        .splitToList( " ha&1&s&c");
        System.out.println(tmpList.toString());

        //切割成map
        Map<String,String> tmpMap  =  Splitter.on("&")
                .withKeyValueSeparator("=")
                .split("'key1=value1&key2=value2&key3=value3");
        System.out.println(tmpMap.toString());

    }

    /**
     * 集合相关封装类
     *
     * @param
     * @return void
     * @author jiwenxiang
     * @date 2018/8/5
     */
    public void _CollectionTool(){
        //继承Collection<E>接口，无序+可重复 count()方法获取单词的次数 增强了可读性+操作简单
        Multiset<Integer> multiset = HashMultiset.create(Lists.newArrayList(1,2,3,4,5,1,3));
        //multiset.remove(1,1);
        for (Object element : multiset.elementSet()) {
            System.out.println(element + ":" + multiset.count(element));
        }
        //双向Map,供键到值的映射，也提供值到键的映射
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("星期一","Monday");
        biMap.put("星期二","Tuesday");
        biMap.put("星期三","Wednesday");
        System.out.println("星期一的英文名是" + biMap.get("星期一"));
        System.out.println("Monday的中文是" + biMap.inverse().get("Monday"));

        //一键多值的Map，Map<K, Collection<V>>
        Multimap<String, String> myMultimap = ArrayListMultimap.create();
        myMultimap.put("Fruits", "Bannana");
        myMultimap.put("Fruits", "Apple");
        System.out.println( myMultimap.get("Fruits"));

        //二维表结构：<行，列，值>
        Table<Integer, Integer, String> table = HashBasedTable.create();
        for (int row = 0; row < 10; row++) {
             for (int column = 0; column < 5; column++) {
                      table.put(row, column, "value of cell (" + row + "," + column + ")");
             }
        }
        System.out.println(table.get(1,2));


        //list转为Multimap
        List<Student> list =Lists.newArrayList(new Student(1,"ji"),new Student(2,"wen"),new Student(3,"xiang"));
        //ListMultimap
        ImmutableListMultimap<Integer,Student>  m= Multimaps.index(list,Student::getId);
        Map m2 =list.stream().collect(Collectors.groupingBy(Student::getId));
    }


    public static void main(String[] args){
        new GuavaTest() //._Optional();
                        //._Preconditions();
                        //._Joiner();
                        //._Splitter();
                        ._CollectionTool();
    }
}
