package com.wj88.study.sjms.factorymethod;

/**
 * TransferFactory
 *
 * @author huayu
 * @version 1.0
 * @description 简单工厂
 * @date 2019/7/15 16:16
 */
public class TransferFactory {
    public static <T extends ITransfer> T transfer(Class<T> cla) {
        ITransfer transfer = null;
        try {
            transfer = (T)Class.forName(cla.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)transfer;
    }
}
