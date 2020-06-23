package com.wj88.swagger.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * MyUser
 * @description TODO
 * @author huayu
 * @date 2020/6/23 18:25
 * @version 1.0
 */
@Data
@Builder
@ApiModel(value = "测试表单")
public class MyUser {

    @ApiModelProperty(value = "编号")
    private String number;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private int age;
}
