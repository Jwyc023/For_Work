package adi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("adi/spring.xml");

        StudentService studentService = (StudentService) context.getBean("studentService");

        studentService.save("百知教育");

    }
}
