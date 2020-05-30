package com.sidh.springboot.practice.genericdb.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MetamodelEntrypointController {

    @GetMapping("/metamodel")
    public String makeMetamodelPage(Model model) {
        model.addAttribute("header", "header-value");
        model.addAttribute("left-panel", "left-panel value");
        model.addAttribute("right-panel", "right-;anel value");
        model.addAttribute("css", "css value");

        return "metaeditor-base";
    }
}
