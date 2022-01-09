package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();

}
