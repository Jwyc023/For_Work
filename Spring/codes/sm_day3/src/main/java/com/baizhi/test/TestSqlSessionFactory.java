package com.baizhi.test;

import com.baizhi.dao.UserDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSqlSessionFactory {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");


        //xxDAO   调用  UserDAO OrderDAO  StudentDAO ......

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);


        //mybatis-spring  jar  MapperFactoryBean  创建DAO对象一个类  1.依赖于SqlSessionFactory 2.依赖创建DAO全限定名

        userDAO.findAll().forEach(user-> System.out.println(user));


    }



}
