package com.jwx.studying.mongodb.base.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.mongodb.base
 * FileName: ArticleEntity.java
 * Copyright: Copyright (c)2019. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2019-02-14
 */

@Document(collection = "article")
public class ArticleEntity implements Serializable {


    private static final long serialVersionUID = 5484836306257369412L;
//
//    @Id
//    Integer id;

    @Id
    ObjectId id;

    @Field("title")
    String title;


    @Field("conetent")
    String conetent;

    @Field("gmtCreate")
    Date gmtCreate;

    @Field("commentList")
    List<CommentEntity> commentList;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConetent() {
        return conetent;
    }

    public void setConetent(String conetent) {
        this.conetent = conetent;
    }


    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
    }
}