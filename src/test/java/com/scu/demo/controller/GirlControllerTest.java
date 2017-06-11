package com.scu.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

	@Autowired
	private MockMvc mocMvc;
	
	@Test
	public void girlListTest() throws Exception {
		
		mocMvc.perform(MockMvcRequestBuilders.get("/girls"))
		.andExpect(MockMvcResultMatchers.status().isOk());
		//.andExpect(MockMvcResultMatchers.content().string("abc"));
	}
	
	@Test
	public void addGirlTest() throws Exception {
		
		mocMvc.perform(MockMvcRequestBuilders.post("/addgirl"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void getGirlByIdTest() throws Exception {
		
		mocMvc.perform(MockMvcRequestBuilders.get("/girl/1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void updateGirlTest() throws Exception {
		
		mocMvc.perform(MockMvcRequestBuilders.put("/updategirl/1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
