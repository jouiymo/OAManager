package com.neusoft.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 调转部门
 * 
 * @author msi
 *
 */
@Entity
public class DeptSwitch {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer eid;
	@NotNull(message = "调转后的部门不能为空")
	private Integer deptid;// 调转后的部门
	@NotNull(message = "调转类型不能为空")
	private Integer type;// 调转类型
	@NotBlank(message = "调转原因不能为空")
	private String reason;// 调转原因
	private String remarks;// 备注
	@NotNull(message = "调转日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date switchday;// 调转日期

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

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getSwitchday() {
		return switchday;
	}

	public void setSwitchday(Date switchday) {
		this.switchday = switchday;
	}

}
