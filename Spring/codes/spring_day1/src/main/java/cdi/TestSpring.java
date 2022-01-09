package cdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("cdi/spring.xml");

        EmpDAO empDAO = (EmpDAO) context.getBean("empDAO");

        empDAO.save("小明");




    }
}
