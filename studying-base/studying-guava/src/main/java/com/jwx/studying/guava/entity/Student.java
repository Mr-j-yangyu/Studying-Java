package com.jwx.studying.guava.entity;
import lombok.Builder;
import lombok.Data;

/**
 * PackageName:com.jwx.studying.guava.entity
 * FileName: Student.java
 * Description: TODO
 * Copyright: Copyright (c)2018
 * Company: songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/6
 */

@Data
@Builder
public class Student {

    /**
     *  学号id
     */
    private Integer id;

    /**
     *  姓名name
     */
    private String name;

    /**
     *  分数score
     */
    private Double score;

    /**
     *  年龄years
     */
    private Integer years;

    /**
     *  性别sex（1：男，2：女）
     */
    private Integer sex;



}
