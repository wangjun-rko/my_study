package com.wj88.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * MyClass
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/8/4 17:16
 */
public class MyClass {

    private static int num=Integer.parseInt(System.getProperty("num"));

    private static List<String> list;

    private String env=System.getProperty("num");

    static{
        setList();
    }

    private static void setList(){
        list=new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
    }

    public void method1(){
        String name="wj88";
        method2();
    }

    public void method2(){
        int num=100;
    }
}
