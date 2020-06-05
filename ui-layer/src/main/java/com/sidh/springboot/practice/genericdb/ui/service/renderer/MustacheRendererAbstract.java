package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.samskivert.mustache.Mustache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public abstract class MustacheRendererAbstract<T> implements Renderer, InputRenderer<T> {
    @Autowired
    private Mustache.Compiler compiler;
    private HashMap<String, Object> context = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(MustacheRendererAbstract.class);

    @Override
    public String render() {
        loadContext(context);
        logger.debug("mustache-context=" + context);
        return Renderer.render(getTemplateName(), compiler, context);
    }

    @Override
    public String render(T obj) {
        loadContext(obj, context);
        logger.debug("mustache-context=" + context);
        return Renderer.render(getTemplateName(), compiler, context);
    }

    public abstract void loadContext(T obj, HashMap<String, Object> context);

    protected abstract void loadContext(HashMap<String, Object> context);

    protected abstract String getTemplateName();

    public Mustache.Compiler getCompiler() {
        return compiler;
    }
}
