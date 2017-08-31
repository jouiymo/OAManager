package com.neusoft.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 部门信息
 * 
 * @author msi
 *
 */
@Entity
public class Dept {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "名字不能为空")
	private String name;
	private Integer state = 1;// 是否已被删除
	@NotNull(message = "类型不能为空")
	private Integer type;// 类型
	@NotNull(message = "电话号码不能为空")
	private Integer phone;// 电话
	private String fax;// 传真
	private String discribe;// 描述
	private String supName;// 上级部门
	@NotNull(message = "成立日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDay;// 成立日期

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

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDiscribe() {
		return discribe;
	}

	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}

	public Date getDate() {
		return startDay;
	}

	public void setDate(Date date) {
		this.startDay = date;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

}
