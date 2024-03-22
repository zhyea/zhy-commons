package org.chobit.commons.model;

/**
 * 引用信息包装类
 * <p>
 * 用于处理直接类型或字符串，以解决直接类型或字符串被修改后引用丢失的问题
 *
 * @author robin
 */
public class Reference<T> {


    /**
     * 被包装的值
     */
    private T value;


    public Reference() {

    }

    public Reference(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
