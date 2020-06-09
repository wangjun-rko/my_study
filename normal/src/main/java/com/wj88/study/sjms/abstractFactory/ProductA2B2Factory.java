package com.wj88.study.sjms.abstractFactory;

/**
 * ProductAFactory
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/7/16 19:27
 */
public class ProductA2B2Factory implements IFactory {
    @Override
    public IProduct createProductA() {
        return new ProductA2();
    }

    @Override
    public IProduct createProductB() {
        return new ProductB2();
    }
}
