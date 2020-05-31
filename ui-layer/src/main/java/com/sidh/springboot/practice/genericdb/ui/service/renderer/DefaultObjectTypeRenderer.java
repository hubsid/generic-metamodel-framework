package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import com.sidh.springboot.practice.genericdb.ui.models.TreeNode;
import com.sidh.springboot.practice.genericdb.ui.service.externalServiceCalls.dblayer.OTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultObjectTypeRenderer extends MustacheRendererAbstract {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    OTService otService;
    private static final Logger logger = LoggerFactory.getLogger(DefaultObjectTypeRenderer.class);

    @Override
    public String render() {
        TreeNode<ObjectType> rootNode = constructTree(otService.getObjectType(0));

        return renderTree(rootNode);
    }

    private String renderTree(TreeNode<ObjectType> rootNode) {
        HashMap<String, Object> context = new HashMap<>();
        context.put("name", rootNode.getElement().getName());

        String childRendering = rootNode.getChildren().stream()
                .map(this::renderTree).collect(Collectors.joining("\n"));
        context.put("children", childRendering);

        return genericRender(getTemplateName(), context);
    }

    @Override
    protected void loadContext(HashMap<String, Object> context) {
    }

    private TreeNode<ObjectType> constructTree(ObjectType objectType) {
        logger.info("parent ot:{}", objectType);
        TreeNode<ObjectType> node = new TreeNode<>();
        if (objectType != null) {
            node.setElement(objectType);

            List<ObjectType> childrenObjectType = otService.getChildrenObjectType(objectType.getId());
            logger.info("children ot size:{}, ots:{}", childrenObjectType.size(), childrenObjectType);

            node.setChildren(
                    childrenObjectType.stream()
                            .map(this::constructTree)
                            .collect(Collectors.toList())
            );
            /*List<TreeNode<ObjectType>> nodes = new LinkedList<>();
            for (Object child : childrenObjectType) {
                System.out.println("class of child:" + child.getClass());
                ObjectType castchild = (ObjectType) child;
                nodes.add(constructTree(castchild));
            }*/
        }
        return node;
    }

    @Override
    protected String getTemplateName() {
        return "object-type-unit";
    }
}
