package com.wj88.swagger.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wj88.swagger.form.MyUser;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * MyController
 * 
 * @description TODO
 * @author huayu
 * @date 2020/6/23 18:17
 * @version 1.0
 */
@Api(tags = "测试API接口")
@RequestMapping("/api")
@RestController
@Slf4j
public class MyController {

    @ApiOperation(value = "根据用户编号获取用户信息", notes = "根据用户编号获取用户信息", produces = "application/json")
    @ApiImplicitParam(name = "number", value = "用户编号", paramType = "body", required = true)
    @RequestMapping(value = "/queryUser", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
        consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
    public MyUser getUser(@RequestBody String number) {
        log.info("number:{}", number);
        return MyUser.builder().age(25).name("wj88").number(number).build();
    }

    @ApiOperation(value = "根据用户编号获取用户信息22", notes = "根据用户编号获取用户信息22", produces = "application/json")
    @ApiImplicitParam(name = "number", value = "用户编号", paramType = "query", required = true,dataType = "String")
    @RequestMapping(value = "/queryUser2", method = RequestMethod.POST)
    public MyUser getUser2(@RequestParam String number) {
        log.info("number:{}", number);
        return MyUser.builder().age(25).name("wj88").number(number).build();
    }

    @ApiOperation(value = "根据用户编号获取用户信息3", notes = "根据用户编号获取用户信息3", produces = "application/json")
    @ApiImplicitParam(name = "user", value = "用户对象", paramType = "body", required = true)
    @RequestMapping(value = "/queryUser3", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, method = RequestMethod.POST)
    public MyUser getUser3(@RequestBody MyUser user) {
        log.info("user:{}", user);
        return user;
    }

    @ApiOperation(value = "根据用户编号删除用户信息", notes = "根据用户编号获取用户信息", produces = "application/json")
    @RequestMapping(value = "/delUser",  method = RequestMethod.POST)
    public MyUser delUser(@ApiParam(name = "number",value = "用户编号",required = true) @RequestParam String number) {
        log.info("number:{}", number);
        return MyUser.builder().age(25).name("wj88").number(number).build();
    }
}
