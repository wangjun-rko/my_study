package com.wj88.mybatishibernate.model;

import lombok.Data;

import javax.persistence.*;

/**
 * User
 *
 * @author huayu
 * @version 1.0
 * @description 实体
 * @date 2019/7/24 15:23
 */
@Data
@Table(name = "t_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "c_name")
    private String userName;
    @Column(name = "n_age")
    private int age;
}
