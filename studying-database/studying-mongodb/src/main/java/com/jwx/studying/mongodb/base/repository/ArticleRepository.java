package com.jwx.studying.mongodb.base.repository;

import com.jwx.studying.mongodb.base.entity.ArticleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.mongodb.base.repository
 * FileName: ArticleRepository.java
 * Copyright: Copyright (c)2019. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2019-02-14
 */
public interface ArticleRepository extends MongoRepository<ArticleEntity,String> {
}
