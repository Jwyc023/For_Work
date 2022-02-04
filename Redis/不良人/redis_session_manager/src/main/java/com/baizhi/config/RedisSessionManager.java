package com.baizhi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession  //将整个应用中使用session的数据全部交给redis处理
public class RedisSessionManager {
}
