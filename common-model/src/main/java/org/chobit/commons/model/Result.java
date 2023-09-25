package org.chobit.commons.model;

import java.io.Serializable;

import static org.chobit.commons.enums.CommonStatusCode.SUCCESS;

/**
 * 返回结果封装
 *
 * @author robin
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 2163124098042151465L;

    /**
     * 状态码
     */
    private int code = SUCCESS.code;

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

    public boolean isSuccess() {
        return SUCCESS.code == this.code;
    }

    public boolean isFail() {
        return SUCCESS.code != this.code;
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