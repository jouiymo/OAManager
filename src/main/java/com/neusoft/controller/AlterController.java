package com.neusoft.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.domain.Career;
import com.neusoft.domain.Dept;
import com.neusoft.domain.DeptSwitch;

import com.neusoft.domain.EmployeeInfo;
import com.neusoft.domain.FamilyInfo;
import com.neusoft.domain.ForeignLanguages;
import com.neusoft.domain.Post;
import com.neusoft.domain.PostSwitch;
import com.neusoft.domain.ProbationInformation;
import com.neusoft.domain.Quit;
import com.neusoft.domain.ResJson;
import com.neusoft.domain.Role;
import com.neusoft.domain.TalentInfo;
import com.neusoft.domain.User;
import com.neusoft.exception.MyException;
import com.neusoft.service.*;
import com.neusoft.util.ResJsonUtil;

/**
 * 进行修改删除操作转发的controller
 * 
 * @author sky
 *
 */
@RestController
public class AlterController {

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
	private EmpQuitInfoService eqis;
	@Autowired
	private EmpCareerInfoService ecis;
	@Autowired
	private EmpFamilyInfoService efis;
	@Autowired
	private EmpLanguagesInfoService elis;
	@Autowired
	private DeptTransInfoService dtis;
	@Autowired
	private PostTransInfoService ptis;
	@Autowired
	private ProbaInfoService pis;
	@Autowired
	private TalentService ts;
	
	
	// 人才库信息修改
	@PostMapping(value = "/alterTalent")
	public ResJson<TalentInfo> alterTalent(@Valid @ModelAttribute TalentInfo talentInfo, BindingResult bResult)
			throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		ts.alter(talentInfo);
		return ResJsonUtil.success("修改人才库信息成功");

	}
	// 员工基本信息修改
	@PostMapping(value = "/alterEmp")
	public ResJson<EmployeeInfo> alterEmp(@Valid @ModelAttribute EmployeeInfo emp, BindingResult bResult)
			throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		es.alter(emp);
		return ResJsonUtil.success("修改员工基本信息成功");

	}

	// 修改用户
	@PostMapping(value = "/alterUser")
	public ResJson<User> alterUser(@Valid @ModelAttribute User user, BindingResult bResult) throws MyException {

		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}

		us.alter(user);
		return ResJsonUtil.success("添加新用户成功");

	}

	// 修改角色
	@PostMapping(value = "/alterRole")
	public ResJson<User> alterRole(@Valid @ModelAttribute Role role, BindingResult bResult) throws MyException {

		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}

		rs.alter(role);
		return ResJsonUtil.success("添加新角色成功");

	}

	// 修改岗位
	@PostMapping(value = "/alterPost")
	public ResJson<Post> alterPost(@Valid @ModelAttribute Post post, BindingResult bResult) throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		ps.alter(post);
		return ResJsonUtil.success("修改岗位成功");

	}

	// 修改部门
	@PostMapping(value = "/alterDept")
	public ResJson<Dept> alterDept(@Valid @ModelAttribute Dept dept, BindingResult bResult) throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		ds.alter(dept);
		return ResJsonUtil.success("修改部门成功");

	}

	// 试用期信息修改
	@PostMapping(value = "/alterProbaInfo")
	public ResJson<ProbationInformation> alterProbaInfo(@RequestParam("result") Integer result,
			@RequestParam("empId") Integer empId) throws MyException {

		pis.alterResult(result, empId);
		return ResJsonUtil.success("试用期信息修改成功");

	}

	// 员工岗位调转信息修改
	@PostMapping(value = "/alterPostTransInfo")
	public ResJson<PostSwitch> alterPostTransInfo(@RequestParam("postType") Integer postType,
			@RequestParam("empId") Integer empId) throws MyException {

		ptis.alterPostType(postType, empId);
		return ResJsonUtil.success("员工岗位调转信息修改成功");

	}

	// 员工部门调转信息录入
	@PostMapping(value = "/alterDeptTransInfo")
	public ResJson<DeptSwitch> alterDeptTransInfo(@RequestParam("DeptType") Integer DeptType,
			@RequestParam("empId") Integer empId) throws MyException {

		dtis.alterDeptTransMode(DeptType, empId);
		return ResJsonUtil.success("员工部门调转信息修改成功");

	}

	// 员工离职信息修改
	@PostMapping(value = "/alterEmpQuitInfo")
	public ResJson<Quit> alterEmpQuitInfo(@RequestParam("quitType") Integer quitType,
			@RequestParam("empId") Integer empId) throws MyException {

		eqis.alterQuitType(quitType, empId);
		return ResJsonUtil.success("员工离职信息修改成功");

	}

	// 员工职业生涯信息修改
	@PostMapping(value = "/alterEmpCareerInfo")
	public ResJson<Career> alterEmpCareerInfo(@Valid @ModelAttribute Career empCareerInfo, BindingResult bResult)
			throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		ecis.alterEmpInfo(empCareerInfo);
		return ResJsonUtil.success("员工职业生涯信息修改成功");

	}

	// 员工家庭成员及社会关系信息修改
	@PostMapping(value = "/alterEmpFamilyInfo")
	public ResJson<FamilyInfo> alterEmpFamilyInfo(@Valid @ModelAttribute FamilyInfo empFamilyInfo,
			BindingResult bResult) throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		efis.alterEmpInfo(empFamilyInfo);
		return ResJsonUtil.success("员工家庭成员及社会关系信息修改成功");

	}

	// 员工外语能力信息修改
	@PostMapping(value = "/alterEmpLanguagesInfo")
	public ResJson<ForeignLanguages> alterEmpLanguagesInfo(@Valid @ModelAttribute ForeignLanguages empLanguagesInfo,
			BindingResult bResult) throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		elis.alterEmpInfo(empLanguagesInfo);
		return ResJsonUtil.success("员工外语能力信息修改成功");

	}

	// 删除部门
	@PostMapping(value = "/delDept")
	public ResJson<EmployeeInfo> delDept(@ModelAttribute Dept dept) throws MyException {

		ds.del(dept);
		return ResJsonUtil.success("删除部门成功");

	}

	// 删除岗位
	@PostMapping(value = "/delPost")
	public ResJson<EmployeeInfo> delPost(@ModelAttribute Dept dept) throws MyException {

		ds.del(dept);
		return ResJsonUtil.success("删除岗位成功");

	}

	// 删除用户
	@PostMapping(value = "/delUser")
	public ResJson<User> delUser(@ModelAttribute User user) throws MyException {

		us.del(user);
		return ResJsonUtil.success("删除用户成功");

	}

	// 删除角色
	@PostMapping(value = "/delRole")
	public ResJson<User> delRole(@ModelAttribute Role role) throws MyException {

		rs.del(role);
		return ResJsonUtil.success("删除角色成功");

	}
}
