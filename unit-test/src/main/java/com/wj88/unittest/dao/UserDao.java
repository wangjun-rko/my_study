package com.wj88.unittest.dao;

import org.springframework.stereotype.Component;

import com.wj88.unittest.entity.User;

/**
 * UserDao
 *
 * @author huayu
 * @date 2020/8/18 13:49
 * @version 1.0
 */
@Component
public class UserDao {

    public User getUserById(Integer id){
        return User.builder().id(id).name("wj88").build();
    }
}
