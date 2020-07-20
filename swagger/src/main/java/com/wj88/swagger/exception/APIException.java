package com.wj88.swagger.exception;

import lombok.Getter;

/**
 * APIException
 * @description 自定义异常
 * @author huayu
 * @date 2020/7/20 17:54
 * @version 1.0
 */
@Getter
public class APIException extends RuntimeException{

    private int code;
    private String msg;

    public APIException() {
        this(1001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
