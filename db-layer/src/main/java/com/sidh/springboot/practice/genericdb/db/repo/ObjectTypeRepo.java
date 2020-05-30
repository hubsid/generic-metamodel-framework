package com.sidh.springboot.practice.genericdb.db.repo;

import com.sidh.springboot.practice.genericdb.dtos.entity.Attribute;
import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjectTypeRepo extends JpaRepository<ObjectType, Integer> {

    @Query("select a from ObjectType ot" +
            " join AttributeObjectType aot on aot.id.objectTypeId = ot.id" +
            " join Attribute a on a.id = aot.id.attributeId" +
            " where ot.id = ?1")
    List<Attribute> getBoundAttributes(int id);
}
