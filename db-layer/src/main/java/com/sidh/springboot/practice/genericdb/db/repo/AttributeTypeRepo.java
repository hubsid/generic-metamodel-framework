package com.sidh.springboot.practice.genericdb.db.repo;

import com.sidh.springboot.practice.genericdb.dtos.entity.AttributeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeTypeRepo extends JpaRepository<AttributeType, String> {

}
