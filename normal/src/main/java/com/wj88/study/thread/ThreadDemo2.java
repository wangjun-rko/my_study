package com.wj88.study.thread;

/**
 * ThreadDemo2
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/7/5 13:20
 */
public class ThreadDemo2 {

    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("wj88");
        new Thread(() -> {
            System.out.println("son thread->" + threadLocal.get());
        }).start();
        System.out.println("main thread->" + threadLocal.get());
    }
    // main thread->wj88
    // son thread->null
}
