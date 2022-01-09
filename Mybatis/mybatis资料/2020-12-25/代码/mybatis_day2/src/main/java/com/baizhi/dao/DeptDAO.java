package com.baizhi.dao;

import com.baizhi.entity.Dept;

import java.util.List;

public interface DeptDAO {

    //查询所有部门并将每个部门的员工信息查询出来
    List<Dept> queryAll();
}
