package com.baizhi.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestSet {
    private Jedis jedis;

    @Before
    public void before(){
        this.jedis = new Jedis("192.168.202.205", 7000);
    }

    @After
    public void after(){
        jedis.close();
    }


    //测试SET相关
    @Test
    public void testSet(){

        //sadd
        jedis.sadd("names","zhangsan","lisi");

        //smembers
        jedis.smembers("names");

        //sismember
        jedis.sismember("names","xiaochen");

        //...
    }

}
