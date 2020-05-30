package com.sidh.springboot.practice.genericdb.db.controller;

import com.sidh.springboot.practice.genericdb.db.service.AttributeService;
import com.sidh.springboot.practice.genericdb.dtos.entity.Attribute;
import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attribute")
public class AttributeController {
    @Autowired
    private AttributeService service;

    @GetMapping("")
    public List<Attribute> allEndpoint() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Attribute> oneEndpoint(@PathVariable int id) {
        return service.getOne(id);
    }

    @GetMapping("/{id}/objectType")
    public List<ObjectType> boundObjectTypesEndpoint(@PathVariable int id) {
        return service.getBoundObjectTypes(id);
    }

    @PostMapping("/")
    public Optional<Attribute> createOneEndpoint(@RequestBody Attribute attribute) {
        return service.createOne(attribute);
    }

    @PostMapping("/many")
    public List<Attribute> createManyEndpoint(@RequestBody List<Attribute> attributes) {
        return service.createMany(attributes);
    }

    @PutMapping("")
    public Optional<Attribute> updateOne(@RequestBody Attribute attribute) {
        return service.updateOne(attribute);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable int id) {
        service.deleteOne(id);
    }
}
