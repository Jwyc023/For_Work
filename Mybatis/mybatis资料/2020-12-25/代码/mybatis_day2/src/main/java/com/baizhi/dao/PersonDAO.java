package com.baizhi.dao;

import com.baizhi.entity.Person;

import java.util.List;

public interface PersonDAO {
    //保存用户信息方法
    int save(Person person);

    //查询所有用户信息
    List<Person> queryAll();
}
