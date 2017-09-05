package com.neusoft.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
 * 进行增加操作转发的controller
 * 
 * @author sky
 *
 */
@RestController
public class AddController {

	private final static Logger logger = LoggerFactory.getLogger(AddController.class);

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
	
	// 人才库信息录入
		@PostMapping(value = "/addTalent")
	public ResJson<TalentInfo> addTalent(@Valid @ModelAttribute TalentInfo talentInfo, BindingResult bResult)
				throws MyException {

			if (bResult.hasErrors()) {

				 throw new MyException(10, "参数不正确");
			}

			ts.add(talentInfo);
			return ResJsonUtil.success("添加人才库信息成功");

		}
	// 员工基本信息录入
	@PostMapping(value = "/addEmp")
	public ResJson<EmployeeInfo> addEmp(@Valid @ModelAttribute EmployeeInfo emp, BindingResult bResult)
			throws MyException {

		if (bResult.hasErrors()) {

			 throw new MyException(10, "参数不正确");
		}

		es.add(emp);
		return ResJsonUtil.success("添加新员工成功");

	}

	// 新增用户
	@PostMapping(value = "/addUser")
	public ResJson<User> addUser(@Valid @ModelAttribute User user, BindingResult bResult) throws MyException {

		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}

		us.add(user);
		return ResJsonUtil.success("添加新用户成功");

	}

	// 新增角色
	@PostMapping(value = "/addRole")
	public ResJson<User> addRole(@Valid @ModelAttribute Role role, BindingResult bResult) throws MyException {

		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}

		rs.add(role);
		return ResJsonUtil.success("添加新角色成功");

	}

	// 新增岗位
	@PostMapping(value = "/addPost")
	public ResJson<Post> addPost(@Valid @ModelAttribute Post post, BindingResult bResult) throws MyException {

		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}

		ps.add(post);
		return ResJsonUtil.success("添加新岗位成功");

	}

	// 新增部门
	@PostMapping(value = "/addDept")
	public ResJson<Dept> addDept(@Valid @ModelAttribute Dept dept, BindingResult bResult) throws MyException {

		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		ds.add(dept);
		return ResJsonUtil.success("添加新部门成功");

	}

	// 试用期信息录入
	@PostMapping(value = "/addProbaInfo")
	public ResJson<ProbationInformation> addProbaInfo(@Valid @ModelAttribute ProbationInformation probationInformation,
			BindingResult bResult) throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		pis.add(probationInformation);
		return ResJsonUtil.success("试用期信息录入成功");

	}

	// 员工岗位调转信息录入
	@PostMapping(value = "/addPostTransInfo")
	public ResJson<PostSwitch> addPostTransInfo(@Valid @ModelAttribute PostSwitch postSwitch, BindingResult bResult)
			throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		ptis.add(postSwitch);
		return ResJsonUtil.success("员工岗位调转信息录入成功");

	}

	// 员工部门调转信息录入
	@PostMapping(value = "/addDeptTransInfo")
	public ResJson<DeptSwitch> addDeptTransInfo(@Valid @ModelAttribute DeptSwitch deptSwitch, BindingResult bResult)
			throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		dtis.add(deptSwitch);
		return ResJsonUtil.success("员工部门调转信息录入成功");

	}

	// 员工离职信息录入
	@PostMapping(value = "/addEmpQuitInfo")
	public ResJson<Quit> addEmpQuitInfo(@Valid @ModelAttribute Quit quit, BindingResult bResult) throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		eqis.add(quit);
		return ResJsonUtil.success("员工离职信息录入成功");

	}

	// 员工职业生涯信息录入
	@PostMapping(value = "/addEmpCareerInfo")
	public ResJson<Career> addEmpCareerInfo(@Valid @ModelAttribute Career empCareerInfo, BindingResult bResult)
			throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		ecis.add(empCareerInfo);
		return ResJsonUtil.success("员工职业生涯信息录入成功");

	}

	// 员工家庭成员及社会关系信息录入
	@PostMapping(value = "/addEmpFamilyInfo")
	public ResJson<FamilyInfo> addEmpFamilyInfo(@Valid @ModelAttribute FamilyInfo empFamilyInfo, BindingResult bResult)
			throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		efis.add(empFamilyInfo);
		return ResJsonUtil.success("员工家庭成员及社会关系信息录入成功");

	}

	// 员工外语能力信息录入
	@PostMapping(value = "/addEmpLanguagesInfo")
	public ResJson<ForeignLanguages> addEmpLanguagesInfo(@Valid @ModelAttribute ForeignLanguages empLanguagesInfo,
			BindingResult bResult) throws MyException {
		if (bResult.hasErrors()) {
			throw new MyException(10, "参数不正确");
		}
		elis.add(empLanguagesInfo);
		return ResJsonUtil.success("员工外语能力信息录入成功");
	}

}
