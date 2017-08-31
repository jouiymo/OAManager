package com.neusoft.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ForeignLanguages {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer eid;
	@NotNull(message = "语种不能为空")
	private Integer languages;// 语种
	private Integer proficiency;// 熟练程度

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Integer getLanguages() {
		return languages;
	}

	public void setLanguages(Integer languages) {
		this.languages = languages;
	}

	public Integer getProficiency() {
		return proficiency;
	}

	public void setProficiency(Integer proficiency) {
		this.proficiency = proficiency;
	}

}
