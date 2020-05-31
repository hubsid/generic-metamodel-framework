package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class LeftPanelRenderer extends MustacheRendererAbstract {
    @Autowired
    private FullOTTreeRenderer otRenderer;

    @Override
    protected void loadContext(HashMap<String, Object> context) {
        context.put("header", "some header value");
        context.put("content", otRenderer.render());
    }

    @Override
    protected String getTemplateName() {
        return "left-panel";
    }
}
