package com.scu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scu.demo.bean.GirlBean;

/**
 * @author xing
 * 用于测试application.yml这张表里面定义的一些数据
 * application.yml这个文件是springboot的资源文件，采用键值对的方式定义相关数据，数据库端口等等。
 */
@RestController
public class HelloController {

	//通过@value的方式获取yml文件里面的数据
//	@Value("${cupSize}")
//	private String cupSize;
//	
//	@Value("${age}")
//	private Integer age;
//	
//	@Value("${content}")
//	private String content;
	
	@Autowired
	private GirlBean girlBean;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(){
		
//		return cupSize+" : "+age+" : "+content;
		return girlBean.getName()+" : "+girlBean.getAges();
	}
}
