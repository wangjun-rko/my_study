package com.wj88.mybatishibernate.orm;

import com.wj88.mybatishibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserJpa
 *
 * @author huayu
 * @version 1.0
 * @description JPA
 * @date 2019/7/24 15:29
 */
public interface UserJpa extends JpaRepository<User,Long> {
}
