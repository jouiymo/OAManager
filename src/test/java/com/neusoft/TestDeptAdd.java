package com.neusoft;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.neusoft.domain.Career;
import com.neusoft.domain.Dept;
import com.neusoft.domain.DeptSwitch;
import com.neusoft.domain.Exam;
import com.neusoft.domain.FamilyInfo;
import com.neusoft.domain.ForeignLanguages;
import com.neusoft.domain.Post;
import com.neusoft.domain.PostSwitch;
import com.neusoft.domain.ProbationInformation;
import com.neusoft.domain.User;
import com.neusoft.exception.MyException;
import com.neusoft.repository.DeptRepository;
import com.neusoft.repository.PostRepository;
import com.neusoft.service.impl.DeptServiceImpl;
import com.neusoft.service.impl.DeptTransInfoServiceImpl;
import com.neusoft.service.impl.EmpCareerInfoServiceImpl;
import com.neusoft.service.impl.EmpFamilyInfoServiceImpl;
import com.neusoft.service.impl.EmpLanguagesInfoServiceImpl;
import com.neusoft.service.impl.EmpServiceImpl;
import com.neusoft.service.impl.PostServiceImpl;
import com.neusoft.service.impl.PostTransInfoServiceImpl;
import com.neusoft.service.impl.ProbaInfoServiceImpl;
import com.neusoft.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class TestDeptAdd {
	@Autowired
	private DeptRepository deptRepository;
	@Autowired
	private DeptTransInfoServiceImpl deptTransInfoServiceImpl;
	@Autowired
	EmpCareerInfoServiceImpl empCareerInfoServiceImpl;
	@Autowired
	EmpFamilyInfoServiceImpl empFamilyInfoServiceImpl;
	@Autowired
	EmpLanguagesInfoServiceImpl empLanguagesInfoServiceImpl;
	@Autowired
	PostServiceImpl postServiceImpl;
	@Autowired
	PostTransInfoServiceImpl postTransInfoServiceImpl;
	@Autowired
	ProbaInfoServiceImpl probaInfoServiceImpl;
	@Autowired
	PostRepository postRepository;
	@Autowired
	DeptServiceImpl deptServiceImpl;
	@Autowired
	EmpServiceImpl empServiceImpl;
	@Autowired
	UserServiceImpl userServiceImpl;

	// 测试deptservice
	@Test
	public void contextLoads() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Dept dept = new Dept();
		dept.setName("sss");
		dept.setType(111);
		dept.setStartDay(sdf.parse(sdf.format(new Date())));
		dept.setPhone(15551);
		deptRepository.save(dept);
	}

	@Test
	public void testFind() throws MyException {
		Dept dept = deptServiceImpl.findDeptByDeptType(111).get(0);
		System.out.println(dept.getName());
	}



	// 测试deptTransInfoService
	@Test
	public void testDeptSwitch() throws ParseException, MyException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DeptSwitch deptswitch = new DeptSwitch();
		deptswitch.setDeptid(1);
		deptswitch.setReason("ss");
		deptswitch.setSwitchday(sdf.parse(sdf.format(new Date())));
		deptswitch.setType(1);
		deptswitch.setEid(1);

		deptTransInfoServiceImpl.add(deptswitch);
	}

	@Test
	public void testAlertSwitch() throws MyException {
		deptTransInfoServiceImpl.alterDeptTransMode(2, 1);
	}

	// 测试deptservice
	@Test
	public void testCareer() throws ParseException, MyException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Career career = new Career();

		career.setStartDay(sdf.parse(sdf.format(new Date())));
		career.setEndDay(sdf.parse(sdf.format(new Date())));

		empCareerInfoServiceImpl.add(career);
	}

	// 测试empFamilyInfoService
	@Test
	public void tesFamily() throws ParseException, MyException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		FamilyInfo familyInfo = new FamilyInfo();
		familyInfo.setRelationship(1);
		familyInfo.setName("111");

		empFamilyInfoServiceImpl.add(familyInfo);
	}

	// 测试LanguagesInfoService
	@Test
	public void tesLanguages() throws ParseException, MyException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ForeignLanguages foreignLanguages = new ForeignLanguages();
		foreignLanguages.setLanguages(1);

		empLanguagesInfoServiceImpl.add(foreignLanguages);
	}

	// 测试postServiceImpl
	@Test
	public void tespost() throws ParseException, MyException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Post post = new Post();
		post.setName("www");
		post.setType(11);

		postServiceImpl.add(post);

	}

	@Test
	public void testDle() throws MyException {
		Post post = postRepository.findOne(1);
		postServiceImpl.del(post);
	}
	// 测试postTransInfoServiceImpl
	@Test
	public void tesPostInfo() throws ParseException, MyException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		PostSwitch postSwitch = new PostSwitch();
		postSwitch.setPostid(1);
		postSwitch.setReason("sss");
		postSwitch.setSwitchday(sdf.parse(sdf.format(new Date())));
		postSwitch.setType(1);
		postSwitch.setEid(2);

		postTransInfoServiceImpl.add(postSwitch);

	}
	@Test
	public void tesPostInfoAlert() throws ParseException, MyException {
		postTransInfoServiceImpl.alterPostType(2, 2);
	}
	// 测试probaInfoServiceImpl
		@Test
		public void tesproAdd() throws ParseException, MyException {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ProbationInformation probationInformation = new ProbationInformation();
			probationInformation.setComment("sss");
			probationInformation.setEid(2);
			probationInformation.setProcess(sdf.parse(sdf.format(new Date())));
			probationInformation.setResult(2);

			probaInfoServiceImpl.add(probationInformation);

		}
		@Test
		public void tesproAlert() throws ParseException, MyException {
			probaInfoServiceImpl.alterResult(1, 2);
		}
		@Autowired
		EntityManagerFactory eFactory;
		
	/**
	 * 测试empServiceImpl
	 * 
	 * @throws MyException
	 */
		@Test
		public void TestSQL() throws MyException{
			Exam exam = new Exam();
			exam.setDeptType(2);
			exam.setPostType(2);
			exam.setQuitType(1);
			exam.setUserName("eee");
			
			List<Exam> list= empServiceImpl.findExamByDeptTransExam(exam,2,1);
			for (Exam exam2 : list) {
				System.out.println(exam2.getDeptName());
			}
			list = empServiceImpl.findExamByPostTransExam(exam, 2, 1);
			for (Exam exam2 : list) {
				System.out.println(exam2.getPostName());
			}
			list = empServiceImpl.findExamByQuitExam(exam, 2, 1);
			for (Exam exam2 : list) {
				System.out.println(exam2.getPostName());
			}
			list = empServiceImpl.findExamByTransExam(exam, 2, 1);
			for (Exam exam2 : list) {
				System.out.println(exam2.getDeptName());
			}
			list=empServiceImpl.findExamByProbaExam(exam, 2, 1);
			for (Exam exam2 : list) {
				System.out.println(exam2.getBeginDay());
			}
		}
		@Test
		public void testUser() throws MyException{
			User user = userServiceImpl.findUserByEmpName("ss").get(0);
			System.out.println(user.getEname());
	
		}
		@Test	
		public void testAndState() throws MyException{
			Exam exam = new Exam();
			exam = empServiceImpl.findExamBySimpleExam(exam, 1, 1).get(0);
			System.out.println(exam.getDeptName());
		}

}
