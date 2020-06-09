package com.wj88.myexception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * MyController
 *
 * @author huayu
 * @version 1.0
 * @description 测试
 * @date 2019/7/26 16:57
 */
@Controller
public class MyController {

    @RequestMapping(name="/test1")
    public String test1(){
        int i=1/0;
        return "11";
    }
}
