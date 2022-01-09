package com.baizhi.test;

import com.baizhi.dao.StudentDAO;
import com.baizhi.entity.Student;
import com.baizhi.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestStudentDAO {

    @Test
    public void testQueryById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
        Student student = studentDAO.queryById(12);
        System.out.println("学生信息: "+student);
        student.getCourses().forEach(course -> {
            System.out.println("    课程信息: "+course);
        });
        MybatisUtil.close(sqlSession);
    }
}
