package com.wj88.spi;

/**
 * Mpv
 *
 * @author huayu
 * @version 1.0
 * @description Mpv
 * @date 2020/4/14 17:46
 */
public class Mpv implements ICar {
    @Override
    public void getName() {
        System.out.println("------Mpv------");
    }
}
