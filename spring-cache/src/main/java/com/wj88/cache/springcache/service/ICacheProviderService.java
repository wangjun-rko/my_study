package com.wj88.cache.springcache.service;

import java.util.function.Function;

/**
 * ICacheProviderService
 * @description 缓存提供接口
 * @author huayu
 * @date 2020/6/18 14:35
 * @version 1.0
 */
public interface ICacheProviderService {

    /**
     * @Description 查询缓存
     * @Param [key] 缓存key
     * @return T
     * @Author huayu
     * @date 2020/6/18 14:37
     */
    <T extends Object> T get(String key);


    /**
     * @Description 查询缓存
     * @Param [key] 缓存key
     * @Param [function] 没有缓存 调用此函数返回对象
     * @return T
     * @Author huayu
     * @date 2020/6/18 14:38
     */
    <T extends Object> T get(String key, Function<String,T> function);

    /**
     * @Description 查询缓存
     * @Param [key] 缓存key
     * @Param [function] 没有缓存 调用此函数返回对象
     * @Param [funcParm] function的调用参数
     * @return T
     * @Author huayu
     * @date 2020/6/18 14:41
     */
    <T extends Object,M extends Object> T get(String key, Function<String,T> function,M funcParm);

    /**
     * @Description 查询缓存
     * @Param [key] 缓存key
     * @Param [function] 没有缓存 调用此函数返回对象
     * @Param [expireTime] 过期时间 毫秒
     * @return T
     * @Author huayu
     * @date 2020/6/18 14:38
     */
    <T extends Object> T get(String key, Function<String,T> function,Long expireTime);

    /**
     * @Description 查询缓存
     * @Param [key] 缓存key
     * @Param [function] 没有缓存 调用此函数返回对象
     * @Param [funcParm] function的调用参数
     * @Param [expireTime] 过期时间 毫秒
     * @return T
     * @Author huayu
     * @date 2020/6/18 14:41
     */
    <T extends Object,M extends Object> T get(String key, Function<String,T> function,M funcParm,Long expireTime);

    /**
     * @Description 设置缓存
     * @Param [key] 缓存键
     * @Param [obj] 缓存值
     * @return void
     * @Author huayu
     * @date 2020/6/18 14:44
     */
    <T extends Object> void set(String key,T obj);

    /**
     * @Description 设置缓存
     * @Param [key] 缓存键
     * @Param [obj] 缓存值
     * @Param [expireTime] 过期时间 毫秒
     * @return void
     * @Author huayu
     * @date 2020/6/18 14:44
     */
    <T extends Object> void set(String key,T obj,Long expireTime);

    /**
     * @Description 删除缓存
     * @Param [key] 缓存键
     * @return void
     * @Author huayu
     * @date 2020/6/18 14:46
     */
    void remove(String key);

    /**
     * @Description 缓存是否存在
     * @Param [key] 缓存键
     * @return boolean
     * @Author huayu
     * @date 2020/6/18 14:47
     */
    boolean contains(String key);
}
