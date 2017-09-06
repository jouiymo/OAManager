package com.neusoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.domain.Career;
import com.neusoft.domain.Dept;
import com.neusoft.domain.EmployeeInfo;
import com.neusoft.domain.Exam;
import com.neusoft.domain.FamilyInfo;
import com.neusoft.domain.ForeignLanguages;
import com.neusoft.domain.MyLogger;
import com.neusoft.domain.Post;
import com.neusoft.domain.Privilege;
import com.neusoft.domain.ResJson;
import com.neusoft.domain.Role;
import com.neusoft.domain.TalentInfo;
import com.neusoft.domain.User;
import com.neusoft.exception.MyException;
import com.neusoft.service.DeptService;
import com.neusoft.service.EmpCareerInfoService;
import com.neusoft.service.EmpFamilyInfoService;
import com.neusoft.service.EmpLanguagesInfoService;
import com.neusoft.service.EmpService;
import com.neusoft.service.LoggerService;
import com.neusoft.service.PostService;
import com.neusoft.service.PrivilegeService;
import com.neusoft.service.RoleService;
import com.neusoft.service.TalentService;
import com.neusoft.service.UserService;
import com.neusoft.util.ResJsonUtil;

/**
 * 进行查询操作转发的controller
 * 
 * @author sky
 *
 */
@RestController
public class FindController {

	@Autowired
	private EmpService es;
	@Autowired
	private DeptService ds;
	@Autowired
	private PostService ps;
	@Autowired
	private UserService us;
	@Autowired
	private RoleService rs;
	@Autowired
	private EmpCareerInfoService ecif;
	@Autowired
	private EmpFamilyInfoService efif;
	@Autowired
	private EmpLanguagesInfoService elif;
	@Autowired
	private TalentService ts;
	@Autowired
	private PrivilegeService prs;
	@Autowired
	private LoggerService ls;

	// 查询权限表
	@GetMapping(value = "/findPrivilege")
	public ResJson<Privilege> findPrivilege() throws MyException {

		List<Privilege> list = prs.findAll();
		return ResJsonUtil.success(list, "查询权限表成功");

	}

	// 通过构建不完整的人才库信息查询人才库列表
	@GetMapping(value = "/findTalent")
	public ResJson<TalentInfo> findTalent(@ModelAttribute TalentInfo talentInfo,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {

		Pageable pageable = new PageRequest(page, size);
		Page<TalentInfo> pages = ts.findTalentInfoByTalentInfo(talentInfo, pageable);
		return ResJsonUtil.success(pages, "查询人才库列表成功");

	}

	// 通过构建不完整的用户查询用户列表
	@GetMapping(value = "/findUser")
	public ResJson<User> findUser(@ModelAttribute User user,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {

		Pageable pageable = new PageRequest(page, size);
		Page<User> pages = us.findUserByUser(user, pageable);
		return ResJsonUtil.success(pages, "查询用户列表成功");

	}

	// 查询角色表
	@GetMapping(value = "/findRole")
	public ResJson<Role> findRole() throws MyException {

		List<Role> list = rs.findAll();
		return ResJsonUtil.success(list, "查询角色表成功");

	}

	// 通过构建不完整的部门查询部门列表
	@GetMapping(value = "/findDept")
	public ResJson<Dept> findDept(@ModelAttribute Dept dept,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {

		Pageable pageable = new PageRequest(page, size);
		Page<Dept> pages = ds.findDeptByDept(dept, pageable);
		return ResJsonUtil.success(pages, "查询部门列表成功");

	}

	// 通过构建不完整的岗位查询岗位列表
	@GetMapping(value = "/findPost")
	public ResJson<Post> findPost(@ModelAttribute Post post,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {

		Pageable pageable = new PageRequest(page, size);
		Page<Post> pages = ps.findPostByPost(post, pageable);
		return ResJsonUtil.success(pages, "查询岗位列表成功");

	}

	// 通过构建例子查询员工列表-已调动部门员工信息查询
	@GetMapping(value = "/findForDeptTrans")
	public ResJson<EmployeeInfo> findExamForDeptTrans(@ModelAttribute Exam exam,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {

		List<Exam> list = es.findExamByDeptTransExam(exam, size, page);
		return ResJsonUtil.success(list, "查询已调动部门员工信息成功");

	}

	// 通过构建例子查询员工列表-已调动岗位员工信息查询
	@GetMapping(value = "/findForPostTrans")
	public ResJson<EmployeeInfo> findExamForPostTrans(@ModelAttribute Exam exam,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {

		List<Exam> list = es.findExamByPostTransExam(exam, size, page);
		return ResJsonUtil.success(list, "查询已调动岗位员工信息成功");

	}

	// 通过构建例子查询员工列表-已离职员工信息查询
	@GetMapping(value = "/findForQuit")
	public ResJson<EmployeeInfo> findExamForQuit(@ModelAttribute Exam exam,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {

		List<Exam> list = es.findExamByQuitExam(exam, size, page);
		return ResJsonUtil.success(list, "查询已离职员工信息成功");

	}

	// 通过构建例子查询员工列表-已转正员工信息查询
	@GetMapping(value = "/findForTrans")
	public ResJson<EmployeeInfo> findExamForTrans(@ModelAttribute Exam exam,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {

		List<Exam> list = es.findExamByTransExam(exam, size, page);
		return ResJsonUtil.success(list, "查询已转正员工信息成功");

	}

	// 通过构建例子查询员工列表-试用期员工信息查询
	@GetMapping(value = "/findForProba")
	public ResJson<EmployeeInfo> findExamForProba(@ModelAttribute Exam exam,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {

		List<Exam> list = es.findExamByProbaExam(exam, size, page);
		return ResJsonUtil.success(list, "查询试用期员工信息成功");

	}

	// 通过构建例子查询员工列表-通用员工列表查询
	@GetMapping(value = "/findForSimple")
	public ResJson<EmployeeInfo> findExamForSimple(@ModelAttribute Exam exam,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {

		List<Exam> list = es.findExamBySimpleExam(exam, size, page);
		return ResJsonUtil.success(list, "查询通用员工列表成功");

	}

	// 员工Id查询职业生涯信息
	@GetMapping(value = "/findEmpCareerInfo")
	public ResJson<Career> findEmpCareerInfo(Integer empId) throws MyException {

		List<Career> list = ecif.find(empId);
		return ResJsonUtil.success(list, "查询职业生涯信息成功");

	}

	// 员工Id查询员工家庭成员及社会关系信息
	@GetMapping(value = "/findEmpFamilyInfo")
	public ResJson<FamilyInfo> findEmpFamilyInfo(Integer empId) throws MyException {

		List<FamilyInfo> list = efif.find(empId);
		return ResJsonUtil.success(list, "查询职业生涯信息成功");

	}

	// 员工Id查询员工外语能力信息
	@GetMapping(value = "/findEmpLanguagesInfo")
	public ResJson<ForeignLanguages> findEmpLanguagesInfo(Integer empId) throws MyException {

		List<ForeignLanguages> list = elif.find(empId);
		return ResJsonUtil.success(list, "查询员工外语能力信息成功");

	}

	// 日志查询
	@GetMapping(value = "/findMylogger")
	public ResJson<MyLogger> findMylogger(@ModelAttribute MyLogger myLogger,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "15") Integer size) throws MyException {
		Pageable pageable = new PageRequest(page, size);
		Page<MyLogger> pages = ls.findByLog(myLogger, pageable);

		return ResJsonUtil.success(pages, "查询日志列表成功");

	}
}
