package com.sidh.springboot.practice.genericdb.db.init;

import com.sidh.springboot.practice.genericdb.db.repo.AttributeBindRepo;
import com.sidh.springboot.practice.genericdb.db.repo.AttributeRepo;
import com.sidh.springboot.practice.genericdb.db.repo.AttributeTypeRepo;
import com.sidh.springboot.practice.genericdb.db.repo.ObjectTypeRepo;
import com.sidh.springboot.practice.genericdb.dtos.entity.Attribute;
import com.sidh.springboot.practice.genericdb.dtos.entity.AttributeObjectType;
import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@Profile("ddlcreate")
public class SampleDataInsertor {
    @Autowired
    private AttributeTypeRepo attributeTypeRepo;
    @Autowired
    private AttributeRepo attributeRepo;
    @Autowired
    private ObjectTypeRepo objectTypeRepo;
    @Autowired
    private AttributeBindRepo attributeBindRepo;

    @Value("${sampleData.otPrefix}")
    private String otPrefix;
    @Value("${sampleData.attrPrefix}")
    private String attrPrefix;
    @Value("${sampleData.attrCount}")
    private int attrCount;
    @Value("${sampleData.otBranchCount}")
    private int otBranchCount;
    @Value("${sampleData.maxlevel}")
    private int maxlevel;
    @Value("${sampleData.rootObjectTypeName}")
    private String rootObjectTypeName;
    @Value("${sampleData.defaultAttributeType}")
    private String defaultAttributeType;
    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        if (Arrays.stream(environment.getActiveProfiles()).anyMatch(p -> p.equals("ddlcreate"))) {
            ObjectType rootObjectType = objectTypeRepo.findById(0).get();
            insertRecursive(0, "0", rootObjectType);
        }
    }

    private void insertRecursive(int level, String levelName, ObjectType parentObjectType) {
        //persist parent ot
        for(int i = 0; i < attrCount; i++) {
            String attrName = attrPrefix + levelName + "." + i;
            Attribute attribute = new Attribute(attrName);
            attribute.setAttributeTypeId(defaultAttributeType);
            attributeRepo.save(attribute);
            
            AttributeObjectType attributeObjectType = new AttributeObjectType(attribute.getId(), parentObjectType.getId());
            attributeBindRepo.save(attributeObjectType);
        }
        
        //for loop create child ots, link parent ot to each, save child ots, call recursive
        if(level < maxlevel) {
            for(int i = 0; i < otBranchCount; i++) {
                String otName = otPrefix + levelName + "." + i;
                ObjectType childOt = new ObjectType(otName);
                childOt.setParentId(parentObjectType.getId());
                objectTypeRepo.save(childOt);

                insertRecursive(level + 1, levelName + "." + i, childOt);
            }
        }
    }
}
