package com.wj88.study.sjms.abstractFactory;

/**
 * AbstractProductA
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/7/16 19:18
 */
public abstract class AbstractProductB implements IProduct {
    @Override
    public void methodA() {
        System.out.println("----AbstractProductB--methodA---");
    }
    @Override
    public void methodC() {
        System.out.println("----AbstractProductB----methodC-");
    }
}
