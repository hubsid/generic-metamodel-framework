package com.sidh.springboot.practice.genericdb.dtos.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class AttributeObjectType {
    @Embeddable
    public static class EmbeddedPK implements Serializable {
        @Column
        private int attributeId;
        @Column
        private int objectTypeId;

        public int getAttributeId() {
            return attributeId;
        }

        public void setAttributeId(int attributeId) {
            this.attributeId = attributeId;
        }

        public int getObjectTypeId() {
            return objectTypeId;
        }

        public void setObjectTypeId(int objectTypeId) {
            this.objectTypeId = objectTypeId;
        }
    }

    public AttributeObjectType() {
    }

    public AttributeObjectType(int attributeId, int objectTypeId) {
        id = new EmbeddedPK();
        id.setAttributeId(attributeId);
        id.setObjectTypeId(objectTypeId);
    }

    @EmbeddedId
    private EmbeddedPK id;

    public EmbeddedPK getId() {
        return id;
    }

    public void setId(EmbeddedPK id) {
        this.id = id;
    }
}
