package com.wj88.study.sjms.factorymethod;

/**
 * Client
 *
 * @author huayu
 * @version 1.0
 * @description TODO
 * @date 2019/7/15 15:19
 */
public class Client {
    public static void main(String[] args) {
        ITransfer ftpF=(new FtpTransferFactory()).transfer();
        ftpF.transfer();
        ITransfer httpF=(new HttpTransferFactory()).transfer();
        httpF.transfer();
        ITransfer webF=(new WebServiceFactory()).transfer();
        webF.transfer();
    }
}
