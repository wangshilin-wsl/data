package com.wsl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.wsl.pojo.User;
import com.wsl.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    @Autowired
    private RedisUtil redisUtil;
    @Test
    void contextLoads() {
        //redisTemplate  操作不同的数据类型
        //opsForValue 操作字符串 类似String
        //opsForList 操作list 类似list
        //opsForSet 操作Set 类似list
        //opsForHash 操作Hash 类似list
        //除了基本的操作，我们常用的方法都可以直接redisTemplate来操作，比如事务和基本的增删改查


        //获取连接数据库对象
        //RedisConnection connection = template.getConnectionFactory().getConnection();
       // connection.flushDb();

        template.opsForValue().set("myKey","hhhh");
        System.out.println(template.opsForValue().get("myKey"));
    }
    @Test
    public void test1() throws JsonProcessingException {
        //真实开发一般都是用json来传递对象
        User user = new User("王世林", 21);
       // String string = new ObjectMapper().writeValueAsString(user);
        template.opsForValue().set("user",user);

        System.out.println(template.opsForValue().get("user"));
    }

    @Test
    public void test2(){
        redisUtil.set("name","wsl");
        System.out.println(redisUtil.get("name"));
    }

}
