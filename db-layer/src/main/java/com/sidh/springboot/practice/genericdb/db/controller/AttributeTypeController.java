package com.sidh.springboot.practice.genericdb.db.controller;

import com.sidh.springboot.practice.genericdb.db.service.AttributeTypeService;
import com.sidh.springboot.practice.genericdb.dtos.entity.AttributeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attributeType")
public class AttributeTypeController {
    @Autowired
    private AttributeTypeService service;

    @GetMapping("")
    List<AttributeType> getAllEndpoint() {
        return service.getAllAttributeTypes();
    }

    @GetMapping("/{name}")
    Optional<AttributeType> getParticularEndpoint (@PathVariable String name) {
        return service.getOne(name);
    }
}
