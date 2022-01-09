package com.baizhi.controller;

import com.baizhi.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 用来测试springmvc中数据传递机制
 */
@Controller
@RequestMapping("attr")
public class AttrController {


    /**
     * 使用redirect跳转传递数据
     *  //传递数据两种方式 一种:地址栏?拼接数据  二种: session对象
     */
    @RequestMapping("test1")
    public String test1(HttpServletRequest request) throws UnsupportedEncodingException {
        //1.收集数据
        //2.调用业务
        String name="小陈";
        User user = new User("21", "百知教育", 23, new Date());
        request.getSession().setAttribute("user",user);
        //3.流程跳转
        return "redirect:/attr.jsp?name="+ URLEncoder.encode(name,"UTF-8");
    }

    /**
     * 使用forward跳转页面数据传递
     *  1.传递零散类型数据  2.传递对象类型数据 3.传递集合类型数据
     *
     *    使用request对象传递数据 ===> Model 对象 底层封装就是request对象
     *
     */
    @RequestMapping("test")
    public String test(Model model , HttpServletRequest request, HttpServletResponse response){
        //1.收集参数
        //2.调用业务方法 String name="小陈";
        String name = "小陈";
        User user = new User("21", "百知教育", 23, new Date());
        User user1 = new User("22", "xiaochen", 23, new Date());
        User user2 = new User("23", "xiaoming", 23, new Date());
        List<User> users = Arrays.asList(user1, user2);
        model.addAttribute("users",users);
        model.addAttribute("user",user);
        model.addAttribute("username",name);
        //request.setAttribute("users",users);
        //request.setAttribute("username",name);
        //request.setAttribute("user",user);
        //3.流程跳转
        return "attr";
    }
}
