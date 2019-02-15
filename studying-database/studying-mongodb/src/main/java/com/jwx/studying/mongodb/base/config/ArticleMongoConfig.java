package com.jwx.studying.mongodb.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.mongodb.base.config
 * FileName: ArticleMongoConfig.java
 * Copyright: Copyright (c)2019. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2019-02-14
 */

@Configuration
//指定目录下使用某数据源
//@EnableMongoRepositories(basePackages = {"com.jwx.studying.mongodb.base"}, mongoTemplateRef = "basicMongoTemplate")
@PropertySource(value = "classpath:application.yml")
@EnableConfigurationProperties(ArticleMongoConfig.class)
@ConfigurationProperties(prefix = "spring.data.mongodb.primary")
public class ArticleMongoConfig extends AbstractMongoConfig{

    @Override
    @Primary
    @Bean(name = "mongoTemplate")
    public MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

}