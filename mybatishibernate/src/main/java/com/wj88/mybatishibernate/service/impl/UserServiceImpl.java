package com.wj88.mybatishibernate.service.impl;

import com.wj88.mybatishibernate.model.User;
import com.wj88.mybatishibernate.orm.UserJpa;
import com.wj88.mybatishibernate.orm.UserMapper;
import com.wj88.mybatishibernate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author huayu
 * @version 1.0
 * @description UserServiceImpl
 * @date 2019/7/24 15:37
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserJpa userJpa;

    @Override
    public User save(User user) {
        return userJpa.save(user);
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
