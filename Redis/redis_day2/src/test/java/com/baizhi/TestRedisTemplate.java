package com.baizhi;


import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;


//启动springboot应用
@SpringBootTest(classes = RedisDay2Application.class)
@RunWith(SpringRunner.class)
public class TestRedisTemplate {


    //注入RedisTemplate key Object  Value Object  ===>   对象序列化   name  new User() ====>   name序列化  对象序列化结果
    @Autowired
    private RedisTemplate redisTemplate;


    //opsForxxx  Value String  List  Set  Zset  hash

    @Test
    public void testRedisTemplate(){

        /**
         * redisTemplate对象中 key 和 value 的序列化都是 JdkSerializationRedisSerializer
         *      key: string
         *      value: object
         *      修改默认key序列化方案 :  key  StringRedisSerializer
         */

        //修改key序列化方案   String类型序列
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //修改hash key 序列化方案
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        User user = new User();
        user.setId(UUID.randomUUID().toString()).setName("小陈").setAge(23).setBir(new Date());
        redisTemplate.opsForValue().set("user", user);//redis进行设置 对象需要经过序列化

        User user1 = (User) redisTemplate.opsForValue().get("user");
        System.out.println(user1);


        redisTemplate.opsForList().leftPush("list",user);

        redisTemplate.opsForSet().add("set",user);

        redisTemplate.opsForZSet().add("zset",user,10);

        redisTemplate.opsForHash().put("map","name",user);


    }


}
