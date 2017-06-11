package com.scu.demo.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author xing
 * AOP面向切面编程，用于拦截一些请求
 */
@Aspect
@Component
public class HttpAspect {

	//日志打印输出，Logger是spring本身自带的，slf4j提供的接口
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	//将要拦截的url统一起来，后面调用log方法即可，提高代码复用率
	@Pointcut("execution(public * com.scu.demo.controller.GirlController.girlList(..))")
	public void log(){
		
	}
	
	//调用被拦截的方法之前，使用before注解
	@Before("log()")
	public void doBefore(JoinPoint joinPoint){
		
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		//url
		logger.info("url={}", request.getRequestURI());
		
		//method
		logger.info("method={}", request.getMethod());
		
		//ip
		logger.info("ip={}", request.getRemoteAddr());
		
		//类方法
		logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		
		//参数
		logger.info("args={}", joinPoint.getArgs());
		
		logger.info("aop拦截前");
	}
	
	//被拦截方法调用之后
	@After("log()")
	public void doAfter(){
		logger.info("aop拦截后");
	}
	
	//获取调用被拦截的方法的返回值
	@AfterReturning(returning = "object", pointcut = "log()")
	public void doAfterReturning(Object object){
		logger.info("response={}", object.toString());
	}
}
