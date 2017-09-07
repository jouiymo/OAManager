package com.neusoft.domain;

public class MyLogger {
	// 员工id
	private Integer empId;
	// 员工姓名
	private String empname;
	// 用户名
	private String username;
	// 请求地址
	private StringBuffer url;
	// 请求方法
	private String medthod;
	// 请求类方法
	private String class_medthod;
	// 访问开始时间
	private Long starTime;
	// 访问结束时间
	private Long endTime;
	// 耗时
	private Long time;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public StringBuffer getUrl() {
		return url;
	}

	public void setUrl(StringBuffer url) {
		this.url = url;
	}

	public String getMedthod() {
		return medthod;
	}

	public void setMedthod(String medthod) {
		this.medthod = medthod;
	}

	public String getClass_medthod() {
		return class_medthod;
	}

	public void setClass_medthod(String class_medthod) {
		this.class_medthod = class_medthod;
	}

	public Long getStarTime() {
		return starTime;
	}

	public void setStarTime(Long starTime) {
		this.starTime = starTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

}
