package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.ui.service.externalServiceCalls.dblayer.OTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RightPanelRenderer extends MustacheRendererAbstract {
    private AttrRenderer attrRenderer;
    private OTService otService;

    private int otId;

    @Autowired
    public RightPanelRenderer(AttrRenderer attrRenderer, OTService otService) {
        this.attrRenderer = attrRenderer;
        this.otService = otService;
    }

    @Override
    protected void loadContext(HashMap<String, Object> context) {
        List<String> renderedAttrs = otService.getBoundAttributes(otId)
                .stream()
                .map(a -> {
                    attrRenderer.setAttr(a);
                    return attrRenderer.render();
                })
                .collect(Collectors.toList());

        context.put("attr-list", renderedAttrs);
    }

    @Override
    protected String getTemplateName() {
        return "right-panel";
    }

    public int getOtId() {
        return otId;
    }

    public void setOtId(int otId) {
        this.otId = otId;
    }
}
