package com.baizhi.action;

import com.opensymphony.xwork2.Action;

public class UserAction {
    public String hello(){
        System.out.println("hello spring struts");
        return Action.SUCCESS;
    }
}
