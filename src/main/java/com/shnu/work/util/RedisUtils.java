package com.shnu.work.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Set;

/**
 * redis操作工具类
 *
 * @author tonghao
 * 2020年5月28日 12点43分
 */
@Component
@Repository
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 切换数据库
     *
     * @param dbNumber 数据库编号
     */
    public void switchDatabase(Integer dbNumber) {
        ((LettuceConnectionFactory) Objects.requireNonNull(redisTemplate.getConnectionFactory())).setDatabase(dbNumber);
    }

    /**
     * 模糊查询
     * @param key key
     * @return 查询结果
     */
    public Set<String> fuzzySearch(String key) {
        return this.stringRedisTemplate.keys(key);
    }

    /**
     * 读取缓存
     *
     * @param key key
     * @return value
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 写入缓存
     *
     * @param key   key
     * @param value value
     * @return 是否成功
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新缓存
     *
     * @param key   key
     * @param value value
     * @return 是否成功
     */
    public boolean getAndSet(final String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     *
     * @param key key
     * @return 是否成功
     */
    public boolean delete(final String key) {
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}