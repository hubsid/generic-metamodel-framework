package com.sidh.springboot.practice.genericdb.db.service;

import com.sidh.springboot.practice.genericdb.db.entity.AttributeObjectType;
import com.sidh.springboot.practice.genericdb.db.repo.AttributeBindRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeBindService {
    @Autowired
    AttributeBindRepo repo;

    public List<AttributeObjectType> getAllBindings() {
        return repo.findAll();
    }

    public List<AttributeObjectType> getBindingsOfAttribute(int id) {
        return repo.findByIdAttributeId(id);
    }

    public List<AttributeObjectType> getBindingsOfObjectType(int id) {
        return repo.findByIdObjectTypeId(id);
    }

    public AttributeObjectType makeNewBinding(int attributeId, int objectTypeId) {
        return repo.save(new AttributeObjectType(attributeId, objectTypeId));
    }

    public void deleteBinding(int attributeId, int objectTypeId) {
        repo.delete(new AttributeObjectType(attributeId, objectTypeId));
    }
}
