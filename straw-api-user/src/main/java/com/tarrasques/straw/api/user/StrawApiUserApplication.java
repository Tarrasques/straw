package com.tarrasques.straw.api.user;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@MapperScan("com.tarrasques.straw.api.user.mapper")
@EnableWebSecurity
public class StrawApiUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrawApiUserApplication.class, args);
    }

}
