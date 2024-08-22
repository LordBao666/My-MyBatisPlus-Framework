package com.lordbao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Lord_Bao
 * @Date 2024/8/21 22:02
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.lordbao.mapper")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
