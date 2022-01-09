package com.baizhi.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    private ClassPathXmlApplicationContext context ;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String springConfig = sce.getServletContext().getInitParameter("springConfig");
        System.out.println(springConfig);
        System.out.println("服务器启动时初始化");
        this.context = new ClassPathXmlApplicationContext(springConfig);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("服务器关闭时销毁");
        context.close();
    }

}
