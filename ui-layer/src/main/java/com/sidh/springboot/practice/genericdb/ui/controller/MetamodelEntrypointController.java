package com.sidh.springboot.practice.genericdb.ui.controller;

import com.sidh.springboot.practice.genericdb.ui.service.renderer.HeaderSimpleRenderer;
import com.sidh.springboot.practice.genericdb.ui.service.renderer.RootCssRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MetamodelEntrypointController {
    private HeaderSimpleRenderer header;
    private RootCssRenderer css;

    @Autowired
    public MetamodelEntrypointController(HeaderSimpleRenderer header, RootCssRenderer css) {
        this.header = header;
        this.css = css;
    }

    @GetMapping("/metamodel")
    public String makeMetamodelPage(Model model) {
        model.addAttribute("header", header.render());
        model.addAttribute("left-panel", "left-panel value");
        model.addAttribute("right-panel", "right-;anel value");
        model.addAttribute("css", css.render());

        return "metaeditor-base";
    }
}
