package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.dtos.Constants;
import com.sidh.springboot.practice.genericdb.ui.service.externalServiceCalls.dblayer.OTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RootOTRenderer extends SingleOTRenderer {
    @Autowired
    private OTService otService;

    @Override
    protected void loadContext(HashMap<String, Object> context) {
        super.loadContext(otService.getObjectType(Constants.ROOT_OT_ID), context);
    }
}
