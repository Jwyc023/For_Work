package com.baizhi.dao;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component("userDAO") === 等价于  @Component(value="userDAO")
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
    @Override
    public void save(String name) {
        System.out.println("DAO: "+name);
    }
}
