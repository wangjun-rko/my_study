package com.wj88.study.thread;

/**
 * ThreadDemo
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/7/5 11:03
 */
public class ThreadDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(() -> {
            // 设置线程本地变量threadLocal的值
            threadLocal.set("threadOne threadLocal");
            print("threadOne");
            System.out.println("threadOne get->" + threadLocal.get());
        }).start();

        new Thread(() -> {
            // 设置线程本地变量threadLocal的值
            threadLocal.set("threadTwo threadLocal");
            print("threadTwo");
            System.out.println("threadTwo get->" + threadLocal.get());
        }).start();

    }

    private static void print(String msg) {
        // 输出当前线程本地变量threadLocal的值
        System.out.println(msg + "-->" + threadLocal.get());
        // 清除当前线程本地变量threadLocal的值
         threadLocal.remove();// 代码1
    }

    // 代码1不放开
    //threadOne-->threadOne threadLocal
    //threadTwo-->threadTwo threadLocal
    //threadTwo get->threadTwo threadLocal
    //threadOne get->threadOne threadLocal
    // 代码1放开
    //threadOne-->threadOne threadLocal
    //threadOne get->null
    //threadTwo-->threadTwo threadLocal
    //threadTwo get->null
}
