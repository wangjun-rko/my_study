package com.wj88.study.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadLocalTest
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/7/5 9:14
 */
public class ThreadLocalTest {

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("threadName=" + Thread.currentThread().getName() + ",threadId=" + ThreadLocalTest.get());
            }).start();
        }
    }
}
