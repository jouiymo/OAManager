package com.neusoft.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 职业生涯信息
 * 
 * @author msi
 *
 */
@Entity
public class Career {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer eid;
	@NotNull(message = "起始日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDay;// 起始日期
	@NotNull(message = "截至日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDay;// 截至日期
	private String company;// 所在单位
	private String jobcontent;// 工作内容
	private String post;// 担任职位
	private String salary;// 月薪或年薪
	private String witness;// 证明人
	private String witPost;// 证明人职务
	private Integer witPhone;// 证明人电话号码
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

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobcontent() {
		return jobcontent;
	}

	public void setJobcontent(String jobcontent) {
		this.jobcontent = jobcontent;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getWitness() {
		return witness;
	}

	public void setWitness(String witness) {
		this.witness = witness;
	}

	public String getWitPost() {
		return witPost;
	}

	public void setWitPost(String witPost) {
		this.witPost = witPost;
	}

	public Integer getWitPhone() {
		return witPhone;
	}

	public void setWitPhone(Integer witPhone) {
		this.witPhone = witPhone;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
