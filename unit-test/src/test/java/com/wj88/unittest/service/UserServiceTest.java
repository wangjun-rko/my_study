package com.wj88.unittest.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.wj88.unittest.dao.UserDao;
import com.wj88.unittest.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    public void getUserById(){

        Mockito.when(userDao.getUserById(3)).thenReturn(User.builder().id(4).name("444").build());

        User user = userService.getUserById(1);

        Assert.assertNotNull(user);
        Assert.assertEquals(user.getId(),new Integer(4));
        Assert.assertEquals(user.getName(),"444");
    }

}