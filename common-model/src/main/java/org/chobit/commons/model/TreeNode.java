package org.chobit.commons.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
     * 上级节点的引用
     */
    private TreeNode<T> parent;


    /**
     * 子节点集合
     */
    private final List<TreeNode<T>> children;


    public TreeNode() {
        this.children = new LinkedList<>();
    }


    public TreeNode(T value) {
        this();
        this.value = value;
    }


    public TreeNode(TreeNode<T> parent, T value) {
        this(value);
        this.parent = parent;
    }


    /**
     * 新增子节点
     *
     * @param value 子节点的值
     */
    public void addChild(T value) {
        this.children.add(new TreeNode<>(value));
    }


    /**
     * 新增子节点
     *
     * @param child 子节点
     */
    public void addChild(TreeNode<T> child) {
        this.children.add(child);
    }


    /**
     * 判断子节点长度
     *
     * @return 子节点数量
     */
    public int childrenNum() {
        return this.children.size();
    }


    /**
     * 获取parent node的引用
     * <p>
     * 不用getParent()这样的命名是为了避免在序列化处理时出现死循环
     *
     * @return parent节点的引用
     */
    public TreeNode<T> parent() {
        return parent;
    }


    public T getValue() {
        return value;
    }


    public void setValue(T value) {
        this.value = value;
    }


    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }


    public List<TreeNode<T>> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(value, treeNode.value)
                && Objects.equals(parent, treeNode.parent)
                && Objects.equals(children, treeNode.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, parent, children);
    }


    @Override
    public String toString() {
        return "TreeNode{value=" + value + '}';
    }
}
