package com.neusoft.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 用户表
 * @author msi
 *
 */
@Entity

public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer eid;
	private String ename;
	private Integer rid;// 角色id
	private String name;// 用户姓名//账号
	private String password;// 密码
	private Date regDay;// 注册时间
	private Integer state;// 是否有效

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

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDay() {
		return regDay;
	}

	public void setRegDay(Date regDay) {
		this.regDay = regDay;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
