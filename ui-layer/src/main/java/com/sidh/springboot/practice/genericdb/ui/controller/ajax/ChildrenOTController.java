package com.sidh.springboot.practice.genericdb.ui.controller.ajax;

import com.sidh.springboot.practice.genericdb.ui.service.renderer.ChildrenOTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildrenOTController {

    @Autowired
    private ChildrenOTService childrenOTService;

    @GetMapping("/ot/{id}/children")
    public String getChildren(@PathVariable int id) {
        return childrenOTService.render(id);
    }
}
