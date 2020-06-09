package com.wj88.study.sjms.factorymethod;

/**
 * FtpTransferFactory
 *
 * @author huayu
 * @version 1.0
 * @description 实现工厂
 * @date 2019/7/15 15:17
 */
public class FtpTransferFactory extends AbstractTransferFactory{
    @Override
    public ITransfer transfer() {
        return new FtpTransferImpl();
    }
}
