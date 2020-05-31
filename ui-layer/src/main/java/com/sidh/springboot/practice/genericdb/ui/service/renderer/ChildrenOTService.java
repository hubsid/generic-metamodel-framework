package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.ui.service.externalServiceCalls.dblayer.OTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChildrenOTService {
    private SingleOTRenderer singleOTRenderer;
    private OTService otService;

    @Autowired
    public ChildrenOTService(SingleOTRenderer singleOTRenderer, OTService otService) {
        this.singleOTRenderer = singleOTRenderer;
        this.otService = otService;
    }

    public String render(int id) {
        StringBuilder stringBuilder = new StringBuilder();

        otService.getChildrenObjectType(id).stream()
                .map(singleOTRenderer::render)
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }
}
