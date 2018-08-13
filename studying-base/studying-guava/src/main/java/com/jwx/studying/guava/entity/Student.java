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

    public Student(Integer id,String name){
        this.id = id;this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
