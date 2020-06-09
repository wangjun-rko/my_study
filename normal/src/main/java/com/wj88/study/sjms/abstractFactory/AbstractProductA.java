package com.wj88.study.sjms.abstractFactory;

/**
 * AbstractProductA
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/7/16 19:18
 */
public abstract class AbstractProductA implements IProduct {
    @Override
    public void methodA() {
        System.out.println("----AbstractProductA--methodA---");
    }
    @Override
    public void methodB() {
        System.out.println("----AbstractProductA----methodB-");
    }
}
