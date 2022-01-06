package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String id);

    void delete(String id);

    void save(User user);

    void update(User user);
}
