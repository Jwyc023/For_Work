package com.baizhi.test;

import com.baizhi.dao.EmpDAO;
import com.baizhi.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class  TestEmpDAO {

    //queryAll
    @Test
    public void testQueryAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        EmpDAO empDAO = sqlSession.getMapper(EmpDAO.class);
        empDAO.queryAll().forEach(emp->{
            System.out.println("当前员工信息: "+emp +"   部门信息: "+emp.getDept());
        });
        MybatisUtil.close(sqlSession);
    }
}
