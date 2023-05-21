package com.wsl.fallback;

import com.wsl.service.HelloService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName MyFallbackFactory.java
 * @Description TODO
 * @createTime 2023年03月06日 21:06:00
 */
@Component
public class MyFallbackFactory implements FallbackFactory<HelloService> {

    //拿到远程调用的异常信息
    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String hello() {
                return throwable.getMessage();
            }
        };
    }
}
