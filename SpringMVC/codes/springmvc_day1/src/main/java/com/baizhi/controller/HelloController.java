package com.baizhi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {


    /**
     * @RequestMapping 修饰范围: 用在 类上  和 方法上
     *      1.用在方法上用来给当前方法加入指定的请求路径  相当于之前struts2中action标签的name属性
     *
     *      2.用在类上用来给类中所有方法加入一个统一请求路径在方法访问之前需要加入类上@requestMapping的路径
     *           相当于之前struts2中package标签的namespace属性
     *
     *        注意: 一旦类上和方法上同时加入@requestMapping访问时必须
     *          /项目名/类上@requestMapping的路径/访问方法上@requestMapping的路径
     * @return
     */
    @RequestMapping(value="/hello")
    public String hello(){
        //1.收集数据
        //2.调用业务方法
        System.out.println("hello spring mvc");
        //3.处理响应
        return "index";//页面逻辑名
    }


    @RequestMapping("save")
    public String save(){
        //1.收集数据
        //2.调用业务方法
        System.out.println("save method ....");
        //3.处理响应
        return "index";
    }
}
