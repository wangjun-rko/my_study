package com.wj88.swagger.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @NotNull(message = "用户编号不能为空")
    @Size(min = 6,max = 11,message = "用户编号必须是6-11长度")
    private String number;

    @ApiModelProperty(value = "姓名")
    @NotNull(message = "用户名称不能为空")
    private String name;

    @ApiModelProperty(value = "年龄")
    @Digits(integer=2, fraction=0,message = "年龄必须为小于100的数字")
    @DecimalMin(value ="1")
    private Integer age;

    @ApiModelProperty(value = "邮箱地址")
    @Email(message = "邮箱格式不正确")
    private String email;
}
