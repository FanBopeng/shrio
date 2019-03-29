package com.shrio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.shrio.mapper")
public class ShrioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShrioApplication.class, args);
    }

}
