package com.wsl.service;

import com.wsl.fallback.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName HelloService.java
 * @Description TODO
 * @createTime 2023年03月02日 20:02:00
 */
//绑定远程服务的名称
@FeignClient(name = "springcloud-service-provider", fallbackFactory = MyFallbackFactory.class)
public interface HelloService {

    //远程的服务提供者提供的方法
    @RequestMapping("/service/hello")
    public String hello();
}
