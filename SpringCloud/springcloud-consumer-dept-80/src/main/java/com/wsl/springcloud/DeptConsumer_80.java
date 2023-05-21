package com.wsl.springcloud;

import com.wsl.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeptConsumer_80.java
 * @Description TODO
 * @createTime 2022年04月07日 19:58:00
 */
//ribbon和eureka整合后，客户端可以直接调用，不用关注ip和port
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就能去加载我们自定义的类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = MyRule.class)
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
