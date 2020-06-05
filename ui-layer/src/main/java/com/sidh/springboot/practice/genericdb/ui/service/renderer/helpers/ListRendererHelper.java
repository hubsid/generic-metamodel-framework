package com.sidh.springboot.practice.genericdb.ui.service.renderer.helpers;

import com.sidh.springboot.practice.genericdb.ui.service.renderer.InputRenderer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

@Component
public class ListRendererHelper<T> {

    public String render(Supplier<List<T>> supplier, InputRenderer<T> inputRenderer) {
        return supplier.get()
                .stream()
                .map(inputRenderer::render)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
