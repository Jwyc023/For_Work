package com.baizhi.test;

import com.baizhi.dao.PersonDAO;
import com.baizhi.entity.Person;
import com.baizhi.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestPersonDAO {


    //查询用户信息
    @Test
    public void testQueryAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PersonDAO personDAO = sqlSession.getMapper(PersonDAO.class);
        personDAO.queryAll().forEach(person-> {
            System.out.println("当前用户信息: "+person+ "  身份信息: "+person.getInfo());
        });
        MybatisUtil.close(sqlSession);
    }

    //保存用户信息
    @Test
    public void testSavePerson() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PersonDAO personDAO = sqlSession.getMapper(PersonDAO.class);
        try {
            Person person = new Person();
            person.setName("小陈");
            person.setAge(23);
            //外键信息
            person.setCardno("165342789384233455");
            personDAO.save(person);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MybatisUtil.close(sqlSession);
        }

    }
}
