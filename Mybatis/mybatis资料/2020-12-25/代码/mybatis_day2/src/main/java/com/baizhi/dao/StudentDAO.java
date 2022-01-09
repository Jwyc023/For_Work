package com.baizhi.dao;

import com.baizhi.entity.Student;

import java.util.List;

public interface StudentDAO {

    //查询学生信息并查询所选课程
    Student queryById(Integer id);
}
