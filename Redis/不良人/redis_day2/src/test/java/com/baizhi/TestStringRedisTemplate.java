package com.baizhi;


import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;


//启动springboot应用
@SpringBootTest(classes = RedisDay2Application.class)
@RunWith(SpringRunner.class)
public class TestStringRedisTemplate {


    //注入StringRedisTemplate
    @Autowired
    private StringRedisTemplate stringRedisTemplate;  //key  value 都是字符串


    //操作redis中key相关
    @Test
    public void testKey(){
        //stringRedisTemplate.delete("name");//删除一个key
        Boolean hasKey = stringRedisTemplate.hasKey("name");//判断某个key是否存在
        System.out.println(hasKey);


        DataType name = stringRedisTemplate.type("name");//判断key所对应值的类型
        System.out.println(name);


        Set<String> keys = stringRedisTemplate.keys("*");//获取redis中所有key
        keys.forEach(key -> System.out.println("key = " + key));

        Long expire = stringRedisTemplate.getExpire("age");//获取key超时时间 -1 永不超时  -2  key不存在 >=0 过期时间
        System.out.println(expire);

        stringRedisTemplate.randomKey();//在redis中随机获取一个key

        //stringRedisTemplate.rename("age","age1");//修改key名字 要求key必须存在 不存在 报错

        //stringRedisTemplate.renameIfAbsent("name","name1");//修改key名字  判断key是否存在

        stringRedisTemplate.move("name1",1);//移动key到指定库

    }

    //操作redis中字符串 opsForValue 实际操作就是redis中String类型
    @Test
    public void testString(){
        stringRedisTemplate.opsForValue().set("name","小陈"); //set 用来设置一个key value

        String value= stringRedisTemplate.opsForValue().get("name"); //用来获取一个key对应value
        System.out.println("value = " + value);

        stringRedisTemplate.opsForValue().set("code","2357",120, TimeUnit.SECONDS);//设置一个key 超时时间

        stringRedisTemplate.opsForValue().append("name","他是是一个好人,单纯少年!");//追加

    }

    //操作redis中list类型   opsForList 实际操作就是redis中list类型
    @Test
    public void testList(){
        //stringRedisTemplate.opsForList().leftPush("names","小陈");//创建一个列表  并放入一个元素
        //stringRedisTemplate.opsForList().leftPushAll("names","小陈","小张","小王");//创建一个列表 放入多个元素
        List<String> names = new ArrayList<>();
        names.add("xiaoming");
        names.add("xiaosan");
        //stringRedisTemplate.opsForList().leftPushAll("names",names);//创建一个列表 放入多个元素

        List<String> stringList = stringRedisTemplate.opsForList().range("names", 0, -1); //遍历list
        stringList.forEach(value-> System.out.println("value = " + value));

        stringRedisTemplate.opsForList().trim("names",1,3); //截取指定区间的list
    }

    //操作redis中set类型   opsForSet 实际操作就是redis中set类型
    @Test
    public void testSet(){
        stringRedisTemplate.opsForSet().add("sets","张三","张三","小陈","xiaoming");//创建set 并放入多个元素


        Set<String> sets = stringRedisTemplate.opsForSet().members("sets");//查看set中成员
        sets.forEach(value-> System.out.println("value = " + value));

        Long size = stringRedisTemplate.opsForSet().size("sets");//获取set集合元素个数
        System.out.println("size = " + size);
    }

    //操作redis中Zset类型   opsForZSet 实际操作就是redis中Zset类型
    @Test
    public void testZset(){
        stringRedisTemplate.opsForZSet().add("zsets","小黑",20);//创建并放入元素

        Set<String> zsets = stringRedisTemplate.opsForZSet().range("zsets", 0, -1);//指定范围查询

        zsets.forEach(value-> System.out.println(value));
        System.out.println("=====================================");
        Set<ZSetOperations.TypedTuple<String>> zsets1 = stringRedisTemplate.opsForZSet().rangeByScoreWithScores("zsets", 0, 1000);//获取指定元素以及分数

        zsets1.forEach(typedTuple ->{
            System.out.println(typedTuple.getValue());
            System.out.println(typedTuple.getScore());
        });

    }

    //操作redis中Hash类型   opsForHash 实际操作就是redis中Hash类型

    @Test
    public void testHash(){

        stringRedisTemplate.opsForHash().put("maps","name","张三");//创建一个hash类型 并放入key value

        Map<String,String> map =  new HashMap<String,String>();
        map.put("age","12");
        map.put("bir","2012-12-12");
        stringRedisTemplate.opsForHash().putAll("maps",map);  //放入多个key value


        List<Object> values = stringRedisTemplate.opsForHash().multiGet("maps", Arrays.asList("name", "age"));//获取多个key的value
        values.forEach(value-> System.out.println(value));

        String value  = (String) stringRedisTemplate.opsForHash().get("maps", "name");//获取hash中某个key的值

        List<Object> vals = stringRedisTemplate.opsForHash().values("maps");//获取所有values

        Set<Object> keys = stringRedisTemplate.opsForHash().keys("maps");//获取所有keys


    }



}
