package com.wj88.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * UserExt
 *
 * @author huayu
 * @date 2020/11/11 16:03
 * @version 1.0
 */
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserExt {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String idCard;
}
