package factorybean;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        //日历类
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getTime());
//
//        //Connection
//        Class.forName("dirver");
//        Connection conn = DriverManager.getConnection("url","username","password");
//        System.out.println(conn);


        ApplicationContext context = new ClassPathXmlApplicationContext("factorybean/spring.xml");
//        Connection conn = (Connection) context.getBean("conn");
//        System.out.println(conn);
//        Calendar calendar = (Calendar) context.getBean("calendar");
//        Calendar calendar1 = (Calendar) context.getBean("calendar");
//        System.out.println(calendar);
//        System.out.println(calendar1);
//        System.out.println(calendar==calendar1);
//        System.out.println(calendar.getTime());
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);


    }
}
