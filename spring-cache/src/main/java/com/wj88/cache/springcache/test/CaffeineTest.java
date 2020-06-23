package com.wj88.cache.springcache.test;

import java.util.concurrent.TimeUnit;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalListener;

/**
 * CaffeineTest
 * 
 * @description TODO
 * @author huayu
 * @date 2020/6/18 17:19
 * @version 1.0
 */
public class CaffeineTest {

    public static void main(String[] args) throws Exception {
        Cache<String, String> cache = Caffeine.newBuilder()
            // 数量上限
            .maximumSize(1024)
            // 过期机制
            .expireAfterWrite(5, TimeUnit.MINUTES)
            // 弱引用key
            .weakKeys()
            // 弱引用value
            .weakValues()
            // 剔除监听
            .removalListener((RemovalListener<String, String>)(key, value, cause) -> System.out
                .println("key:" + key + ", value:" + value + ", 删除原因:" + cause.toString()))
            .build();

        // 将数据放入本地缓存中
        cache.put("username", "afei");
        cache.put("password", "123456");
        // 从本地缓存中取出数据
        System.out.println(cache.getIfPresent("username"));
        System.out.println(cache.getIfPresent("password"));

        System.out.println(cache.get("blog", key -> {
            // 本地缓存没有的话，从数据库或者Redis中获取
            // return getValue(key);
            return "";
        }));
        // 异步加载机制
        AsyncLoadingCache<String, String> cacheAsy = Caffeine.newBuilder()
            // 数量上限
            .maximumSize(2)
            // 失效时间
            .expireAfterWrite(5, TimeUnit.MINUTES).refreshAfterWrite(1, TimeUnit.MINUTES)
            // 异步加载机制
            .buildAsync(new CacheLoader<String, String>() {
                @Nullable
                @Override
                public String load(@NonNull String key) throws Exception {
                    // return getValue(key);
                    return "";
                }
            });
        System.out.println(cacheAsy.get("username").get());
        System.out.println(cacheAsy.get("password").get(10, TimeUnit.MINUTES));
        System.out.println(cacheAsy.get("username").get(10, TimeUnit.MINUTES));
        System.out.println(cacheAsy.get("blog").get());
    }
}
