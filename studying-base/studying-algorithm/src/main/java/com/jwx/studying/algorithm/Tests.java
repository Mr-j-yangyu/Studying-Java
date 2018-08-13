package com.jwx.studying.algorithm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.algorithm
 * FileName: Tests.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/26
 */
public class Tests {



    public void merge( List<Integer> tempList,List<Integer> originList, List<Integer> mergeList){
        int size;
        if(originList.size()>=mergeList.size()){
            tempList = originList;
            size = mergeList.size();
        }else{
            tempList = mergeList;
            size = originList.size();
        }
        for(int i=0;i<size;i++){
            tempList.set(i,Integer.valueOf(originList.get(i).intValue() + mergeList.get(i).intValue()));
        }
    }
    public static void main(String[] args){
     /*  Tests a= new Tests();
       List  tempList = Lists.newArrayList(0,1,2,3);
       List originList =  Lists.newArrayList(0,1,2,3);
       List mergeList =  Lists.newArrayList(1,3,4,5,6,7));
      a.merge(tempList,originList,mergeList);*/
    }
}