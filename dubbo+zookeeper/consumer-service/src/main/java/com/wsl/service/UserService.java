package com.wsl.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
@Service//放到spring容器中
public class UserService {
    //想拿到provider-service提供的票
    @Reference//应用,pom坐标或者可以定义路径相同的接口名
    TicketService ticketService;
    public void buyTicket(){
        String ticket=ticketService.getTicket();
        System.out.println("在注册中心拿到==>"+ticket);
    }
}
