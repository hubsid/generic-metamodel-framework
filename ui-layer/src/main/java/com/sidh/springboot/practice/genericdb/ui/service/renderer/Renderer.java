package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.util.HashMap;

public interface Renderer {
    String render();

    static String render(Template template, HashMap<String, Object> context) {
        return template.execute(context);
    }

    static String render(String templateName, Mustache.Compiler compiler, HashMap<String, Object> context) {
        Template template = compiler.loadTemplate(templateName);
        return render(template, context);
    }
}
