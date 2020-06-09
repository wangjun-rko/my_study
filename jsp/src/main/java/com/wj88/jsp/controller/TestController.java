package com.wj88.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TestController
 *
 * @author huayu
 * @version 1.0
 * @description 测试
 * @date 2019/7/24 18:47
 */
@Controller
public class TestController {

    @RequestMapping(name="/index")
    public String index(){
        return "index";
    }
}
