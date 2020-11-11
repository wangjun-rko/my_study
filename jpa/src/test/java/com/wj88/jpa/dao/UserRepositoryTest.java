package com.wj88.jpa.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.util.Streamable;

import com.wj88.jpa.model.User;
import com.wj88.jpa.model.UserOnlyName;

/**
 * UserRepositoryTest
 *
 * @author huayu
 * @date 2020/11/10 14:08
 * @version 1.0
 */
@DataJpaTest
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void testSaveUser(){
        User user = userRepository.save(User.builder().name("jackxx").address("45454545").build());
        Assert.assertNotNull(user);
        //List<User> users= userRepository.findAll();
        //System.out.println(users);
        //Assert.assertNotNull(users);
        //Streamable<User> userStreamable = userRepository.findAll(PageRequest.of(0,10)).and(User.builder().name("jack222").build());
        //userStreamable.forEach(System.out::println);
        //UserOnlyName userOnlyName = userRepository.findByAddress("45454545");
        //System.out.println(userOnlyName.getName());
    }
}
