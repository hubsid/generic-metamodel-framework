package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Component
public class RootCssRenderer extends MustacheRendererAbstract {
    @PostConstruct
    public void print() {
        System.out.println("css-compiler:" + getCompiler());
    }

    @Override
    protected void loadContext(HashMap<String, Object> context) {

    }

    @Override
    protected String getTemplateName() {
        return "root-css";
    }
}
