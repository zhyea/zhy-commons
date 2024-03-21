package org.chobit.commons.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 树节点
 *
 * @author robin
 */
public class TreeNode<T> {


    /**
     * 当前节点的值
     */
    private T value;


    /**
     * 子节点集合
     */
    private final List<TreeNode<T>> children;


    public TreeNode() {
        this.children = new LinkedList<>();
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }
}
