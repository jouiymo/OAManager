package com.neusoft.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 角色表
 * @author msi
 *
 */
@Entity
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer[] PrivilegeId;// 权限id
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

	public Integer[] getPrivilegeId() {
		return PrivilegeId;
	}

	public void setPrivilegeId(Integer[] privilegeId) {
		PrivilegeId = privilegeId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
