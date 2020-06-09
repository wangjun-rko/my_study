package com.wj88.study.classLoadOrder;

/**
 * ClassInitOrderTest
 *
 * @author huayu
 * @version 1.0
 * @description 类初始化顺序
 * @date 2019/5/24 16:22
 */
public class ClassInitOrderTest {

    public static void main(String[] args) {
        ObjectA a = new ObjectA();
        ObjectA b = new ObjectA();
        //static blcok
        //block
        //constructor
        //block
        //constructor
        ObjectB c = new ObjectB();
        // 静态变量>静态代码块>变量>代码块>构造器
        //static field
        //static blcok
        //field
        //block
        //constructor
        // 父类静态变量 静态代码块>子类静态变量 静态代码块>父类代码块 变量 构造器>子类代码块 变量 构造器
    }

}

class ObjectA{
    static{
        System.out.println("static blcok");
    }
    {
        System.out.println("block");
    }
    public ObjectA() {
        System.out.println("constructor");
    }
}

class ObjectB{
    private static String staticField = "static field";
    private String field = "field";
    static{
        System.out.println(staticField);
        System.out.println("static blcok");
    }
    {
        System.out.println(field);
        System.out.println("block");
    }
    public ObjectB() {
        System.out.println("constructor");
    }
}
