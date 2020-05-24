package com.sidh.springboot.practice.genericdb.db.entity;

import javax.persistence.*;

@Entity
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String attributeTypeId;

    public Attribute() {
    }

    public Attribute(String name) {
        this.name = name;
    }

    public Attribute(int id, String name, String description, String attributeTypeId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.attributeTypeId = attributeTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(String attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", attributeTypeId='" + attributeTypeId + '\'' +
                '}';
    }
}
