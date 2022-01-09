package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 添加用户
     */
    @RequestMapping("save")
    public String save(User user) {
        //2.调用业务方法
        try {
            userService.save(user);
            return "redirect:/user/findAll";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/add.jsp";
        }
    }

    /**
     * 查询所有
     */
    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request) {
        //1.收集数据
        //2.调用业务对象
        List<User> users = userService.findAll();
        request.setAttribute("users", users);
        return "findAll";
    }
}
