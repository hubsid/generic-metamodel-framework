package com.sidh.springboot.practice.genericdb.db.service;

import com.sidh.springboot.practice.genericdb.db.entity.AttributeType;
import com.sidh.springboot.practice.genericdb.db.repo.AttributeTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeTypeService {
    @Autowired
    private AttributeTypeRepo repo;

    public List<AttributeType> getAllAttributeTypes() {
        return repo.findAll();
    }

    public Optional<AttributeType> getOne(String name) {
        return repo.findById(name);
    }
}
