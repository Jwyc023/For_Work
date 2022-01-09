package com.baizhi.test;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.utils.MybatisUtil;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TestQuery {



    //查询总条数
    @Test
    public void testQueryTotalCounts(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        Long counts = userDAO.queryTotalCounts();
        System.out.println("总记录数为: "+counts);
        MybatisUtil.close(sqlSession);
    }

    //分页查询
    @Test
    public void testQueryPage(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        //mysql默认从0开始  start 当前页:1   起始位置:0 当前页2:  起始位置:2  当前页:3 起始位置: 4
        // 起始位置规律:(当前页-1)*每页显示的记录数
        List<User> users = userDAO.queryByPage(4, 2);
        users.forEach(user-> System.out.println(user));
        MybatisUtil.close(sqlSession);
    }

    //模糊查询
    @Test
    public void testQueryLike(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        List<User> users = userDAO.queryLikeByName("三");
        users.forEach(user-> System.out.println(user));
        MybatisUtil.close(sqlSession);
    }

    //查询一个
    @Test
    public void testQueryById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        User user = userDAO.queryById(7);
        System.out.println(user);
        MybatisUtil.close(sqlSession);
    }


   //查询所有
    @Test
    public void testQueryAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        List<User> users = userDAO.queryAll();
        //遍历
        users.forEach(user-> System.out.println(user));
        MybatisUtil.close(sqlSession);
    }
}
