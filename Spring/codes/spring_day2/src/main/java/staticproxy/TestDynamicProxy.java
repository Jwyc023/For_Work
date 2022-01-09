package staticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    public static void main(String[] args) {


        //使用动态代理对象:  指的是在程序运行过程中动态通过代码的方式为指定的类生成动态代理对象


        UserService userService = new UserServiceImpl();//目标类
        //proxy 用来生成动态对象的类

        //参数1: classLoader 类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        //参数2: Class[] 目标对象的接口的类型的数组
        Class[] classes = {UserService.class};

        //参数3: InvocationHandler接口类型  invoke 方法 用来书写额外功能 附加操作

        //dao  Userdao    userdao = sqlSession.getMapper(userdao.class);  userdao.save() =

        //返回值: 创建好的动态代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, classes, new InvocationHandler() {
            @Override
            //通过动态代理对象调用自己里面代理方法时会优先指定invokcationHandler类中invoke
            //参数1: 当前创建好的代理对象  参数2:当前dialing对象执行的方法对象  参数3:当前代理对象执行方法的参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("当前执行的方法: "+method.getName());
                System.out.println("当前执行的方法的参数: "+args[0]);

                try {
                    System.out.println("开启事务");
                    //调用目标类中业务方法通过反射机制 调用目标类中当前方法
                    Object invoke = method.invoke(new UserServiceImpl(), args);
                    System.out.println("提交事务");
                    return invoke;
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("回滚事务");
                }
                return null;
            }

        });

        System.out.println(proxy.getClass());
        String result = proxy.findAll("小陈");//通过动态代理对象调用代理中方法
        System.out.println(result);
    }
}
