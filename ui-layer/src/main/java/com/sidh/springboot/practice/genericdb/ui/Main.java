package com.sidh.springboot.practice.genericdb.ui;

import com.sidh.springboot.practice.genericdb.db.repo.AttributeTypeRepo;
import com.sidh.springboot.practice.genericdb.dtos.entity.AttributeType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {Main.class, com.sidh.springboot.practice.genericdb.db.Main.class})
@EnableJpaRepositories(basePackageClasses = {AttributeTypeRepo.class})
@EntityScan(basePackageClasses = AttributeType.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
