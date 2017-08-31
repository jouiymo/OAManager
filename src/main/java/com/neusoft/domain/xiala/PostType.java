package com.neusoft.domain.xiala;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
/**
 * 岗位类型下拉框
 * @author msi
 *
 */
@Entity
public class PostType {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank
	private String name;

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

}
