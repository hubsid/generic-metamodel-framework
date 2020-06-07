package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.dtos.entity.Attribute;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AttrRenderer extends MustacheRendererAbstract<Attribute> {
    private Attribute attribute;

    @Override
    public void loadContext(Attribute attribute, HashMap<String, Object> context) {
        this.attribute = attribute;
        loadContext(context);
    }

    @Override
    protected void loadContext(HashMap<String, Object> context) {
        context.put("id", attribute.getId());
        context.put("name", attribute.getName());
        context.put("type", attribute.getAttributeTypeId());
        context.put("desc", attribute.getDescription() == null ? "" : attribute.getDescription());
    }

    @Override
    protected String getTemplateName() {
        return "attr-unit";
    }

    public void setAttr(Attribute attribute) {
        this.attribute = attribute;
    }
}
