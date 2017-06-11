package com.scu.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scu.demo.domain.Girl;

/**
 * @author xing
 * 查询girl这张表的接口，继承JpaRepository接口，jpa.jar包中整合hibernate和springboot
 * JpaRepository<Girl, Integer>，Girl是domain包下的实体名称，对应数据库中的girl表，integer是主键的类型
 */
public interface GirlRepository extends JpaRepository<Girl, Integer>{

	//通过username查询girl,名字可能相同，所以返回list
	//自定义的查询数据库方式，需要符合hibernate的格式
	public List<Girl> findByUsername(String username);
}
