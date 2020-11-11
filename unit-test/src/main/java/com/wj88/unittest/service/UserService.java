package com.wj88.unittest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wj88.unittest.dao.UserDao;
import com.wj88.unittest.entity.User;

/**
 * UserService
 *
 * @author huayu
 * @date 2020/8/18 13:47
 * @version 1.0
 */
@Component
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(Integer id){
        return userDao.getUserById(id);
    }
}
