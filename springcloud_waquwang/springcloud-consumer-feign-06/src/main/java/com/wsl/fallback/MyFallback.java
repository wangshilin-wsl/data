package com.wsl.fallback;

import com.wsl.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName MyFallback.java
 * @Description TODO
 * @createTime 2023年03月06日 20:59:00
 */
@Component
public class MyFallback implements HelloService {
    @Override
    public String hello() {
        return "远程服务不可用，暂时采用本地逻辑代替。。。";
    }
}
