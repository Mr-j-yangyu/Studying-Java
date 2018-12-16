package com.jwx.studying.redis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * Description: redis分布式锁实现类 <a href="https://www.cnblogs.com/linjiqin/p/8003838.html">参考链接</a>
 * <p>
 * PackageName:com.jwx.studying.redis.lock
 * FileName: RedisLock.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/8/13
 */
@Component
public class RedisLock {
    private static final String LOCK_SUCCESS = "OK"; //set成功后返回
    private static final String SET_IF_NOT_EXIST = "NX"; //SET IF NOT EXIST，即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作；
    private static final String SET_WITH_EXPIRE_TIME = "EX"; //表明给key设置过期时间,单位s，PX，毫秒
    private static final Long RELEASE_SUCCESS = 1L; //释放锁成功返回

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取分布式锁
     *
     * @param lockKey 锁key值
     * @param lockVal 锁val值
     * @param expireTime 超期时间
     * @return 是否获取成功
     * @author jiwenxiang
     * @date 2018/8/15
     */
    public  boolean tryGetDistributedLock(String lockKey, String lockVal, Long expireTime) {
        String executeResult = stringRedisTemplate.execute((RedisCallback<String>) redisConnection -> {
            Object connection = redisConnection.getNativeConnection();
            String result = "";
            if(connection instanceof JedisCluster) {
                //2.6.12版本后jedis支持set同时设置过期时间，原先需要setnx和expire组合，存在死锁问题
                result = ((JedisCluster) connection).set(lockKey, lockVal, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
            }
            if(connection instanceof Jedis) {
                result = ((Jedis) connection).set(lockKey, lockVal, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
            }
            return result;
        });
        if (LOCK_SUCCESS.equals(executeResult)) {
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     * @param lockKey 锁key值
     * @param lockVal 锁val值
     * @return 是否释放成功
     * @author jiwenxiang
     * @date 2018/8/15
     */
    public  boolean releaseDistributedLock( String lockKey, String lockVal) {

        //lua脚本，KEYS[1] 赋值为lockKey ，ARGV[1]赋值为lockVal
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

        Long executeResult = stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                Long result = 0L;
                Object connection = redisConnection.getNativeConnection();
                if(connection instanceof JedisCluster) {
                    //eval()方法是将Lua代码交给Redis服务端执行,保证操作原子性，get后执行del，一条命令,避免删除其他客户端的锁
                    result = (Long) ((JedisCluster) connection).eval(script, Collections.singletonList(lockKey), Collections.singletonList(lockVal));
                }
                if(connection instanceof Jedis) {
                    result = (Long) ((JedisCluster) connection).eval(script, Collections.singletonList(lockKey), Collections.singletonList(lockVal));
                }
                return result;
            }
        });
        if (RELEASE_SUCCESS.equals(executeResult)) {
            return true;
        }
        return false;
    }

    /**
     * 检查是否存在锁
     * @param
     * @return
     * @throws
     * @author jiwenxiang
     * @date 2018/8/15
     */
    public  boolean checkNotifyMsgLock(String redisKey){
        String str = stringRedisTemplate.opsForValue().get(redisKey);
        if(!StringUtils.isEmpty(str)){
            return true;
        }
        return false;
    }
}