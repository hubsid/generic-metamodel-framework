package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import com.sidh.springboot.practice.genericdb.dtos.models.TreeNode;
import com.sidh.springboot.practice.genericdb.ui.service.externalServiceCalls.dblayer.OTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.stream.Collectors;

@Component
public class FullOTTreeRenderer extends MustacheRendererAbstract<ObjectType> {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    OTService otService;
    private static final Logger logger = LoggerFactory.getLogger(FullOTTreeRenderer.class);

    @Override
    public String render() {
        TreeNode<ObjectType> rootNode = otService.getObjectTypeTree(0);
        return renderTree(rootNode);
    }

    @Override
    public void loadContext(ObjectType obj, HashMap<String, Object> context) {

    }

    private String renderTree(TreeNode<ObjectType> rootNode) {
        HashMap<String, Object> context = new HashMap<>();
        context.put("ot-id", rootNode.getElement().getId());
        context.put("name", rootNode.getElement().getName());

        String childRendering = rootNode.getChildren().stream()
                .map(this::renderTree).collect(Collectors.joining("\n"));
        context.put("children", childRendering);

        return Renderer.render(getTemplateName(), getCompiler(), context);
    }

    @Override
    protected void loadContext(HashMap<String, Object> context) {
    }

    @Override
    protected String getTemplateName() {
        return "object-type-unit";
    }
}
