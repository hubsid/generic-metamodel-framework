package com.sidh.springboot.practice.genericdb.db.repo;

import com.sidh.springboot.practice.genericdb.db.entity.Attribute;
import com.sidh.springboot.practice.genericdb.db.entity.ObjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttributeRepo extends JpaRepository<Attribute, Integer> {

    @Query("select ot from Attribute a" +
            " join AttributeObjectType aot on aot.id.attributeId = a.id" +
            " join ObjectType ot on ot.id = aot.id.objectTypeId" +
            " where a.id = ?1")
    List<ObjectType> getBoundObjectTypes(int id);
}
