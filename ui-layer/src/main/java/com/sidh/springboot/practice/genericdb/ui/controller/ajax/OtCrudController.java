package com.sidh.springboot.practice.genericdb.ui.controller.ajax;

import com.sidh.springboot.practice.genericdb.ui.service.externalServiceCalls.dblayer.OTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otCrud")
public class OtCrudController {
    @Autowired
    private OTService otService;

    @GetMapping("/create/{parentOtId}/{childOtName}")
    public void createChildOt(@PathVariable int parentOtId, @PathVariable String childOtName) {
        otService.createOT(parentOtId, childOtName);
    }
}
