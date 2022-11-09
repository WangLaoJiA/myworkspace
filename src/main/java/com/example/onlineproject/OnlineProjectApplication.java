package com.example.onlineproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.onlineproject.dao")
@EnableScheduling
public class OnlineProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineProjectApplication.class, args);
    }

}
