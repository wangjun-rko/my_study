package com.wj88.swagger.entity;

import com.wj88.swagger.enums.ResultCode;

import lombok.Getter;
import lombok.ToString;

/**
 * ResultVO
 * 
 * @description 相应实体
 * @author huayu
 * @date 2020/7/20 17:56
 * @version 1.0
 */
@Getter
@ToString
public class ResultVO<T> {

    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
