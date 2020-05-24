package com.sidh.springboot.practice.genericdb.db.repo;

import com.sidh.springboot.practice.genericdb.db.entity.AttributeObjectType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeBindRepo extends JpaRepository<AttributeObjectType, AttributeObjectType.EmbeddedPK> {
    List<AttributeObjectType> findByIdAttributeId(int id);

    List<AttributeObjectType> findByIdObjectTypeId(int id);
}
