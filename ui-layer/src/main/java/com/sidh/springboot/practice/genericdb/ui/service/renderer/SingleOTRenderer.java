package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SingleOTRenderer extends MustacheRendererAbstract<ObjectType> {

    @Override
    protected String getTemplateName() {
        return "ot-unit";
    }

    @Override
    public void loadContext(ObjectType objectType, HashMap<String, Object> context) {
        context.put("ot-id", objectType.getId());
        context.put("name", objectType.getName());
        context.put("children", "");
    }

    @Override
    protected void loadContext(HashMap<String, Object> context) {

    }
}
