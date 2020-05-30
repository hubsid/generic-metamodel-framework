package com.sidh.springboot.practice.genericdb.ui;

import com.sidh.springboot.practice.genericdb.dtos.entity.AttributeType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = AttributeType.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
