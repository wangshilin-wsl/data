package com.wsl.cache;

import com.wsl.utils.ApplicationContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
@Slf4j
public class RedisCache implements Cache {
    private String id;

    public RedisCache(String id) {
        this.id = id;
    }

   /* @Autowired  这样是错误的
    private RedisTemplate redisTemplate;*/
    @Override
    public String getId() {
        log.info("id：[{}]",id);
        return this.id;
    }

    @Override//放入缓存
    public void putObject(Object o, Object o1) {
        log.info("放入缓存的key：[{}] 放入缓存的value：[{}]",o,o1);
        getRedisTemplate().opsForHash().put(id,o.toString(),o1);
    }

    @Override//从redis得到缓存
    public Object getObject(Object o) {
        log.info("从缓存中读取key ：[{}]",o);
        return   getRedisTemplate().opsForHash().get(id,o.toString());
    }

    @Override//删除指定的缓存信息
    public Object removeObject(Object o) {
        return  null;
    }

    @Override//清除缓存
    public void clear() {
        getRedisTemplate().delete(id);
    }

    @Override
    public int getSize() {
        return getRedisTemplate().opsForHash().size(id).intValue();
    }
    //获取redisTemplate的方法
    public RedisTemplate getRedisTemplate(){
        RedisTemplate template = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        return template;
    }
}
