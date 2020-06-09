package com.wj88.study.sjms.abstractFactory;

/**
 * Client
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/7/16 19:31
 */
public class Client {
    public static void main(String[] args) {
        IFactory factory1=new ProductA1B1Factory();
        IFactory factory2=new ProductA2B2Factory();
        IProduct p=factory1.createProductA();
        IProduct p2=factory2.createProductB();
        p.methodA();
        p.methodB();
        p.methodC();
        System.out.println("-------------------");
        p2.methodA();
        p2.methodB();
        p2.methodC();
    }
}
