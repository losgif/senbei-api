package com.losgif.senbeiapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.losgif.senbeiapi.mappers")
@SpringBootApplication
public class SenbeiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SenbeiApiApplication.class, args);
    }

}
