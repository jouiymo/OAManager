package com.neusoft.domain;

import java.util.Date;

public class Exam {
	private Date finalDay;// 试用期结束日期
	private Date beginDay;// 试用期开始
	private Date finDay;// 离职结束日期
	private Date begDay;// 离职开始日期
	private Date quitDay;// 离职日期
	private Date DfinDay;// 部门调转结束日期
	private Date DbegDay;// 部门调转开始日期
	private Date Dday;// 部门调转日期
	private Date PifinDay;// 试用处理结束日期
	private Date PibegDay;// 试用处理开始日期
	private Date process;// 试用处理日期
	private Date PfinDay;// 岗位调转结束日期
	private Date PbegDay;// 岗位调转开始日期
	private Date Pday;// 岗位调转日期
	private Integer deptId;// 部门编号
	private Integer postId;// 岗位编号
	private Integer quitType;// 离职类型
	private Integer result;// 试用期状态
	private Integer postType;// 岗位调转方式
	private Integer deptType;// 部门调转方式
	private String postName;// 岗位名称
	private String deptName;// 部门名称
	private String userName;// 员工姓名
	private Integer empid;// 员工编号

	public Date getFinalDay() {
		return finalDay;
	}

	public void setFinalDay(Date finalDay) {
		this.finalDay = finalDay;
	}

	public Date getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(Date beginDay) {
		this.beginDay = beginDay;
	}

	public Date getFinDay() {
		return finDay;
	}

	public void setFinDay(Date finDay) {
		this.finDay = finDay;
	}

	public Date getBegDay() {
		return begDay;
	}

	public void setBegDay(Date begDay) {
		this.begDay = begDay;
	}

	public Date getQuitDay() {
		return quitDay;
	}

	public void setQuitDay(Date quitDay) {
		this.quitDay = quitDay;
	}

	public Date getDfinDay() {
		return DfinDay;
	}

	public void setDfinDay(Date dfinDay) {
		DfinDay = dfinDay;
	}

	public Date getDbegDay() {
		return DbegDay;
	}

	public void setDbegDay(Date dbegDay) {
		DbegDay = dbegDay;
	}

	public Date getDday() {
		return Dday;
	}

	public void setDday(Date dday) {
		Dday = dday;
	}

	public Date getPifinDay() {
		return PifinDay;
	}

	public void setPifinDay(Date pifinDay) {
		PifinDay = pifinDay;
	}

	public Date getPibegDay() {
		return PibegDay;
	}

	public void setPibegDay(Date pibegDay) {
		PibegDay = pibegDay;
	}

	public Date getProcess() {
		return process;
	}

	public void setProcess(Date process) {
		this.process = process;
	}

	public Date getPfinDay() {
		return PfinDay;
	}

	public void setPfinDay(Date pfinDay) {
		PfinDay = pfinDay;
	}

	public Date getPbegDay() {
		return PbegDay;
	}

	public void setPbegDay(Date pbegDay) {
		PbegDay = pbegDay;
	}

	public Date getPday() {
		return Pday;
	}

	public void setPday(Date pday) {
		Pday = pday;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getQuitType() {
		return quitType;
	}

	public void setQuitType(Integer quitType) {
		this.quitType = quitType;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Integer getPostType() {
		return postType;
	}

	public void setPostType(Integer postType) {
		this.postType = postType;
	}

	public Integer getDeptType() {
		return deptType;
	}

	public void setDeptType(Integer deptType) {
		this.deptType = deptType;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public Exam(Date finalDay, Date beginDay, Date finDay, Date begDay, Date quitDay, Date dfinDay, Date dbegDay,
			Date dday, Date pifinDay, Date pibegDay, Date process, Date pfinDay, Date pbegDay, Date pday,
			Integer deptId, Integer postId, Integer quitType, Integer result, Integer postType, Integer deptType,
			String postName, String deptName, String userName, Integer empid) {
		super();
		this.finalDay = finalDay;
		this.beginDay = beginDay;
		this.finDay = finDay;
		this.begDay = begDay;
		this.quitDay = quitDay;
		DfinDay = dfinDay;
		DbegDay = dbegDay;
		Dday = dday;
		PifinDay = pifinDay;
		PibegDay = pibegDay;
		this.process = process;
		PfinDay = pfinDay;
		PbegDay = pbegDay;
		Pday = pday;
		this.deptId = deptId;
		this.postId = postId;
		this.quitType = quitType;
		this.result = result;
		this.postType = postType;
		this.deptType = deptType;
		this.postName = postName;
		this.deptName = deptName;
		this.userName = userName;
		this.empid = empid;
	}

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

}
