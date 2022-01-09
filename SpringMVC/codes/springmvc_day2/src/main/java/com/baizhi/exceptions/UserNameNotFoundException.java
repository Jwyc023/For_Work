package com.baizhi.exceptions;

//自定义用户名不存的异常
public class UserNameNotFoundException extends RuntimeException {
    public UserNameNotFoundException(String message) {
        super(message);
    }
}
