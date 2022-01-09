package com.baizhi.test;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.utils.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class TestCUD {




    //删除操作
    @Test
    public void delete() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            int delete = userDAO.delete(5);
            System.out.println("删除条数: "+delete);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.close(sqlSession);
        }
    }

    //更新操作
    @Test
    public void update() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            //更新数据
            // 更新: 有值更新 不存在值保留原始的值  1.先查再改  2.动态sql
            User user = new User();
            user.setId(1);
            user.setName("小张");
            user.setAge(26);
            int update = userDAO.update(user);
            System.out.println("修改的条数:" +update);
            sqlSession.commit();//提交
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.close(sqlSession);
        }

    }

    //保存操作
    @Test
    public void save() throws IOException {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            //获取DAO对象
            UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
            User user = new User();
            user.setName("小三");
            user.setAge(23);
            user.setBir(new Date());
            userDAO.save(user);
            sqlSession.commit();//提交事务
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();//事务回滚
        } finally {
            MybatisUtil.close(sqlSession);
        }
    }
}
