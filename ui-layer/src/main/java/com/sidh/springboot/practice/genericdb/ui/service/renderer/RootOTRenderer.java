package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.dtos.Constants;
import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import com.sidh.springboot.practice.genericdb.ui.service.externalServiceCalls.dblayer.OTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RootOTRenderer extends SingleOTRenderer {
    @Autowired
    private OTService otService;

    @Override
    public String render() {
        ObjectType objectType = otService.getObjectType(Constants.ROOT_OT_ID);
        return render(objectType);
    }
}
