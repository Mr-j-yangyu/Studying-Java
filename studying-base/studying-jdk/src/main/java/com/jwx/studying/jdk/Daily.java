package com.jwx.studying.jdk;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.jdk
 * FileName: Daily.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/8/23
 */
public class Daily {


    public  static void printSize(String name,Long data){
        System.out.println(name+"-"+data);
    };


    public static void main(String[] args) {


     /*   List<Integer> list = Collections.emptyList();
        Set<Integer> set = list.stream().filter(e -> e > 2).collect(Collectors.toSet());
        System.out.println(JSON.toJSONString(set));

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Map<Integer, Integer> list2 = list.stream().collect(Collectors.toMap(e -> (e + 1), e -> e));
        System.out.println(new Date(1535438124481L));
        List<Integer> list3 = Lists.newArrayList(1, 2, 3);
        List<Integer> list4 = Lists.newArrayList(2,3);
        list3.removeAll(list4);
        System.out.println(JSON.toJSONString(list3));
        list3.stream().forEach(e->{
            System.out.println(e);

        });
        Daily.printSize("new LinkedList", ObjectSizeCalculator.getObjectSize(new LinkedList<Integer>()));
        Daily.printSize("new ArrayList",  ObjectSizeCalculator.getObjectSize(new ArrayList<Integer>()));
        Daily.printSize("Lists.newArrayList",  ObjectSizeCalculator.getObjectSize(Lists.newArrayList()));

*/        ArrayList<String> arraylist = new ArrayList<String>();
        LinkedList<String> linkedlist = new LinkedList<String>();
        Random random = new Random();
        long begin = System.currentTimeMillis();
        for(int i=0;i<5000;i++){
            arraylist.add(Long.toString(random.nextLong(), 36));
        }
        System.out.println("arraylist add(n) time "+(System.currentTimeMillis()-begin));


        begin = System.currentTimeMillis();
        for(int j=0;j<5000;j++){
            linkedlist.add(Long.toString(random.nextLong(), 36));
        }
        System.out.println("linkedlist add(n) time "+(System.currentTimeMillis()-begin));

        begin = System.currentTimeMillis();
        for(String s:arraylist){
        }
        System.out.println("arraylist for time "+(System.currentTimeMillis()-begin));

        begin = System.currentTimeMillis();
        for(String s:linkedlist){
        }
        System.out.println("linkedlist for time "+(System.currentTimeMillis()-begin));

        begin = System.currentTimeMillis();
        arraylist.stream().forEach(e->{});
        System.out.println("arraylist foreach time "+(System.currentTimeMillis()-begin));

        begin = System.currentTimeMillis();
        linkedlist.stream().forEach(e->{});
        System.out.println("linkedlist foreach time "+(System.currentTimeMillis()-begin));

    }

}