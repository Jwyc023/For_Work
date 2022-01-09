package com.baizhi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.User;
import com.baizhi.exceptions.UserNameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用来测试springmvc中响应json格式数据
 *
 */
@Controller
@RequestMapping("json")
public class JsonController {

    @RequestMapping("test")
    public String test(){
        System.out.println("===========2=============");
        throw new RuntimeException("保存失败,请稍后再试...");
        //return "index";//====> ModelAndView  view index
    }

    /**
     * 使用springmvc提供注解@ResponseBody
     *  作用:用来将控制器方法的返回值转为json,并响应给前台
     */
    @RequestMapping("showAll")
    public @ResponseBody List<User> showAll(){
        //1.收集数据
        //2.调用业务
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID().toString(),"小陈123",23,new Date()));
        users.add(new User(UUID.randomUUID().toString(),"小黑",25,new Date()));
        users.add(new User(UUID.randomUUID().toString(),"小明",26,new Date()));
        return users;
    }

    /**
     * 使用阿里fastjson转换json
     */
    @RequestMapping("findAll")
    public void findAll(HttpServletResponse response) throws IOException {
        //1.收集数据
        //2.调用业务
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID().toString(),"小陈",23,new Date()));
        users.add(new User(UUID.randomUUID().toString(),"小黑",25,new Date()));
        users.add(new User(UUID.randomUUID().toString(),"小明",26,new Date()));
        //fastjson
        String s = JSONObject.toJSONStringWithDateFormat(users, "yyyy-MM-dd");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);
    }
}
