package setdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {

        //启动工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("setdi/spring.xml");

        //获取对象
        ClazzService clazzService = (ClazzService) context.getBean("clazzService");
        clazzService.save("小陈");

        //IOC: inversion of controll 控制反转 控制权力反转
        //就是将手动通过new关键字创建对象权力,交给spring 由工厂spring创建对象
        //DI:  dependency injection  依赖注入 spring不仅要创建对象 还要在创建对象同时维护组件与组件依赖关系

        //定义: 给组件中成员变量进行赋值过程
        //语法:  1.组件中需要谁将谁声明为成员变量并提供公开SET方法  2.在spring配置文件中对应的组件内部使用property标签完成赋值过程




    }
}
