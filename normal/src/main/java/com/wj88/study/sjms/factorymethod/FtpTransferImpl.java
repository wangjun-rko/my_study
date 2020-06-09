package com.wj88.study.sjms.factorymethod;

/**
 * FtpTransferImpl
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/7/15 14:42
 */
public class FtpTransferImpl implements ITransfer {
    @Override
    public void transfer() {
        System.out.println("-----FtpTransferImpl------");
    }
}
