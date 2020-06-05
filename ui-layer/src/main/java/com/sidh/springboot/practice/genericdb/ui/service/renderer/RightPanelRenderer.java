package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.dtos.entity.Attribute;
import com.sidh.springboot.practice.genericdb.ui.service.externalServiceCalls.dblayer.OTService;
import com.sidh.springboot.practice.genericdb.ui.service.renderer.helpers.ListRendererHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RightPanelRenderer extends MustacheRendererAbstract<Attribute> {
    private ListRendererHelper<Attribute> listRendererHelper;
    private InputRenderer<Attribute> attrRenderer;
    private OTService otService;

    private int otId;

    @Autowired
    public RightPanelRenderer(ListRendererHelper<Attribute> listRendererHelper,
                              @Qualifier("attrRenderer") AttrRenderer attrRenderer,
                              OTService otService) {
        this.listRendererHelper = listRendererHelper;
        this.attrRenderer = attrRenderer;
        this.otService = otService;
    }

    @Override
    public void loadContext(Attribute attribute, HashMap<String, Object> context) {

    }

    @Override
    protected void loadContext(HashMap<String, Object> context) {
        String renderedAttrs = listRendererHelper.render(() -> otService.getBoundAttributes(0), attrRenderer);
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
