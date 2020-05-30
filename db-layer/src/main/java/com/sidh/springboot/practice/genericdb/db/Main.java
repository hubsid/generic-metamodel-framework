package com.sidh.springboot.practice.genericdb.db;

import com.sidh.springboot.practice.genericdb.dtos.entity.Attribute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = Attribute.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
