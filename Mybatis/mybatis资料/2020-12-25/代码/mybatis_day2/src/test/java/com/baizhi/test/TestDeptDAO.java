package com.baizhi.test;

import com.baizhi.dao.DeptDAO;
import com.baizhi.entity.Emp;
import com.baizhi.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestDeptDAO {

    //查询所有
    @Test
    public void TestQueryAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DeptDAO deptDAO = sqlSession.getMapper(DeptDAO.class);

        deptDAO.queryAll().forEach(dept->{
            System.out.println("部门信息:====> "+dept);
            dept.getEmps().forEach(emp->{
                System.out.println("       员工信息: ====>" +emp);
            });
            System.out.println("------------------------------------");
        });

        MybatisUtil.close(sqlSession);
    }
}
