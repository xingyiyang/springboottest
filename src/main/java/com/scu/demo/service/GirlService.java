package com.scu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scu.demo.dao.GirlRepository;
import com.scu.demo.domain.Girl;
import com.scu.demo.enums.ResultEnum;
import com.scu.demo.exception.GirlException;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void addTwo(){
		
	}
	
	/**
	 * @param id
	 * @throws Exception
	 * 通过id查询age
	 */
	public void getAge(Integer id) throws Exception{
		
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if(age<10){
			throw new GirlException(ResultEnum.PRIMARY);
		}else if(age>10 && age<16){
			throw new GirlException(ResultEnum.MIDDLE);
		}else{
			
		}
	}
	
	/**
	 * @param id
	 * @return
	 * 通过id查询一个girl
	 */
	public Girl findOne(Integer id){
		
		return girlRepository.findOne(id);
	}
	
	/**
	 * @return
	 * 查询所有girl列表
	 */
	public List<Girl> findAll(){
		
		return girlRepository.findAll();
	}
	
	/**
	 * @param girl
	 * @return
	 * 添加一个girl
	 */
	public Girl save(Girl girl){
		
		return girlRepository.save(girl);
	}
	
	/**
	 * @param id
	 * 通过id删除一个ffirl
	 */
	public void delete(Integer id){
		
		girlRepository.delete(id);
	}
	
	/**
	 * @param username
	 * @return
	 * 通过username查询girl
	 */
	public List<Girl> findByUsername(String username){
		
		return girlRepository.findByUsername(username);
	}
}
