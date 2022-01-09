package com.baizhi.dao;

public interface DeptDAO {


    void save(String name);

    void update(String name);

    void delete(Integer id);

    String find(String name);

}
