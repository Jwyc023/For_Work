package com.baizhi.service;

import com.baizhi.dao.DeptDAO;

import java.util.Date;

//业务层组件
public class DeptServiceImpl implements DeptService {

    //需要DAO组件
    private DeptDAO deptDAO;

    public void setDeptDAO(DeptDAO deptDAO) {
        this.deptDAO = deptDAO;
    }

    @Override
    public void save(String name) {
        System.out.println("处理save业务逻辑");
        deptDAO.save(name);
    }

    @Override
    public void update(String name) {
        System.out.println("处理update业务逻辑");
        deptDAO.update(name);

    }

    @Override
    public void delete(Integer id) {
        System.out.println("处理delete业务逻辑");
        deptDAO.delete(id);
    }

    @Override
    public String find(String name) {
        System.out.println("处理find业务逻辑");
        String s = deptDAO.find(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //throw new RuntimeException("执行出错啦!!!");
        return null;
    }
}
