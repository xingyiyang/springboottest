package com.scu.demo.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scu.demo.bean.Result;
import com.scu.demo.exception.GirlException;
import com.scu.demo.utils.ResultUtil;

/**
 * @author xing
 * 处理异常的方法
 */
@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e){
		
		if(e instanceof GirlException){
			GirlException girlException = (GirlException) e;
			return ResultUtil.Error(girlException.getCode(), girlException.getMessage());
		}else{
			logger.info("系统异常={}",e);
			return ResultUtil.Error(-1,"未知错误");
		}	
	}
}
