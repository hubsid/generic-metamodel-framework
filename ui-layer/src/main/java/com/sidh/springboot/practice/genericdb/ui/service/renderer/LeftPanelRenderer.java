package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class LeftPanelRenderer extends MustacheRendererAbstract<String> {
    @Autowired
    @Qualifier("rootOTRenderer")
    private Renderer otRenderer;

    @Override
    public void loadContext(String obj, HashMap<String, Object> context) {

    }

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
