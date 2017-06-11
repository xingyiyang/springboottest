package com.scu.demo.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.scu.demo.domain.Girl;

/**
* @author xyy
* 2017年6月8日 下午10:26:01
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

	@Autowired
	private GirlService girlService;
	
	@Test
	public void findOneTest(){
		Girl girl = girlService.findOne(9);
		Assert.assertEquals(girl.getAge(), new Integer(12));
	}
	
	@Test
	public void deleteTest(){
		girlService.delete(9);
	}
	
	@Test
	public void savaTest(){
		Girl girl  = new Girl();
		girl.setAge(25);
		girl.setUsername("ftyty");
		Girl girl1 = girlService.save(girl);
		Assert.assertEquals(girl1.getAge(), new Integer(25));
		Assert.assertEquals(girl1.getUsername(), "ftyty");
		
	}
	
	@Test
	public void findAllTest(){
		List<Girl> list = girlService.findAll();
	}
}
