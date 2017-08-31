package com.neusoft.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 岗位信息
 * 
 * @author msi
 *
 */
@Entity
public class Post {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "名字不能为空")
	private String name;
	private Integer state = 1;// 是否已被删除
	@NotNull(message = "类型不能为空")
	private Integer type;// 类型
	private Integer Organization;// 编制

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOrganization() {
		return Organization;
	}

	public void setOrganization(Integer organization) {
		Organization = organization;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", state=" + state + ", type=" + type + ", Organization="
				+ Organization + "]";
	}

}
