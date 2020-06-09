package com.wj88.mybatishibernate.orm;

import com.wj88.mybatishibernate.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description UserMapper
 * @Author huayu
 * @date 2019/7/24 15:31
 */
@Mapper
@Component
public interface UserMapper {

    @Results({@Result(property = "id", column = "id"), @Result(property = "userName", column = "c_name"),
            @Result(property = "age", column = "n_age")})
    @Select("select * from t_user u where id=#{id}")
    User selectById(Long id);

    @Results({@Result(property = "id", column = "id"), @Result(property = "userName", column = "c_name"),
            @Result(property = "age", column = "n_age")})
    @Select("select * from t_user")
    List<User> selectAll();
}
