package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.opensymphony.xwork2.Action;

import java.util.List;

public class UserAction {


    //依赖注入只需要SET方法
    private UserService userService;
    //接收参数 数据传递 必须GET SET方法
    private List<User> users;
    private User user;

    /**
     * 处理添加用户的方法
     *
     */
    public String save(){
        //1.收参
        //2.调用业务方法
        userService.save(user);
        //3.处理响应
        return Action.SUCCESS;
    }


    /**
     * 处理查询所有的方法
     * @return
     */
    public String findAll() {
        //1.收集数据 2.调用业务  3.处理响应
        this.users = userService.findAll();
        return Action.SUCCESS;
    }


    //SET和GET


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
