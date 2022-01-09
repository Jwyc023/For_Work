package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.opensymphony.xwork2.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("userAction")
@Scope("prototype")
public class UserAction {

    @Autowired
    private UserService userService;

    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    /**
     * 查询所有
     * @return
     */
    public String findAll(){
        this.users = userService.findAll();
        return Action.SUCCESS;
    }

}
