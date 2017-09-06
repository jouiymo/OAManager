package com.neusoft.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 员工基本信息
 * 
 * @author msi
 *
 */
@Entity
public class EmployeeInfo {
	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank(message = "名字不能为空")
	private String name;
	@NotNull(message = "性别不能为空")
	private Integer gender;
	@NotNull(message = "出生日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	@NotBlank(message = "身份证号码不能为空")
	private String cardnumber;// 身份证
	@NotBlank(message = "部门不能为空")
	private String deptName;// 部门
	@NotBlank(message = "岗位不能为空")
	private String postName;// 岗位
	@NotNull(message = "入职日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entryDay;// 入职日期
	@NotNull(message = "参加工作日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date attendDay;// 参加工作日期
	@NotNull(message = "用工形式不能为空")
	private Integer Emform;// 用工形式
	@NotNull(message = "人员来源不能为空")
	private Integer sources;// 人员来源
	private Integer political;// 政治面貌
	private Integer nation;// 民族
	private String origin;// 籍贯
	private Integer phone;// 联系电话
	@Email(message = "请输入正确的邮箱")
	private String email;
	private Integer height;
	private Integer bltype;// 血型
	private Integer Marital;// 婚姻状况
	private String birthplace;// 出生地
	private String registeredpla;// 户口所在地
	private Integer education;// 最高学历
	private Integer degree;// 最高学位
	private String University;// 毕业院校
	private String Major;// 所学专业
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date graduation;// 毕业日期
	private Integer probationState;//试用期状态 正常=1，延期=2，不录用=3，没有试用期=5
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date probationstart;// 试用期开始日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date probationend;// 试用期结束日期
	private Integer state=1;//是否在职

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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Date getEntryDay() {
		return entryDay;
	}

	public void setEntryDay(Date entryDay) {
		this.entryDay = entryDay;
	}

	public Date getAttendDay() {
		return attendDay;
	}

	public void setAttendDay(Date attendDay) {
		this.attendDay = attendDay;
	}

	public Integer getEmform() {
		return Emform;
	}

	public void setEmform(Integer emform) {
		Emform = emform;
	}

	public Integer getSources() {
		return sources;
	}

	public void setSources(Integer sources) {
		this.sources = sources;
	}

	public Integer getPolitical() {
		return political;
	}

	public void setPolitical(Integer political) {
		this.political = political;
	}

	public Integer getNation() {
		return nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getBltype() {
		return bltype;
	}

	public void setBltype(Integer bltype) {
		this.bltype = bltype;
	}

	public Integer getMarital() {
		return Marital;
	}

	public void setMarital(Integer marital) {
		Marital = marital;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getRegisteredpla() {
		return registeredpla;
	}

	public void setRegisteredpla(String registeredpla) {
		this.registeredpla = registeredpla;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public String getUniversity() {
		return University;
	}

	public void setUniversity(String university) {
		University = university;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		Major = major;
	}

	public Date getGraduation() {
		return graduation;
	}

	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}

	public Date getProbationstart() {
		return probationstart;
	}

	public void setProbationstart(Date probationstart) {
		this.probationstart = probationstart;
	}

	public Date getProbationend() {
		return probationend;
	}

	public void setProbationend(Date probationend) {
		this.probationend = probationend;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getProbationState() {
		return probationState;
	}

	public void setProbationState(Integer probationState) {
		this.probationState = probationState;
	}

}
