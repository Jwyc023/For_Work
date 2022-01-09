package factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

//用来在工厂中创建复杂对象
public class CalendarFactoryBean  implements FactoryBean<Calendar> {

    //用来书写复杂对象的创建方式
    @Override
    public Calendar getObject() throws Exception {
        return Calendar.getInstance();
    }

    //指定创建的复杂对象的类型
    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    //用来指定创建的对象模式 true 单例 false  多例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
