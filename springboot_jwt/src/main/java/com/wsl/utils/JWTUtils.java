package com.wsl.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static final String SING="!@wre321321$%Q%";
    //生成token head.payload.signature
    public static String getToken(Map<String, String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7);//默认7天过期
        JWTCreator.Builder builder=JWT.create();
        //payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //签名，signature
        String token = builder
                .withExpiresAt(instance.getTime())//指定令牌的过期时间
                .sign(Algorithm.HMAC256(SING));//签名,自己指定秘钥
        return token;
    }
    //验证token,验证通过则没有任何异常，验证失败则会抛出异常
    public static DecodedJWT verify(String token){
         return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }
   /* //获取token信息的方法
    public static DecodedJWT getTokenInfo(String token){
        return JWT.require(Algorithm.HMAC256("!@wre")).build().verify(token);
    }*/
}
