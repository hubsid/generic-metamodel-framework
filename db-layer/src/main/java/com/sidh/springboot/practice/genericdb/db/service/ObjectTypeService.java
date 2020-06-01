package com.sidh.springboot.practice.genericdb.db.service;

import com.sidh.springboot.practice.genericdb.db.repo.ObjectTypeRepo;
import com.sidh.springboot.practice.genericdb.dtos.Constants;
import com.sidh.springboot.practice.genericdb.dtos.entity.Attribute;
import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import com.sidh.springboot.practice.genericdb.dtos.models.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObjectTypeService {

    @Autowired
    private ObjectTypeRepo repo;

    public List<ObjectType> getAll() {
        return repo.findAll();
    }

    public Optional<ObjectType> getOne(int id) {
        return repo.findById(id);
    }

    public List<Attribute> getBoundAttributes(int id) {
        return repo.getBoundAttributes(id);
    }

    public List<ObjectType> getChildren(int id) {
        return getAll().stream()
                .filter(o -> o.getParentId() == id)
                .filter(o -> o.getId() != Constants.ROOT_OT_ID)
                .collect(Collectors.toList());
    }

    public TreeNode<ObjectType> getChildrenTree(int id) {
        TreeNode<ObjectType> node = new TreeNode<>();
        Optional<ObjectType> parent = getOne(id);
        if (parent.isPresent()) {
            ObjectType parentObj = parent.get();
            node.setElement(parentObj);

            List<ObjectType> children = getChildren(id);
            node.setChildren(
                    children.stream()
                            .map(ObjectType::getId)
                            .map(this::getChildrenTree)
                            .collect(Collectors.toList())
            );
        }
        return node;
    }

    public List<Attribute> getInheritedAttributes(int id) {
        List<Attribute> attributes = new LinkedList<>(getBoundAttributes(id));
        while (id != Constants.ROOT_OT_ID) {
            id = getParent(id).map(ObjectType::getId).orElse(Constants.ROOT_OT_ID);
            attributes.addAll(getBoundAttributes(id));
        }

        return attributes;
    }

    public ObjectType createOne(ObjectType objectType) {
        return repo.save(objectType);
    }

    public List<ObjectType> createMany(List<ObjectType> objectTypes) {
        return repo.saveAll(objectTypes);
    }

    public void deleteOne(int id) {
        repo.deleteById(id);
    }

    public Optional<ObjectType> getParent(int id) {
        Optional<ObjectType> objectType = getOne(id);
        if(objectType.isPresent())
                return getOne(objectType.get().getParentId());

        return Optional.empty();
    }
}
