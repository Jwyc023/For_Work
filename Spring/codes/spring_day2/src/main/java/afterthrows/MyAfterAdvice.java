package afterthrows;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

//自定义后置通知和异常通知
public class MyAfterAdvice  implements AfterReturningAdvice, ThrowsAdvice {

    //参数1:目标方法返回值  参数2: 当前执行方法对象  参数3:执行方法参数  参数4:目标对象
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("==========进入后置通知=========");
        System.out.println("返回值: "+returnValue);
        System.out.println("方法名: "+method.getName());
        System.out.println("方法的参数: " + args[0]);
        System.out.println("目标对象: " +target);
    }


    //出现异常时执行通知处理
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("===========进入异常通知============");
        System.out.println("方法名: "+method.getName());
        System.out.println("方法的参数: " + args[0]);
        System.out.println("目标对象: " +target);
        System.out.println("异常信息: "+ex.getMessage());
    }


}
