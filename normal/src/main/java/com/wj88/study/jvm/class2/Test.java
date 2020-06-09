package com.wj88.study.jvm.class2;

/**
 * Test
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/8/12 14:45
 */
public class Test {

    private static MyClass my1 = new MyClass();

    public static void main(String[] args) {
        test1();
        while (1 > 0) {
            test2();
        }
    }

    public static void test1() {
        MyClass2 my2 = new MyClass2();
        my2.method1();
    }

    public static void test2() {
        my1.method1();
    }
}
