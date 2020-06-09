package com.wj88.mybatishibernate.service;

import com.wj88.mybatishibernate.model.User;

import java.util.List;

/**
 * @Description IUserService
 * @Author huayu
 * @date 2019/7/24 15:36
 */
public interface IUserService {

    User save(User user);

    User selectById(Long id);

    List<User> selectAll();
}
