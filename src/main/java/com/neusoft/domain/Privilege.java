package com.neusoft.domain;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 权限表
 * 
 * @author msi
 *
 */
@Entity
public class Privilege {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@ElementCollection(fetch = FetchType.LAZY, // 加载策略,延迟加载
			targetClass = String.class) // 指定集合中元素的类型
	@CollectionTable(name = "PATH") // 指定集合生成的表
	private List<String> path;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}

}
