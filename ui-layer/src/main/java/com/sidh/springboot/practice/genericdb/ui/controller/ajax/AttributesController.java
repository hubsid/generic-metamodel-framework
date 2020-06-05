package com.sidh.springboot.practice.genericdb.ui.controller.ajax;

import com.sidh.springboot.practice.genericdb.ui.controller.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttributesController {

    private AttrService attrservice;

    @Autowired
    public AttributesController(AttrService attrservice) {
        this.attrservice = attrservice;
    }

    @GetMapping("/ot/{id}/attributes")
    public String getBoundAttributes(@PathVariable int id) {
        return attrservice.renderBoundAttrsofOT(id);
    }
}
