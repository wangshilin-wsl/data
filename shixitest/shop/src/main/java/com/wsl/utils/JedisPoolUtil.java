package com.wsl.utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
public class JedisPoolUtil {
    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil() {

    }

    public static JedisPool getJedisPoolInstance() {
        if (jedisPool == null) {
            synchronized (JedisPoolUtil.class) {
                if (jedisPool == null) {
                    GenericObjectPoolConfig config = new GenericObjectPoolConfig();
                    config.setMaxIdle(300);
                    config.setMaxTotal(1000);
                    config.setMaxWaitMillis(30000);
                    config.setTestOnBorrow(true);
                    jedisPool = new JedisPool(config, "RedisIp", 6379, 30000, "密码");
                }
            }
        }
        return jedisPool;
    }

    public static void release(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }
}
