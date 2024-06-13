package org.chobit.commons.model.response;

import org.chobit.commons.contract.CodeDescEnum;

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
	private int code;

	/**
	 * 返回内容
	 */
	private T data;

	/**
	 * 错误信息
	 */
	private String msg;


	public Result() {
		this.code = SUCCESS.code;
		this.msg = SUCCESS.msg;
	}

	public Result(int code) {
		this.code = code;
	}

	public Result(T data) {
		this.data = data;
	}

	public Result(int code, T data) {
		this.code = code;
		this.data = data;
	}

	public Result(CodeDescEnum code) {
		this.code = code.getCode();
		this.msg = code.getDesc();
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