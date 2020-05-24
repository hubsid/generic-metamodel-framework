package com.sidh.springboot.practice.genericdb.db.service;

import com.sidh.springboot.practice.genericdb.db.entity.Attribute;
import com.sidh.springboot.practice.genericdb.db.entity.ObjectType;
import com.sidh.springboot.practice.genericdb.db.repo.AttributeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeService {
    @Autowired
    private AttributeRepo repo;

    public List<Attribute> getAll() {
        return repo.findAll();
    }

    public Optional<Attribute> getOne(int id) {
        return repo.findById(id);
    }

    public List<ObjectType> getBoundObjectTypes(int id) {
        return repo.getBoundObjectTypes(id);
    }

    public Optional<Attribute> createOne(Attribute attribute) {
        return Optional.ofNullable(repo.save(attribute));
    }

    public List<Attribute> createMany(List<Attribute> attributes) {
        return repo.saveAll(attributes);
    }

    public Optional<Attribute> updateOne(Attribute attribute) {
        return Optional.ofNullable(repo.save(attribute));
    }

    public void deleteOne(int id) {
        repo.deleteById(id);
    }
}
