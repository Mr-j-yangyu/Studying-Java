package com.jwx.studying.mongodb.base.repository;

import com.jwx.studying.mongodb.base.entity.ArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.mongodb.base.repository
 * FileName: ArticleDaoImpl.java
 * Copyright: Copyright (c)2019. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2019-02-14
 */

@Repository
public class ArticleDaoImpl {

    @Autowired
    @Qualifier(value = "mongoTemplate")
    MongoTemplate mongoTemplate;


//    @Autowired
//    ArticleRepository articleRepository;


    public boolean saveArticle(ArticleEntity articleEntity){

       mongoTemplate.save(articleEntity);
       return true;
    }


    public ArticleEntity findByFieldVal(String field, String val){

        Query query=new Query(Criteria.where(field).is(val));

        ArticleEntity articleEntity =  mongoTemplate.findOne(query, ArticleEntity.class);
        return  articleEntity;
    }


    public Boolean updateArticle(ArticleEntity articleEntity){

        Query query=new Query(Criteria.where("id").is(articleEntity.getId()));

        Update update= new Update();
        update.set("title",articleEntity.getTitle());
        update.set("gmtCreate",new Date());
        mongoTemplate.updateFirst(query,update,ArticleEntity.class);

        return true;
    }
    public void deleteUserById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,ArticleEntity.class);
    }

}