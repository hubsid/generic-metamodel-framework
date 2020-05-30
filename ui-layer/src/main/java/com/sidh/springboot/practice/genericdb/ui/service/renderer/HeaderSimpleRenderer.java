package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
public class HeaderSimpleRenderer extends MustacheRendererAbstract {
    @Value("${metamodel.header.title}")
    private String title;
    @Value("${metamodel.header.subtitle}")
    private String subtitle;

    @PostConstruct
    public void print() {
        System.out.println("header-title:" + title);
        System.out.println("header-subtitle:" + subtitle);
        System.out.println("header-compiler:" + getCompiler());
    }

    @Override
    protected void loadContext(HashMap<String, Object> context) {
        context.put("title", title);
        context.put("subtitle", subtitle);
    }

    @Override
    protected String getTemplateName() {
        return "metaeditor-header";
    }
}
