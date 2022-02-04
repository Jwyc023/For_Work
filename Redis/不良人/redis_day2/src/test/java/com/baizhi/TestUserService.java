package com.baizhi;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.ibatis.cache.Cache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(classes = RedisDay2Application.class)
@RunWith(SpringRunner.class)
public class TestUserService {
    
    
    @Autowired
    private UserService userService;
    
    @Test
    public void testFindAll(){

        userService.findAll().forEach(u-> System.out.println("u = " + u));

        System.out.println("==================================");

        userService.findAll().forEach(u-> System.out.println("u = " + u));
    }

    @Test
    public void testFindOne(){

        User byId = userService.findById("1");
        System.out.println("==================================");
        User byId1 = userService.findById("1");

    }


    @Test
    public void testDelete(){
        userService.delete("1");
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setName("百知教育");
        user.setAge(23);
        user.setBir(new Date());
        userService.save(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId("7d8a2945-0271-4aa0-bea6-9945a2050ff2").setName("小陈").setAge(23).setBir(new Date());
        userService.update(user);
    }


}
