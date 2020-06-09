package com.wj88.study.sjms.factorymethod;

/**
 * HttpTransferImpl
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/7/15 14:32
 */
public class HttpTransferImpl implements ITransfer{
    @Override
    public void transfer() {
        System.out.println("-----HttpTransferImpl------");
    }
}
