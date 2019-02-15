package com.jwx.studying.mongodb.base.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.mongodb.base
 * FileName: CommentEntity.java
 * Copyright: Copyright (c)2019. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2019-02-13
 */
public class CommentEntity implements Serializable {


    private static final long serialVersionUID = 6753659334017244046L;

    Integer id;

    String content;

    String persionId;

    Date gmtCreate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPersionId() {
        return persionId;
    }

    public void setPersionId(String persionId) {
        this.persionId = persionId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}