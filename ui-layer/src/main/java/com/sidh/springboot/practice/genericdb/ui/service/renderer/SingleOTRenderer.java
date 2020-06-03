package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SingleOTRenderer extends MustacheRendererAbstract implements InputRenderer<ObjectType> {

    @Override
    public String render() {
        return null;
    }

    @Override
    protected void loadContext(HashMap<String, Object> context) {

    }

    @Override
    protected String getTemplateName() {
        return "ot-unit";
    }

    @Override
    public String render(ObjectType objectType) {
        HashMap<String, Object> context = new HashMap<>();
        context.put("ot-id", objectType.getId());
        context.put("name", objectType.getName());
        context.put("children", "");
        return Renderer.render(getTemplateName(), getCompiler(), context);
    }
}
