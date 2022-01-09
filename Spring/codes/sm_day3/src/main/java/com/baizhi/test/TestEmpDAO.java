package com.baizhi.test;

import com.baizhi.dao.EmpDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmpDAO {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        EmpDAO empDAO = (EmpDAO) context.getBean("empDAO");
        
        empDAO.findAll().forEach(emp -> System.out.println("emp = " + emp));

        
    }
}
