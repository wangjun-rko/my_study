package com.wj88.easypoi.export.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * MyTest
 * @author huayu
 * @date 2020/8/7 11:06
 * @version 1.0
 */
public class MyTest {

    public static void main(String[] args) {
        List<String> ss = new ArrayList<>();
        ss.add("1");
        ss.add("2");
        ss.add("3");
        ss.add("4");
        ss.add("5");
        ss.add("6");
        List<String> ty = ss;
        System.out.println(ss);
        System.out.println(ss.subList(0,2));
        System.out.println(ty=ss.subList(2,ss.size()));
        System.out.println(ss);
    }
}
