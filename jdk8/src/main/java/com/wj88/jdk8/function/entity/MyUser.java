package com.wj88.jdk8.function.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * MyUser
 * @description 用户实体
 * @author huayu
 * @date 2020/7/21 16:20
 * @version 1.0
 */
@Getter
@Setter
@ToString
@Builder
public class MyUser {

    private int number;

    private int age;

    private String name;

    public boolean isOld(){
        return age>30;
    }
}
