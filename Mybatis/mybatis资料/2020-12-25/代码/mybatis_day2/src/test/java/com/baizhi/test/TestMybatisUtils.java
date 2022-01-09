package com.baizhi.test;

import com.baizhi.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMybatisUtils {


    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        System.out.println(sqlSession);
    }
}
