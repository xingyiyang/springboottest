package com.scu.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @author xing
 * girl这张表的实体，需要注解entity
 */
@Entity
public class Girl {

	//注解主键和主键自增
	@Id
	@GeneratedValue
	private Integer id;
	
	private String username;
	
	//@Min用于controller中的valide表单验证
	@Min(value = 18, message = "需要大于18！")
	private Integer age;
	
	public Girl(){
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Girl [id=" + id + ", username=" + username + ", age=" + age + "]";
	}	
	
}
