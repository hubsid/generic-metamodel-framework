package com.sidh.springboot.practice.genericdb.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AttributeType {
    @Id
    private String name;

    @Column
    private String description;

    public AttributeType(String name) {
        this.name = name;
    }

    public AttributeType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public AttributeType() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AttributeType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
