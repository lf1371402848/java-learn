package com.test;

import com.test.dao.UserDao;
import com.test.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/9/17 21:50
 * @Version: 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-dao.xml" })
public class UserTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void login(){
        User user = userDao.login("110", "123");
        System.out.println(user);
    }

    @Test
    public void checkPhone(){
         Integer i = userDao.checkPhone("110");
        System.out.println(i);
    }

    @Test
    public void register(){
        /*Integer i = userDao.register("110","111", "123");
        System.out.println(i);*/
    }
}
