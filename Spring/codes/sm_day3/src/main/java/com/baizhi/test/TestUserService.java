package com.baizhi.test;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestUserService {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        //System.out.println(userService.getClass());
        //save
        userService.save(new User(null,"百知教育",23,new Date()));
        //findAll
        userService.findAll().forEach(user-> System.out.println("user = " + user));

    }
}
