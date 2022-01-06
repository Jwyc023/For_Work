package com.baizhi;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.dao")
public class RedisDay2Application {

    public static void main(String[] args) {
        SpringApplication.run(RedisDay2Application.class, args);
    }

}
