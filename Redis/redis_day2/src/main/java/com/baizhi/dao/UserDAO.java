package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(String id);

    void delete(String id);

    void save(User user);

    void update(User user);
}
