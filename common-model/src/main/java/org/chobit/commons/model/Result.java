package org.chobit.commons.model;

/**
 * @author robin
 */

public class Result<T> {
    /**
     * 状态码
     */
    private int code = 0;

    /**
     * 返回内容
     */
    private T content;

    /**
     * 错误信息
     */
    private String msg;


    public Result() {
    }

    public Result(T content) {
        this.content = content;
    }

    public Result(int code, T content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}