package com.baizhi.test;

import com.baizhi.dao.InfoDAO;
import com.baizhi.entity.Info;
import com.baizhi.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestInfoDAO {

    //保存信息
    @Test
    public void testSaveInfo(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            InfoDAO infoDAO = sqlSession.getMapper(InfoDAO.class);
            Info info = new Info();
            info.setCardno("165342789384233455");
            info.setAddress("北京市朝阳区");
            infoDAO.save(info);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            MybatisUtil.close(sqlSession);
        }
    }
}
