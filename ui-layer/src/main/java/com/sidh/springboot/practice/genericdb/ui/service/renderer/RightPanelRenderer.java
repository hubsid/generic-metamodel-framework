package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RightPanelRenderer extends MustacheRendererAbstract {
    @Override
    protected void loadContext(HashMap<String, Object> context) {

    }

    @Override
    protected String getTemplateName() {
        return "right-panel";
    }
}
