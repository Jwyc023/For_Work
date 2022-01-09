package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("aop/spring.xml");
        EmpService empService = (EmpService) context.getBean("empService");
        System.out.println(empService.getClass());
        //代理对象
        empService.find("小陈");

    }
}
