package com.sidh.springboot.practice.genericdb.ui.models;

import java.util.List;

public class TreeNode<T> {
    private T element;
    private List<TreeNode<T>> children;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }
}
