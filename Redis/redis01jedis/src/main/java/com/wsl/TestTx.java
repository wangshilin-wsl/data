package com.wsl;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTx {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.flushDB();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","wsl");
        Transaction multi = jedis.multi();//开启事务
        String string = jsonObject.toJSONString();
        try {
            multi.set("user1",string);
            multi.set("user2",string);
            int i=1/0;//代码抛出异常
            multi.exec();//执行事务
        }catch (Exception e){
            multi.discard();
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();//关闭连接
        }
    }
}
