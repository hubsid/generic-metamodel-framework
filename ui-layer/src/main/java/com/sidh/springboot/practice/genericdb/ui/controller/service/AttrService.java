package com.sidh.springboot.practice.genericdb.ui.controller.service;

import com.sidh.springboot.practice.genericdb.dtos.entity.Attribute;
import com.sidh.springboot.practice.genericdb.ui.service.externalServiceCalls.dblayer.OTService;
import com.sidh.springboot.practice.genericdb.ui.service.renderer.AttrRenderer;
import com.sidh.springboot.practice.genericdb.ui.service.renderer.InputRenderer;
import com.sidh.springboot.practice.genericdb.ui.service.renderer.helpers.ListRendererHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttrService {
    private InputRenderer<Attribute> attrRenderer;
    private ListRendererHelper<Attribute> listRendererHelper;
    private OTService otService;

    @Autowired
    public AttrService(AttrRenderer attrRenderer, ListRendererHelper<Attribute> listRendererHelper, OTService otService) {
        this.attrRenderer = attrRenderer;
        this.listRendererHelper = listRendererHelper;
        this.otService = otService;
    }

    public String renderBoundAttrsofOT(int id) {
        return listRendererHelper.render(() -> otService.getBoundAttributes(id), attrRenderer);
    }
}
