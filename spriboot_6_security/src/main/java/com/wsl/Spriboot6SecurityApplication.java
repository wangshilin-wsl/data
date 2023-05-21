package com.wsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class Spriboot6SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spriboot6SecurityApplication.class, args);
    }

}
