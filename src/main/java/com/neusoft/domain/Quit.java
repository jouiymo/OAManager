package com.neusoft.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 离职信息
 * 
 * @author msi
 *
 */
@Entity
public class Quit {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer eid;
	@NotNull(message = "离职日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date quitday;// 离职日期
	@NotNull(message = "离职类型不能为空")
	private Integer type;// 离职类型
	private String whereabouts;// 离职去向
	@NotNull(message = "是否进入人才库")
	private Integer whether;// 是否进入人才库
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

	public Date getQuitday() {
		return quitday;
	}

	public void setQuitday(Date quitday) {
		this.quitday = quitday;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getWhereabouts() {
		return whereabouts;
	}

	public void setWhereabouts(String whereabouts) {
		this.whereabouts = whereabouts;
	}

	public Integer getWhether() {
		return whether;
	}

	public void setWhether(Integer whether) {
		this.whether = whether;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
