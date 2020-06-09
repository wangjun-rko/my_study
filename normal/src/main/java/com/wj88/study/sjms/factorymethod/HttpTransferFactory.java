package com.wj88.study.sjms.factorymethod;

/**
 * HttpTransferFactory
 *
 * @author huayu
 * @version 1.0
 * @description 实现工厂
 * @date 2019/7/15 15:11
 */
public class HttpTransferFactory extends AbstractTransferFactory {
    @Override
    public ITransfer transfer() {
        return new HttpTransferImpl();
    }
}
