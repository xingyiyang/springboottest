package com.scu.demo.enums;

/**
* @author xyy
* 2017年6月8日 下午10:05:02
* 用枚举定义异常的code和message
*/
public enum ResultEnum {

	//4种异常信息
	UNKOWN_ERROR(-1,"未知错误"),
	SUCCESS(0,"成功"),
	PRIMARY(2,"上小学"),
	MIDDLE(3,"上初中"),
	;
	
	private Integer code;
	private String msg;
	
	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
}
