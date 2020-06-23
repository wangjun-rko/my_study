package com.wj88.cache.springcache.service.imp;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;

import com.google.common.cache.Cache;
import com.wj88.cache.springcache.cnst.CacheConst;
import com.wj88.cache.springcache.service.ICacheProviderService;

/**
 * RedisCacheProviderServiceImpl
 * 
 * @description redis缓存
 * @author huayu
 * @date 2020/6/18 15:55
 * @version 1.0
 */
@Configuration
@Qualifier("redisCacheService")
public class RedisCacheProviderServiceImpl implements ICacheProviderService {

    @Resource
    private RedisTemplate<Serializable, Object> redisTemplate;

    @Override
    public <T> T get(String key) {
        return get(key, null, null, 2L);
    }

    @Override
    public <T> T get(String key, Function<String, T> function) {
        return get(key, function, key, CacheConst.CACHE_MINUTE);
    }

    @Override
    public <T, M> T get(String key, Function<String, T> function, M funcParm) {
        return get(key, function, funcParm, CacheConst.CACHE_MINUTE);
    }

    @Override
    public <T> T get(String key, Function<String, T> function, Long expireTime) {
        return get(key, function, key, expireTime);
    }

    @Override
    public <T, M> T get(String key, Function<String, T> function, M funcParm, Long expireTime) {
        T obj = null;
        if (StringUtils.isEmpty(key) == true) {
            return obj;
        }
        expireTime = getExpireTime(expireTime);
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            obj = (T)operations.get(key);
            if (function != null && obj == null) {
                obj = function.apply((String)funcParm);
                if (obj != null) {
                    set(key, obj, expireTime);// 设置缓存信息
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public <T> void set(String key, T obj) {
        set(key, obj, CacheConst.CACHE_MINUTE);
    }

    @Override
    public <T> void set(String key, T obj, Long expireTime) {
        if (StringUtils.isEmpty(key) == true) {
            return;
        }
        if (obj == null) {
            return;
        }
        expireTime = getExpireTime(expireTime);
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, obj);
        redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
    }

    @Override
    public void remove(String key) {
        if (StringUtils.isEmpty(key) == true) {
            return;
        }
        redisTemplate.delete(key);
    }

    @Override
    public boolean contains(String key) {
        boolean exists = false;
        if (StringUtils.isEmpty(key) == true) {
            return exists;
        }
        Object obj = get(key);
        if (obj != null) {
            exists = true;
        }
        return exists;
    }

    /**
     * 获取过期时间 单位：毫秒
     *
     * @param expireTime 传人的过期时间 单位毫秒 如小于1分钟，默认为10分钟
     **/
    private Long getExpireTime(Long expireTime) {
        Long result = expireTime;
        if (expireTime == null || expireTime < CacheConst.CACHE_MINUTE / 10) {
            result = CacheConst.CACHE_MINUTE;
        }

        return result;
    }
}
