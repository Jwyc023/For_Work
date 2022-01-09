package afterthrows;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("afterthrows/spring.xml");

        ClazzService clazzService = (ClazzService) context.getBean("clazzService");
        System.out.println(clazzService.getClass());
        clazzService.find("百知教育");
    }
}
