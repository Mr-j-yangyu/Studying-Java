package com.jwx.studying.mongodb.base;

import com.alibaba.fastjson.JSON;
import com.jwx.studying.mongodb.BaseTest;
import com.jwx.studying.mongodb.base.entity.ArticleEntity;
import com.jwx.studying.mongodb.base.entity.CommentEntity;
import com.jwx.studying.mongodb.base.repository.ArticleDaoImpl;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.mongodb.base
 * FileName: ArticleDaoImplTest.java
 * Copyright: Copyright (c)2019. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2019-02-14
 */
public class ArticleDaoImplTest extends BaseTest {

    @Autowired
    ArticleDaoImpl articleDaoImpl;


    @org.junit.Test
    public void saveArticle() {

        ArticleEntity articleEntity = new ArticleEntity();
//        articleEntity.setId(2);
        articleEntity.setTitle("测试文章1");
        articleEntity.setGmtCreate(new Date());

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setContent("评论1");
        commentEntity.setPersionId("49");
        commentEntity.setGmtCreate(new Date());
        articleEntity.setCommentList(Lists.newArrayList(commentEntity));
        articleDaoImpl.saveArticle(articleEntity);
    }

    @org.junit.Test
    public void findByFieldVal() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date(articleDaoImpl.findByFieldVal("id","5c66349c60bd927d215a8bea").getGmtCreate().getTime()));

        System.out.println("==========="+time );

    }

    @org.junit.Test
    public void updateArticle() {
    }

    @org.junit.Test
    public void deleteUserById() {
    }

}