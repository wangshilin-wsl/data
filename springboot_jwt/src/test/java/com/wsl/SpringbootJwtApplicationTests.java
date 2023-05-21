package com.wsl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class SpringbootJwtApplicationTests {

    @Test
    void contextLoads() {
        Map<String,Object> map=new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,60);//20秒
        String token = JWT.create().withHeader(map)//header
                .withClaim("userId", 21)//payload
                .withClaim("username", "小黑")//payload
                .withExpiresAt(instance.getTime())//指定令牌的过期时间
                .sign(Algorithm.HMAC256("!@wre"));//签名,自己指定秘钥
        System.out.println(token);//输出令牌
    }
    @Test
    void test1(){
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!@wre")).build();
        //验证令牌,验证通过会返回对应的对象，不通过则会抛出异常
        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDgyNzQ5NTUsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoi5bCP6buRIn0.jzTNhlGygoOKY70FMriBRK8aj6URfUuzQi8uzS-C_E0");
        System.out.println(decodedJWT.getClaim("userId").asInt());
        System.out.println(decodedJWT.getClaim("username").asString());
        System.out.println(decodedJWT.getExpiresAt());
    }
}
