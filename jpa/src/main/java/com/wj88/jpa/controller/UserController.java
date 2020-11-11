package com.wj88.jpa.controller;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wj88.jpa.dao.UserRepository;
import com.wj88.jpa.model.User;

/**
 * UserController
 *
 * @author huayu
 * @date 2020/11/10 11:34
 * @version 1.0
 */
@RestController
@RequestMapping(path="/api/v1")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @PostMapping(path = "user",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping(path = "users")
    @ResponseBody
    public Page<User> getAllUsers(Pageable request) {
        return userRepository.findAll(request);
    }
}
