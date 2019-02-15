package com.jwx.studying.mongodb.base.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Description: TODO
 * <p>
 * PackageName:com.jwx.studying.mongodb.base.config
 * FileName: MongoMainConfiguration.java
 * Copyright: Copyright (c)2019. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2019-02-14
 */

@Configuration
@ComponentScan(value = {"com.jwx.studying.mongodb.base.*"
})
@EnableAsync
public class MongoMainConfiguration {
}