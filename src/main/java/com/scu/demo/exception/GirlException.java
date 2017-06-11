package com.scu.demo.exception;

import com.scu.demo.enums.ResultEnum;

/**
 * @author xing
 * 封装异常的相关错误信息的实体
 */
public class GirlException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
	public GirlException(ResultEnum resultEnum){
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
