package com.tarrasques.straw.api.question;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tarrasques.straw.api.question.mapper")
public class StrawApiQuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrawApiQuestionApplication.class, args);
    }

}
