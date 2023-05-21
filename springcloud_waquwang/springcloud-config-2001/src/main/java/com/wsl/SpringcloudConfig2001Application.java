package com.wsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringcloudConfig2001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfig2001Application.class, args);
    }

}
