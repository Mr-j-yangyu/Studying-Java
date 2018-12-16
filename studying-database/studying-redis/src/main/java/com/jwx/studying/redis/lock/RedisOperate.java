package com.jwx.studying.redis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Description: redis常用操作
 * <p>
 * PackageName:com.jwx.studying.redis.lock
 * FileName: RedisOperate.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/11/15
 */
public class RedisOperate {

    /**
     * 继承自RedisTemplate，采用StringRedisSerializer序列化，适合字符串数据存储
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 继承自RedisTemplate，采用JdkSerializationRedisSerializer 序列化，适合复杂对象类型存取
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 字符串操作
     */
    private void StringOp(){

        //向redis里存入数据和设置缓存时间
        stringRedisTemplate.opsForValue().set("studying_redis_string_key","jwx",69, TimeUnit.SECONDS);

        //根据key获取过期时间
        stringRedisTemplate.getExpire("studying_redis_string_key");

        //设置键的字符串值并返回其旧值
        stringRedisTemplate.opsForValue().getAndSet("studying_redis_string_key","oldVal");

        //检查key是否存在
        stringRedisTemplate.hasKey("546545");

        //设置key失效时间
        stringRedisTemplate.expire("studying_redis_string_key",1,TimeUnit.SECONDS);
    }

    /**
     * 列表操作(链表结构)
     */
    private void ListOp(){
        // 依次由右边添加
        stringRedisTemplate.opsForList().rightPush("studying_redis_list","1");

        // 查询所有元素
        stringRedisTemplate.opsForList().range( "studying_redis_list", 0, -1);

        //从左取出第一个元素
        stringRedisTemplate.opsForList().leftPop("studying_redis_list");

        //删除所有A元素
        stringRedisTemplate.opsForList().remove("studying_redis_list",0, "A");

        //得到列表第几个元素
        stringRedisTemplate.opsForList().index("studying_redis_list",1);

    }

    /**
     * 集合操作
     */
    private void SetOp(){
        //得到key的元素集合
        stringRedisTemplate.opsForSet().members("studying_redis_set");

        //是否包含元素
        stringRedisTemplate.opsForSet().isMember("studying_redis_set",1);

        //获取有序集合成员数
        stringRedisTemplate.opsForZSet().zCard("studying_redis_set");

        //存储对象,存入字段、值
        stringRedisTemplate.opsForHash().put("studying_redis_hash", "field1","val1");

        //给指定字段增值
        stringRedisTemplate.opsForHash().increment("studying_redis_hash","field1",1);
    }


}