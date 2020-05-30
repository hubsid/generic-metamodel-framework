package com.sidh.springboot.practice.genericdb.db.controller;

import com.sidh.springboot.practice.genericdb.db.service.AttributeBindService;
import com.sidh.springboot.practice.genericdb.dtos.entity.AttributeObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attributeBind")
public class AttributeBindController {
    @Autowired
    private AttributeBindService service;

    //getallbindings
    @GetMapping("")
    public List<AttributeObjectType> allEndpoint() {
        return service.getAllBindings();
    }

    //getbindingsbyattr
    @GetMapping("/attribute/{id}")
    public List<AttributeObjectType> getByAttrEndpoint(@PathVariable int id) {
        return service.getBindingsOfAttribute(id);
    }

    //getbindingsbyot
    @GetMapping("/objectType/{id}")
    public List<AttributeObjectType> getByObjectTypeEndpoint(@PathVariable int id) {
        return service.getBindingsOfObjectType(id);
    }

    //addnewbinding
    @PostMapping("/{attributeId}/{objectTypeId}")
    public AttributeObjectType newBindingEndpoint(@PathVariable int attributeId, @PathVariable int objectTypeId) {
        return service.makeNewBinding(attributeId, objectTypeId);
    }

    //remove a binding
    @DeleteMapping("/{attributeId}/{objectTypeId}")
    public void removeBindingEndpoint(@PathVariable int attributeId, @PathVariable int objectTypeId) {
        service.deleteBinding(attributeId, objectTypeId);
    }
}
