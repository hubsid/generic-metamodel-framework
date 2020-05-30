package com.sidh.springboot.practice.genericdb.ui.controller;

import com.sidh.springboot.practice.genericdb.ui.service.renderer.HeaderSimpleRenderer;
import com.sidh.springboot.practice.genericdb.ui.service.renderer.LeftPanelRenderer;
import com.sidh.springboot.practice.genericdb.ui.service.renderer.RightPanelRenderer;
import com.sidh.springboot.practice.genericdb.ui.service.renderer.RootCssRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MetamodelEntrypointController {
    private HeaderSimpleRenderer header;
    private RootCssRenderer css;
    private LeftPanelRenderer leftPanel;
    private RightPanelRenderer rightPanel;

    @Autowired
    public MetamodelEntrypointController(HeaderSimpleRenderer header, RootCssRenderer css, LeftPanelRenderer leftPanel, RightPanelRenderer rightPanel) {
        this.header = header;
        this.css = css;
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;
    }

    @GetMapping("/metamodel")
    public String makeMetamodelPage(Model model) {
        model.addAttribute("header", header.render());
        model.addAttribute("left-panel", leftPanel.render());
        model.addAttribute("right-panel", rightPanel.render());
        model.addAttribute("css", css.render());

        return "metaeditor-base";
    }
}
