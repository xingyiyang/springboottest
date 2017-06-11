package com.scu.demo.utils;

import com.scu.demo.bean.Result;

/**
 * @author xing
 * 封把结果集封装成json的工具
 */
public class ResultUtil {

	/**
	 * @param object
	 * @return
	 * 成功时调用的方法
	 */
	public static Result success(Object object){
		
		Result result = new Result();
		result.setCode(0);
		result.setMessage("成功");
		result.setData(object);
		return result;
				
	}
	
	/**
	 * @return
	 * 没有数据时返回null
	 */
	public static Result success() {
		return success(null);
	}
	
	/**
	 * @param code
	 * @param message
	 * @return
	 * 失败时调用的方法
	 */
	public static Result Error(Integer code, String message){
		
		Result result = new Result();
		result.setCode(code);
		result.setMessage(message);
		return result;
	}
}
