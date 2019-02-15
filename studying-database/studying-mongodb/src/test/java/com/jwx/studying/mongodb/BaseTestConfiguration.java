package com.jwx.studying.mongodb;

import com.jwx.studying.mongodb.base.config.MongoMainConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Description: TODO
 * <p>
 * PackageName:PACKAGE_NAME
 * FileName: com.jwx.studying.mongodb.BaseTestConfiguration.java
 * Copyright: Copyright (c)2019. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2019-02-14
 */

@Configuration
@EnableAutoConfiguration
@PropertySource({"classpath:application.yml"})
@Import(MongoMainConfiguration.class)
public class BaseTestConfiguration {
}