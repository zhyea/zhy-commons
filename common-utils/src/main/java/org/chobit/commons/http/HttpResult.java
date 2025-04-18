package org.chobit.commons.http;

import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * Http请求结果封装
 *
 * @author robin
 */
public class HttpResult implements Serializable {

	private static final long serialVersionUID = 4535394251892023202L;


	/**
	 * http响应状态码
	 */
	private int code = -1;

	private String content = "";

	private String errMsg = "";


	public HttpResult() {
	}

	public HttpResult(int code, String content) {
		this.code = code;
		this.content = content;
	}

	public boolean isSuccess() {
		return code == HttpStatus.SC_OK;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		return "HttpResult{" +
				"code=" + code +
				", content='" + content + '\'' +
				", errMsg='" + errMsg + '\'' +
				'}';
	}
}
