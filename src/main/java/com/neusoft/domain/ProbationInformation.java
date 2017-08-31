package com.neusoft.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 试用期信息
 * 
 * @author msi
 *
 */
@Entity
public class ProbationInformation {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer eid;// 职工编号
	@NotBlank(message = "考核评语不能为空")
	private String comment;// 试用期部门考核评语
	@NotNull(message = "考核结果不能为空")
	private Integer result;// 考核结果1=
	@NotNull(message = "处理日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date process;// 处理日期
	private String remarks;// 备注

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Date getProcess() {
		return process;
	}

	public void setProcess(Date process) {
		this.process = process;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
