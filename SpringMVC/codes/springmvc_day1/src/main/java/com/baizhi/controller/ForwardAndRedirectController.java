package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用来测试forward和redirect跳转
 */
@Controller
@RequestMapping("forwardAndRedirect")
public class ForwardAndRedirectController {

    /**
     * 测试forward跳转到页面
     *  默认: controller跳转到jsp页面就是forward跳转
     */
    @RequestMapping("test")
    public String test(){
        System.out.println("test ");
        return "index";
    }

    /**
     * 测试redirect跳转到页面
     * redirect跳转到页面:  使用springmvc提供关键字 redirect:
     * 使用语法: return "redirect:/index.jsp"   return "redirect:视图全名"
     * 注意:redirect跳转不会经过视图解析器
     */
    @RequestMapping("test1")
    public String test1(){
        System.out.println("test1");
        return "redirect:/index.jsp";
    }


    /**
     * 测试forward跳转到相同controller类中不同方法
     * forward跳转到相同controller中不同方法: 使用springmvc提供关键字  forward:
     * 使用语法:
     *  return "forward:/跳转Controller类上@requestMapping路径/跳转类中指定方法上@requestMapping路径"
     */
    @RequestMapping("test2")
    public String test2(){
        System.out.println("test2");
        return "forward:/forwardAndRedirect/test";
    }

    /**
     * 使用redirect跳转到相同controller类中不同方法
     * redirect跳转到相同controller类中不同方法: 使用springmvc提供关键字 redirect:
     * 使用语法:
     *  return "redirect:/跳转Controller类上@requestMapping路径/跳转类中指定方法上@requestMapping路径"
     * @return
     */
    @RequestMapping("test3")
    public String test3(){
        System.out.println("test3");
        return  "redirect:/forwardAndRedirect/test";//地址栏 test   test3 test   index.jsp
    }

    /**
     * 测试跳转到不同controller中相关方法
     * forward and redirect
     * forward:    redirect:
     */
    @RequestMapping("test4")
    public String test4(){
        System.out.println("test4");
        return "redirect:/hello/hello";
    }
}
