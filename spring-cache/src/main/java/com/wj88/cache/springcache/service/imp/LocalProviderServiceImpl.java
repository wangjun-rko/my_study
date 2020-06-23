package com.wj88.cache.springcache.service.imp;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Maps;
import com.wj88.cache.springcache.cnst.CacheConst;
import com.wj88.cache.springcache.service.ICacheProviderService;

/**
 * LocalProviderServiceImpl
 * @description 本地缓存
 * @author huayu
 * @date 2020/6/18 14:54
 * @version 1.0
 */
@Configuration
@Qualifier("localCacheService")
public class LocalProviderServiceImpl implements ICacheProviderService {

    private static Map<String, Cache<String, Object>> _cacheMap = Maps.newConcurrentMap();

    static {

        Cache<String, Object> cacheContainer = CacheBuilder.newBuilder()
                .maximumSize(CacheConst.MAX_CACHE_SIZE)
                .expireAfterWrite(CacheConst.CACHE_MINUTE, TimeUnit.MILLISECONDS)//最后一次写入后的一段时间移出
                //.expireAfterAccess(2, TimeUnit.MILLISECONDS) //最后一次访问后的一段时间移出
                .recordStats()//开启统计功能
                .build();

        _cacheMap.put("test", cacheContainer);
    }

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
        Cache<String, Object> cacheContainer = getCacheContainer(expireTime);
        try {
            if (function == null) {
                obj = (T) cacheContainer.getIfPresent(key);
            } else {
                obj = (T) cacheContainer.get(key, () -> {
                    T retObj = function.apply((String) funcParm);
                    return retObj;
                });
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
        Cache<String, Object> cacheContainer = getCacheContainer(expireTime);
        cacheContainer.put(key, obj);
    }

    @Override
    public void remove(String key) {
        if (StringUtils.isEmpty(key) == true) {
            return;
        }
        long expireTime = getExpireTime(CacheConst.CACHE_MINUTE);

        Cache<String, Object> cacheContainer = getCacheContainer(expireTime);

        cacheContainer.invalidate(key);
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

    private static Lock lock = new ReentrantLock();

    private Cache<String, Object> getCacheContainer(Long expireTime) {

        Cache<String, Object> cacheContainer = null;
        if (expireTime == null) {
            return cacheContainer;
        }

        String mapKey = String.valueOf(expireTime);

        if (_cacheMap.containsKey(mapKey) == true) {
            cacheContainer = _cacheMap.get(mapKey);
            return cacheContainer;
        }

        try {
            lock.lock();
            cacheContainer = CacheBuilder.newBuilder()
                    .maximumSize(CacheConst.MAX_CACHE_SIZE)
                    .expireAfterWrite(expireTime, TimeUnit.MILLISECONDS)//最后一次写入后的一段时间移出
                    //.expireAfterAccess(CacheConst.MAX_CACHE_SIZE, TimeUnit.MILLISECONDS) //最后一次访问后的一段时间移出
                    .recordStats()//开启统计功能
                    .build();

            _cacheMap.put(mapKey, cacheContainer);

        } finally {
            lock.unlock();
        }

        return cacheContainer;
    }
}
