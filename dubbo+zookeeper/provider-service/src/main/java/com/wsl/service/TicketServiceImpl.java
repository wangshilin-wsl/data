package com.wsl.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
//zookeeper:服务注册于发现
@Component//使用了dubbo后尽量不要用service注解
@Service//可以被扫描到，在项目启动就自动注册到注册中心
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《狂神说Java》";
    }
}
