package com.sidh.springboot.practice.genericdb.ui.controller;

import com.sidh.springboot.practice.genericdb.db.service.AttributeTypeService;
import com.sidh.springboot.practice.genericdb.dtos.entity.AttributeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {
    @Autowired
    AttributeTypeService attributeTypeService;

    @RequestMapping("/ui/test")
    public List<AttributeType> test() {
        return attributeTypeService.getAllAttributeTypes().stream()
                .map(a -> {a.setDescription("test module description"); return a;}).collect(Collectors.toList());

    }
}
