package com.sidh.springboot.practice.genericdb.db.controller;

import com.sidh.springboot.practice.genericdb.db.entity.Attribute;
import com.sidh.springboot.practice.genericdb.db.entity.ObjectType;
import com.sidh.springboot.practice.genericdb.db.service.ObjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/objectType")
public class ObjectTypeController {
    @Autowired
    private ObjectTypeService service;

    @GetMapping("")
    public List<ObjectType> getAllEndpoint() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ObjectType> idEndpoint(@PathVariable int id) {
        return service.getOne(id);
    }

    @GetMapping("/{id}/parent")
    public Optional<ObjectType> parentEndpoint(@PathVariable int id) {
        return service.getParent(id);
    }

    @GetMapping("/{id}/children")
    public List<ObjectType> childrenEndpoint(@PathVariable int id) {
        return service.getChildren(id);
    }

    @GetMapping("/{id}/attribute")
    public List<Attribute> boundAttributesEndpoint(@PathVariable int id) {
        return service.getBoundAttributes(id);
    }

    @GetMapping("/{id}/attributesInherited")
    public List<Attribute> inheritedAttributesEndpoint(@PathVariable int id) {
        return service.getInheritedAttributes(id);
    }

    @PostMapping("")
    public ObjectType singleCreationEndpoint(@RequestBody ObjectType objectType) {
        return service.createOne(objectType);
    }

    @PostMapping("/many")
    public List<ObjectType> manyCreationEndpoint(@RequestBody List<ObjectType> objectTypes) {
        return service.createMany(objectTypes);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable int id) {
        service.deleteOne(id);
    }
}
