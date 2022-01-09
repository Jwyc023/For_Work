package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestUserService {

    private ClassPathXmlApplicationContext context;

    @Before
    public void before(){
        this.context = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void testSave(){
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setBir(new Date());
        user.setName("小陈");
        user.setAge(23);
        userService.save(user);
    }
    
    @Test
    public void testFindAll(){
        UserService userService = (UserService) context.getBean("userService");
        userService.findAll().forEach(user-> System.out.println("user = " + user));
    }

    @After
    public void after(){
        context.close();
    }

}
