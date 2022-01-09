package com.baizhi.dao;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpDAO {

    //查询所有员工并查询每个员工的部门
    List<Emp> queryAll();
}
