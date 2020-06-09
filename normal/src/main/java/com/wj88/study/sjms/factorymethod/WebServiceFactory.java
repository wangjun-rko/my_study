package com.wj88.study.sjms.factorymethod;

/**
 * WebServiceFactory
 *
 * @author huayu
 * @version 1.0
 * @description 实现工厂
 * @date 2019/7/15 15:18
 */
public  class WebServiceFactory extends AbstractTransferFactory {
    @Override
    public ITransfer transfer() {
        return new WebServiceTransferImpl();
    }
}
