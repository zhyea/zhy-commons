package org.chobit.commons.model;

import static org.chobit.commons.enums.CommonStatusCode.SUCCESS;

/**
 * 返回结果封装
 *
 * @author robin
 */
public class Result<T> {

    /**
     * 状态码
     */
    private int code = SUCCESS.code;

    /**
     * 返回内容
     */
    private T data;

    /**
     * 错误信息
     */
    private String msg;


    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, T data) {
        this.code = code;
        this.data = data;
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

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}