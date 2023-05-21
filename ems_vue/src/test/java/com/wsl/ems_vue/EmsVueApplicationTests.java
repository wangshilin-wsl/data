package com.wsl.ems_vue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class EmsVueApplicationTests {
   @Autowired
   private StringRedisTemplate stringRedisTemplate;
   @Autowired
   private RedisTemplate redisTemplate;//对对象进行操作的
   @Test
   public void test(){
      stringRedisTemplate.opsForValue().set("name","张三");
      System.out.println(stringRedisTemplate.opsForValue().get("name"));
   }
}
