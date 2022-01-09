package com.baizhi.test;

import com.baizhi.service.AService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAService {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AService aService = (AService) context.getBean("aService");

        aService.save();//开启事务
    }
}
