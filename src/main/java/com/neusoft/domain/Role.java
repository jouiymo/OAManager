package com.neusoft.domain;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 角色表
 * 
 * @author msi
 *
 */
@Entity
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@ElementCollection(fetch = FetchType.LAZY, // 加载策略,延迟加载
			targetClass = Integer.class) // 指定集合中元素的类型
	@CollectionTable(name = "P_ID") // 指定集合生成的表
	private List<Integer> PrivilegeId;// 权限id
	private Integer state;// 是否有效

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

	public List<Integer> getPrivilegeId() {
		return PrivilegeId;
	}

	public void setPrivilegeId(List<Integer> privilegeId) {
		PrivilegeId = privilegeId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
