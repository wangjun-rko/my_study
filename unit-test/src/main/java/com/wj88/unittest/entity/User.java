package com.wj88.unittest.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User
 *
 * @author huayu
 * @date 2020/8/18 13:47
 * @version 1.0
 */
@Setter
@Getter
@ToString
@Builder
public class User {

    private Integer id;

    private String name;
}
