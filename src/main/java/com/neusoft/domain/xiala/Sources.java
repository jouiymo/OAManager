package com.neusoft.domain.xiala;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
/**
 * 来源
 * @author msi
 *
 */
@Entity
public class Sources {
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
