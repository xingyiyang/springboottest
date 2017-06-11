package com.scu.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scu.demo.bean.Result;
import com.scu.demo.dao.GirlRepository;
import com.scu.demo.domain.Girl;
import com.scu.demo.service.GirlService;
import com.scu.demo.utils.ResultUtil;

/**
 * @author xing
 * 用于与前端交互，对girl这张表的操作
 * restController是controller和ResponseBody的结合
 */
@RestController
public class GirlController {

	//打印日志
	private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
	
	@Autowired
	private GirlService girlService;
	
	/**
	 * @return List<Girl>
	 * GetMapping是mthod为get的请求
	 * 查询所有的girl列表
	 * 用于测试aop切面编程
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList(){
		
		return girlService.findAll();
	}
	
	/**
	 * @return girl
	 * 添加一个girl
	 * @valid用于表单验证，验证信息在domain中，如果有错误信息则封装在bingdingResult里面
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/addgirl")
	public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
		
		Result<Girl> result = new Result<Girl>();
		
		if(bindingResult.hasErrors()){
			return ResultUtil.Error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		
		girl.setUsername(girl.getUsername());
	    girl.setAge(girl.getAge());
	    
		return ResultUtil.success(girlService.save(girl));
		
	}
	
	/**
	 * @param id
	 * @return girl
	 * 通过id查询girl
	 */
	@GetMapping(value="/girl/{id}")
	public Girl getGirlById(
			@PathVariable("id") Integer id){
		
		return girlService.findOne(id);
	}
	
	/**
	 * @param id
	 * @param username
	 * @param password
	 * @return
	 * 通过id更新girl
	 */
	@PutMapping(value = "/updategirl/{id}")
	public Girl updateGirl(
			@PathVariable("id") Integer id,
			@RequestParam("username") String username,
			@RequestParam("age") Integer age){
		
		Girl girl = new Girl();
		girl.setId(id);
		girl.setUsername(username);
		girl.setAge(age);
		
		return girlService.save(girl);
	}
	
	/**
	 * @param id
	 * 通过id删除girl
	 */
	@DeleteMapping(value = "/deletegirl/{id}")
	public void deleteGirl(
			@PathVariable("id") Integer id){
		
		girlService.delete(id);
	}
	
	/**
	 * @param username
	 * @return
	 * 通过username查询girl
	 * 这里用于测试自定义的查询数据库的方法，方法名需要按照hibernate定义的查询数据库的方法格式
	 */
	@GetMapping(value = "/girlname/{username}")
	public List<Girl> findGirlByName(
			@PathVariable("username") String username){
		
		return girlService.findByUsername(username);
	}
	
	/**
	 * @param id
	 * @throws Exception
	 * 通过id查询girl的age，这里用于测试异常的处理
	 */
	@GetMapping(value = "girl/getage/{id}")
	public void getAge(
			@PathVariable("id") Integer id) throws Exception{
		
		girlService.getAge(id);
	}
	
}
