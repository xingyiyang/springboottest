package com.scu.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xing
 * 测试从yml文件中获取数据的bean
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlBean {

	private String name;
	private Integer ages;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAges() {
		return ages;
	}

	public void setAges(Integer ages) {
		this.ages = ages;
	}

}
