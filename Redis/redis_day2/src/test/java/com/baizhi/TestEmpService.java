package com.baizhi;

import com.baizhi.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@SpringBootTest(classes = RedisDay2Application.class)
@RunWith(SpringRunner.class)
public class TestEmpService {

    @Autowired
    private EmpService empService;

    @Test
    public void test(){
        empService.findAll().forEach(emp-> System.out.println(emp));
        System.out.println("===============================");
        empService.findAll().forEach(emp-> System.out.println(emp));
    }

    @Test
    public void testmd5(){
        String key= "1016170576:2258653968:com.baizhi.dao.EmpDAO.findAll:0:2147483647:select id,name from t_emp:SqlSessionFactoryBean";

        //利用spring框架提供md5工具类
        String s = DigestUtils.md5DigestAsHex(key.getBytes());
        System.out.println(s);

    }
}
