package com.wj88.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.wj88.jdk8.function.entity.MyUser;

/**
 * Demo
 * @description 测试
 * @author huayu
 * @date 2020/7/21 16:37
 * @version 1.0
 */
public class Demo {

    public static void main(String[] args) {

        List<MyUser> myUserList = new ArrayList<>();
        myUserList.add(MyUser.builder().age(12).number(1).name("wj88").build());
        myUserList.add(MyUser.builder().age(32).number(2).name("wj99").build());
        myUserList.add(MyUser.builder().age(22).number(3).name("wj77").build());
        testPredicate(myUserList,MyUser::isOld);

        myUserList.stream().filter(MyUser::isOld).collect(Collectors.toList()).forEach(k->System.out.printf(k.toString()));


    }

    public static void testPredicate(List<MyUser> myUserList, Predicate<MyUser> p){
        for (MyUser user : myUserList){
            if (p.test(user)) {
                System.out.println(user);
            }
        }
    }
}
