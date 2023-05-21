package com.wsl;

import com.wsl.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootRabbitmqOrderProducerApplicationTests {
    @Resource
    private OrderService orderService;
    @Test
    void contextLoads() {
        orderService.makeOrder("1", "1", 2);
    }

    @Test
    void test1() {
        orderService.makeOrderDirect("1", "1", 2);
    }

    @Test
    void test2() {
        orderService.makeOrderTopic("1", "1", 2);
    }

    @Test
    void test3() {
        orderService.makeOrderTTL("1", "1", 2);
    }

    @Test
    void test4() {
        orderService.makeOrderTTLMessage("1", "1", 2);
    }

}
