package com.scu.demo.bean;

/**
 * @author xing
 * @param <T>
 * 把结果集封装成json的实体
 */
public class Result<T> {

	private Integer code;  //错误码
	
	private String message;  //提示信息
	
	private T data; //需要返回的具体内容

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
