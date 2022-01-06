package com.baizhi.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;

import java.util.List;

public class TestZSet {
    private Jedis jedis;

    @Before
    public void before(){
        this.jedis = new Jedis("192.168.202.205", 7000);
    }

    @After
    public void after(){
        jedis.close();
    }


    //测试ZSET相关
    @Test
    public void testZset(){

        //zadd
        jedis.zadd("names",10,"张三");

        //zrange
        jedis.zrange("names",0,-1);

        //zcard
        jedis.zcard("names");

        //zrangeByScore
        jedis.zrangeByScore("names","0","100",0,5);

        //..

    }

}
