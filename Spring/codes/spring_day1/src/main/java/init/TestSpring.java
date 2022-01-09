package init;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("init/spring.xml");
        //获取工厂中创建好的对象 参数:获取工厂中指定对应的唯一标识
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        System.out.println(userDAO);
        userDAO.save("xiaochen");

        CityDAO cityDAO = (CityDAO) context.getBean("cityDAO");
        cityDAO.delete("1");
    }
}
