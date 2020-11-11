package com.wj88.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wj88.jpa.model.User;
import com.wj88.jpa.model.UserDto;
import com.wj88.jpa.model.UserOnlyName;

/**
 * UserRepository
 *
 * @author huayu
 * @date 2020/11/10 11:30
 * @version 1.0
 */
public interface UserRepository  extends JpaRepository<User,Long> {

    // 根据名称进行查询用户列表
    List<User> findByName(String name);

    // 接口的方式返回DTO
    UserOnlyName findByAddress(String address);

    //利用接口DTO获得返回结果，需要注意的是每个字段需要as和接口里面的get方法名字保持一样
    @Query("select CONCAT(u.name,'JK123') as name,e.idCard as idCard from User u,UserExt e where u.id= e.userId and u.id=:id")
    UserDto findByUserDtoId(@Param("id") Long id);

}
