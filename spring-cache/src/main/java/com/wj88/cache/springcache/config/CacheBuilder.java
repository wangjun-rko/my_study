package com.wj88.cache.springcache.config;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;
import com.wj88.cache.springcache.service.ICacheProviderService;

/**
 * CacheBuilder
 * @description TODO
 * @author huayu
 * @date 2020/6/18 16:07
 * @version 1.0
 */
@Configuration
public class CacheBuilder {

    @Autowired
    @Qualifier("localCacheService")
    private ICacheProviderService localCacheService;

    @Autowired
    @Qualifier("redisCacheService")
    private ICacheProviderService redisCacheService;

    private static List<ICacheProviderService> _listCacheProvider = Lists.newArrayList();

    private static final Lock providerLock = new ReentrantLock();
}
