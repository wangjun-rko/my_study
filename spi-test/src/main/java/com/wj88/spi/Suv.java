package com.wj88.spi;

/**
 * Suv
 *
 * @author huayu
 * @version 1.0
 * @description Suv
 * @date 2020/4/14 17:32
 */
public class Suv implements ICar {
    @Override
    public void getName() {
        System.out.println("------suv------");
    }
}
