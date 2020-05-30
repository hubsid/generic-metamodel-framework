package com.sidh.springboot.practice.genericdb.ui.service.renderer;

import com.sidh.springboot.practice.genericdb.dtos.entity.ObjectType;
import com.sidh.springboot.practice.genericdb.ui.models.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultObjectTypeRenderer extends MustacheRendererAbstract {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String render() {
        TreeNode<ObjectType> rootNode = constructTree(getObjectType(0));

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
        TreeNode<ObjectType> node = new TreeNode<>();
        if (objectType != null) {
            node.setElement(objectType);

            List<ObjectType> childrenObjectType = getChildrenObjectType(objectType.getId());

           /* node.setChildren(
                    childrenObjectType.stream()
                            .map(this::constructTree)
                            .collect(Collectors.toList())
            );*/
            List<TreeNode<ObjectType>> nodes = new LinkedList<>();
            for (Object child : childrenObjectType) {
                System.out.println("class of child:" + child.getClass());
                ObjectType castchild = (ObjectType) child;
                nodes.add(constructTree(castchild));
            }
        }
        return node;
    }

    private List<ObjectType> getChildrenObjectType(int id) {
        String address = "http://localhost:7000/objectType/%s/children";
        ResponseEntity<List> response = restTemplate.getForEntity(String.format(address, id), List.class);
        if (response.getStatusCode().is2xxSuccessful())
            return response.getBody();
        return Collections.emptyList();
    }

    private ObjectType getObjectType(int id) {
        String address = "http://localhost:7000/objectType/%s";
        ResponseEntity<ObjectType> response = restTemplate.getForEntity(String.format(address, id), ObjectType.class);
        if (response.getStatusCode().is2xxSuccessful())
            return response.getBody();
        return null;
    }

    @Override
    protected String getTemplateName() {
        return "object-type-unit";
    }
}
