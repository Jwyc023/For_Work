package com.baizhi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = RedisDay2Application.class)
@RunWith(SpringRunner.class)
public class TestBoundAPI {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    //spring data 为了方便我们对redis进行更友好的操作 因此有提供了bound api 简化操作
    @Test
    public void testBound(){

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());


        //redisTemplate   stringRedisTemplate  将一个key多次操作进行绑定 对key绑定
        //stringRedisTemplate.opsForValue().set("name","zhangsan");
        //stringRedisTemplate.opsForValue().append("name","是一个好人");
        //String s = stringRedisTemplate.opsForValue().get("name");
        //System.out.println(s);


        //对字符串类型key进行绑定 后续所有操作都是基于这个key的操作

        BoundValueOperations<String, String> nameValueOperations = stringRedisTemplate.boundValueOps("name");
        nameValueOperations.set("zhangsan");
        nameValueOperations.append("是一个好人");
        String s1 = nameValueOperations.get();
        System.out.println(s1);

        //对list set zset hash
        BoundListOperations<String, String> listsOperations = stringRedisTemplate.boundListOps("lists");
        listsOperations.leftPushAll("张三","李四","小陈");
        List<String> lists = listsOperations.range(0, -1);
        lists.forEach(list-> System.out.println(list));

        //set
        //redisTemplate.boundSetOps();
        //stringRedisTemplate.boundSetOps()
        //zset
        //stringRedisTemplate.boundZSetOps();
        //redisTemplate.boundZSetOps();
        //hash
        //stringRedisTemplate.boundHashOps();
        //redisTemplate.boundHashOps()


        /**
         * 1.针对于日后处理key value 都是 String 使用 StringRedisTemplate
         * 2.针对于日后处理的key value 存在对象 使用 RedisTemplate
         * 3.针对于同一个key多次操作可以使用boundXXxOps() Value List Set Zset Hash的api 简化书写
         */

        /**
         * redis应用场景
         *
         *  1.利用redis 中字符串类型完成 项目中手机验证码存储的实现
         *  2.利用redis 中字符串类型完成 具有失效性业务功能  12306  淘宝  订单还有:40分钟
         *  3.利用redis 分布式集群系统中 Session共享  memcache 内存 数据存储上限 数据类型比较简单  redis 内存  数据上限  数据类型丰富
         *  4.利用redis zset类型 可排序set类型  元素 分数  排行榜之类功能   dangdang 销量排行  sales(zset) [商品id,商品销量] ......
         *  5.利用redis 分布式缓存  实现
         *  6.利用redis 存储认证之后token信息   微信小程序 微信公众号 |用户 openid   ---> 令牌(token) redis 超时
         *  7.利用redis 解决分布式集群系统中分布式锁问题       redis 单进程 单线程   n 20 定义
         *      jvm  1进程开启多个线程 synchronize int n=20
         *      jvm  1进程开启多个线程 synchronize int n=20
         *      .....  LRA脚本
         *
         */

    }


}
