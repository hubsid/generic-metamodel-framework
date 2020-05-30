package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public abstract class MustacheRendererAbstract implements Renderer {
    @Autowired
    private Mustache.Compiler compiler;
    private HashMap<String, Object> context = new HashMap<>();

    public String genericRender(String templateName, HashMap<String, Object> context) {
        Template template = compiler.loadTemplate(templateName);
        return template.execute(context);
    }

    @Override
    public String render() {
        loadContext(context);
        return genericRender(getTemplateName(), context);
    }

    protected abstract void loadContext(HashMap<String, Object> context);

    protected abstract String getTemplateName();

    public HashMap<String, Object> getContext() {
        return context;
    }

    public void setContext(HashMap<String, Object> context) {
        this.context = context;
    }

    public Mustache.Compiler getCompiler() {
        return compiler;
    }

    public void setCompiler(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }
}
