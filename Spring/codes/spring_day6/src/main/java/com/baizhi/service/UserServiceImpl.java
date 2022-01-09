package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
@Scope("prototype")
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAO userDAO;

    @Override
    public void save(String name) {
        userDAO.save(name);
        System.out.println("Service: "+name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,
            isolation = Isolation.DEFAULT,
            noRollbackFor = {},
            rollbackFor = {},
            readOnly = false,
            timeout = -1
        )
    public void find() {

    }
}
