package com.wj88.mybatishibernate.controller;

import com.wj88.mybatishibernate.model.User;
import com.wj88.mybatishibernate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * MyController
 *
 * @author huayu
 * @version 1.0
 * @description MyController
 * @date 2019/7/24 15:40
 */
@RestController
@RequestMapping("/user")
public class MyController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public User save(@RequestBody User user){
        return  userService.save(user);
    }
    @GetMapping("/{id}")
    public User findOne(@PathVariable long id){
        return userService.selectById(id);
    }
    @GetMapping()
    public List<User> findAll(){
        return userService.selectAll();
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
