package com.wj88.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * MyController
 *
 * @author huayu
 * @version 1.0
 * @description 测试
 * @date 2019/7/24 10:04
 */
@RestController
public class MyController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    @RequestMapping({"/anon1","/anon2"})
    public String anon(){
        return "anon";
    }


}
