package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.samskivert.mustache.Mustache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public abstract class MustacheRendererAbstract implements Renderer {
    @Autowired
    private Mustache.Compiler compiler;
    private HashMap<String, Object> context = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(MustacheRendererAbstract.class);

    @Override
    public String render() {
        loadContext(context);
        return Renderer.render(getTemplateName(), compiler, context);
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
