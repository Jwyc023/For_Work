package com.baizhi.interceptors;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器
 */
public class MyInterceptor  implements HandlerInterceptor {

    //1.请求经过拦截器会优先进入拦截器中preHandler方法执行preHandler方法中内容
    //2.如果preHandler 返回为true 代表放行请求  如果返回值为false 中断请求
    //3.如果preHandler返回值为true,会执行当前请求对应的控制器中方法
    //4.当控制器方法执行结束之后,会返回拦截器中执行拦截器中postHandler方法
    //5.posthanlder执行完成之后响应请求,在响应请求完成后会执行afterCompletion方法
    @Override
    //参数1: 当前请求对象 参数2:当前请求对应响应对象  参数3:当前请求的控制器对应的方法对象
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(((HandlerMethod)handler).getMethod().getName());
        System.out.println("===========1=============");
        //强制用户登录
        /*Object user = request.getSession().getAttribute("user");
        if(user==null){
            //重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }*/
        return true;
    }

    @Override
    //参数1: 当前请求对象 参数2:当前请求对应响应对象  参数3:当前请求的控制器对应的方法对象 参数4: 当前请求控制器方法返回值 = 当前请求控制器方法返回的modelandview对象 modelandview 模型和试图
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(modelAndView);
        System.out.println("===========3=============");
    }


    @Override
    //注意: 无论正确还是失败都会执行
    //参数1: 当前请求对象 参数2:当前请求对应响应对象  参数3:当前请求的控制器对应的方法对象  参数4: 请求过程中出现异常时异常对象
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(ex!=null){
            System.out.println(ex.getMessage());
        }
        System.out.println("===========4=============");
    }
}
