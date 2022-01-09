package com.baizhi.handlerxception;

import com.baizhi.exceptions.UserNameNotFoundException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.handler.Handler;

/**
 * 自定义全局异常处理类
 */
public class GlobalExceptionResolver  implements HandlerExceptionResolver {


    /**
     * 用来处理发生异常时方法
     * @param request   当前请求对象
     * @param response  当前请求对应的响应对象
     * @param handler   当前请求的方法对象
     * @param ex        当前出现异常时的异常对象
     * @return          出现异常时展示视图和数据
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("进入全局异常处理器获取的异常信息为: "+ex.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        //基于不能业务异常跳转到不同页面
        if(ex instanceof UserNameNotFoundException){
            modelAndView.setViewName("redirect:/login.jsp");
        }else{
            modelAndView.setViewName("redirect:/error.jsp");//return "error" ===>  /error.jsp
        }
        //modelandview中model 默认放入request作用域  如果使用redirect跳转:model中数据会自动拼接到跳转url
        modelAndView.addObject("msg",ex.getMessage());
        return modelAndView;
    }
}
