package com.wj88.swagger.enums;

import lombok.Getter;

/**
 * ResultCode
 * @description 响应码枚举
 * @author huayu
 * @date 2020/7/20 18:07
 * @version 1.0
 */
@Getter
public enum ResultCode {

    SUCCESS(1000, "操作成功"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
