package com.neusoft.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neusoft.domain.EmployeeInfo;
import com.neusoft.domain.Exam;
import com.neusoft.exception.MyException;
import com.neusoft.repository.EmpInfoRepository;
import com.neusoft.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpInfoRepository empRepository;
	@Autowired
	EntityManagerFactory eFactory;

	@Override
	@Transactional
	public EmployeeInfo add(EmployeeInfo EmployeeInfo) {
		// TODO Auto-generated method stub
		return empRepository.save(EmployeeInfo);
	}

	@Override
	@Transactional
	public EmployeeInfo alter(EmployeeInfo EmployeeInfo) {
		// TODO Auto-generated method stub
		return empRepository.save(EmployeeInfo);
	}

	@Override
	// 同理此处在查询部分编号时返回具有相同数字的员工编号的列表，未解决
	public Page<EmployeeInfo> findEmpByEmpId(Integer empid,Pageable pageable) throws MyException {
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setId(empid);
		try {
			 return empRepository.findByAuto(employeeInfo, pageable);
		} catch (Exception e) {
			throw new MyException(68, "通用员工列表查询失败");
		}
	}

	@Override
	public List<EmployeeInfo> findEmpByEmpName(String userName) throws MyException {
		try {
			return empRepository.findByNameContainingAndState(userName, 1);
		} catch (Exception e) {
			throw new MyException(68, "通用员工列表查询失败");
		}
		
	}

	@Override
	public Page<EmployeeInfo> findEmpByDeptName(String deptName,Pageable pageable) throws MyException {
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setDeptName(deptName);
		try {
		 return empRepository.findByAuto(employeeInfo, pageable);
		} catch (Exception e) {
			throw new MyException(68, "通用员工列表查询失败");
		}
		
	}
		
	

	@Override
	public Page<EmployeeInfo> findEmpByPostName(String postName,Pageable pageable) throws MyException {
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setPostName(postName);
		employeeInfo.setState(1);
		try {
			return empRepository.findByAuto(employeeInfo, pageable);
			} catch (Exception e) {
				throw new MyException(68, "通用员工列表查询失败");
			}
		
	}

	// 以下方法应用到多表查询，应写HQL语句
	@Override
	public List<EmployeeInfo> findEmpByDeptType(Integer deptType) {
		return null;
	}

	@Override
	public List<EmployeeInfo> findEmpByPostType(Integer postType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeInfo> findEmpByProbaStatus(Integer result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeInfo> findEmpByQuitType(Integer quitType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeInfo> findEmpByPostId(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<EmployeeInfo> findEmpByDeptId(Integer deptId,Pageable pageable) {
		
		return null;
	}

	@Override
	public List<EmployeeInfo> findEmpByDeptTransDay(Date beginDay, Date finalDay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeInfo> findEmpByPostTransDay(Date beginDay, Date finalDay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeInfo> findEmpByQuitDay(Date beginDay, Date finalDay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeInfo> findEmpByProbaBeginDay(Date beginDay) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeInfo> findEmpByProbaFinalDay(Date finalDay) {
		// TODO Auto-generated method stub
		return null;
	}

	// 此处也许应该用到左外连接或右外连接
	@Override
	public List<Exam> findExamBySimpleExam(Exam exam, Integer size, Integer page) throws MyException {
		EntityManager em = eFactory.createEntityManager();
		String sql = "select e.name en,e.id ei,d.name dn from EmployeeInfo e left join dept d on e.deptname=d.name  ";
		sql += " where e.state=1 ";
		if (null != exam.getUserName() && exam.getUserName().length()!=0 ) {
			sql += " and e.name='" + exam.getUserName() + "'";
		}
		if (null != exam.getEmpid()) {
			sql += " and e.id=" + exam.getEmpid();
		}
		if (null != exam.getDeptName() && exam.getDeptName().length()!=0) {
			sql += " and d.name='" + exam.getDeptName() + "'";
		}
		sql += " LIMIT " + (page - 1) * size + "," + size;
		List list = null;
		try {
			list = em.createNativeQuery(sql).getResultList();
		} catch (Exception e) {
			throw new MyException(68, "通用员工列表查询失败");
		}
		
		List<Exam> exams = new ArrayList<Exam>();
		for (Object o : list) {
			Object[] os = (Object[]) o;
			Exam ex = new Exam();
			ex.setUserName((String) os[0]);
			ex.setEmpid((Integer) os[1]);
			ex.setDeptName((String) os[2]);
			exams.add(ex);
		}
		return exams;

		// boolean flag = false;
		// EmployeeInfo (e) 1 2 probationstart;// 试用期开始日期 probationend;//
		// 试用期结束日期 name id
		// quit (q) quitday 离职日期 type 离职类型
		// DeptSwitch (ds) switchday;// 部门调转日期 type部门调转方式
		// ProbationInformation (pi) result 考核结果
		// PostSwitch (ps) type岗位调转方式
		// Post (p) name id dept (d) name id
		/*
		 * Select
		 * e.probationstart,e.probationend,e.name,e.id,q.quitday,q.type,ds.
		 * switchday,ds.type,pi.result, ps.type,p.name,p.id,d.name,d.id from
		 * EmployeeInfo e,quit q,DeptSwitch ds,ProbationInformation
		 * pi,PostSwitch ps,Post p,dept d
		 */

		/*
		 * String sql =
		 * "Select e.probationstart,e.probationend,e.name en,e.id ei,q.quitday,q.type qt,ds.switchday dsd,ds.type dt,pi.result,"
		 * +
		 * "ps.type pt,p.name pn,p.id pid,d.name dn,d.id di,ps.switchday from "
		 * +
		 * " EmployeeInfo e,quit q,DeptSwitch ds,ProbationInformation pi,PostSwitch ps,Post p,dept d "
		 * ; try { flag = CheckUtil.checkObjFieldIsNull(exam); } catch
		 * (IllegalAccessException e) { e.printStackTrace(); } if (true != flag)
		 * { sql += "where e.deptid=d.id"; if (null != exam.getFinalDay()) { sql
		 * += " and e.probationstart= " + exam.getFinalDay(); } if (null !=
		 * exam.getBeginDay()) { sql += " and e.probationend=" +
		 * exam.getBeginDay(); } if (null != exam.getFinDay() && null !=
		 * exam.getBegDay()) { sql += " and q.quitday between " +
		 * exam.getBegDay() + " and " + exam.getFinDay(); } if (null !=
		 * exam.getDfinDay() && null != exam.getDbegDay()) { sql +=
		 * " and d.switchday between " + exam.getDbegDay() + " and " +
		 * exam.getDfinDay(); } if (null != exam.getPfinDay() && null !=
		 * exam.getPbegDay()) { sql += " and p.switchday between " +
		 * exam.getPfinDay() + " and " + exam.getPbegDay(); } if (null !=
		 * exam.getDeptId()) { sql += " and d.id=" + exam.getDeptId(); } if
		 * (null != exam.getPostId()) { sql += " and p.id=" + exam.getPostId();
		 * } if (null != exam.getQuitType()) { sql += " and q.type=" +
		 * exam.getQuitType(); } if (null != exam.getResult()) { sql +=
		 * " and pi.result=" + exam.getResult(); } if (null !=
		 * exam.getPostType()) { sql += " and ps.type=" + exam.getPostType(); }
		 * if (null != exam.getDeptType()) { sql += " and ds.type" +
		 * exam.getDeptType(); } if (null != exam.getPostName()) { sql +=
		 * " and p.name=" + exam.getPostName(); } if (null !=
		 * exam.getDeptName()) { sql += "and d.name=" + exam.getDeptName(); } if
		 * (null != exam.getUserName()) { sql += "and e.name=" +
		 * exam.getUserName(); } if (null != exam.getEmpid()) { sql +=
		 * " and e.id=" + exam.getEmpid(); }
		 * 
		 * } Query query = em.createNativeQuery(sql); List list =
		 * query.getResultList(); List<Exam> exams = new ArrayList<Exam>();
		 * 
		 * if (list != null && list.size() > 0) {
		 * 
		 * String sql =
		 * "Select e.probationstart0,e.probationend1,e.name en2,e.id ei3,q.quitday4,q.type qt5,ds.switchday6,ds.type dt7,pi.result8,"
		 * +
		 * "ps.type pt9,p.name pn10,p.id pid11,d.name dn12,d.id di13 ,ps.switchday14 from "
		 * +
		 * " EmployeeInfo e,quit q,DeptSwitch ds,ProbationInformation pi,PostSwitch ps,Post p,dept d "
		 * ; for (Object obj : list) { Object[] objs = (Object[])obj; Exam ex =
		 * new Exam((Date)objs[0], (Date)objs[1], exam.getFinDay(),
		 * exam.getBegDay(), (Date)objs[4],exam.getDfinDay(),
		 * exam.getDbegDay(),(Date)objs[6], exam.getPfinDay(),
		 * exam.getPbegDay(), (Date)objs[14], (int)objs[13], (int)objs[11],
		 * (int)objs[5], (int)objs[8], (int)objs[9], (int)objs[7],
		 * (String)objs[10], (String)objs[12], (String)objs[2], (int)objs[3]);
		 * exams.add(ex); } }
		 */
	}

	@Override
	public List<EmployeeInfo> findEmpByTransDay(Date beginDay, Date finalDay) {
		return null;
	}

	@Override
	public List<Exam> findExamByDeptTransExam(Exam exam, Integer size, Integer page) throws MyException {
		EntityManager em = eFactory.createEntityManager();

		String sql = "select e.name en,e.id ei,d.name,d.id,ds.type,ds.switchday from DeptSwitch ds left join EmployeeInfo e on ds.eid=e.id left join dept d on ds.deptid=d.id ";
		// 此处有缺陷，调动信息应只持有员工Id，其他信息应通过员工查询到。否则查询会变得更复杂易错
		sql += " where e.state = 1 ";
		if (null != exam.getDfinDay() && null != exam.getDbegDay()) {
			sql += " and ds.switchday between '" + exam.getDbegDay() + "' and '" + exam.getDfinDay() + "'";
		}
		if (null != exam.getUserName() && exam.getUserName().length()!=0) {
			sql += "and e.name='" + exam.getUserName() + "'";
		}
		if (null != exam.getEmpid()) {
			sql += " and e.id=" + exam.getEmpid();
		}
		if (null != exam.getDeptType() ) {
			sql += " and ds.type=" + exam.getDeptType();
		}
		sql += " LIMIT " + (page - 1) * size + "," + size;
		List list = null;
		try {
			list = em.createNativeQuery(sql).getResultList();
		} catch (Exception e) {
			throw new MyException(68, "通用员工列表查询失败");
		}
		
		List<Exam> exams = new ArrayList<Exam>();
		for (Object o : list) {
			Object[] os = (Object[]) o;
			Exam ex = new Exam();
			ex.setUserName((String) os[0]);
			ex.setEmpid((Integer) os[1]);
			ex.setDeptName((String) os[2]);
			ex.setDeptId((Integer) os[3]);
			ex.setDeptType((Integer) os[4]);
			ex.setDday((Date) os[5]);
			exams.add(ex);
		}
		return exams;
	}

	@Override
	public List<Exam> findExamByPostTransExam(Exam exam, Integer size, Integer page) throws MyException {
		EntityManager em = eFactory.createEntityManager();

		String sql = "select e.name en,e.id ei,p.name,p.id,ps.type,ps.switchday from postSwitch ps left join EmployeeInfo e on ps.eid=e.id left join post p on ps.postid=p.id ";
		sql += " where  e.state = 1 ";
		if (null != exam.getPfinDay() && null != exam.getPbegDay()) {
			sql += " and p.switchday between '" + exam.getPfinDay() + "' and '" + exam.getPbegDay() + "'";
		}
		if (null != exam.getUserName() && exam.getUserName().length()!=0) {
			sql += "and e.name='" + exam.getUserName() + "'";
		}
		if (null != exam.getEmpid()) {
			sql += " and e.id=" + exam.getEmpid();
		}
		if (null != exam.getPostType()) {
			sql += " and ps.type=" + exam.getPostType();
		}
		sql += " LIMIT " + (page - 1) * size + "," + size;
		List list=null;
		try {
			 list = em.createNativeQuery(sql).getResultList();
		} catch (Exception e) {
			throw new MyException(68, "通用员工列表查询失败");
		}
		
		List<Exam> exams = new ArrayList<Exam>();
		for (Object o : list) {
			Object[] os = (Object[]) o;
			Exam ex = new Exam();
			ex.setUserName((String) os[0]);
			ex.setEmpid((Integer) os[1]);
			ex.setPostName((String) os[2]);
			ex.setPostId((Integer) os[3]);
			ex.setPostType((Integer) os[4]);
			ex.setPday((Date) os[5]);
			exams.add(ex);
		}
		return exams;

	}

	@Override
	public List<Exam> findExamByQuitExam(Exam exam, Integer size, Integer page) throws MyException {
		EntityManager em = eFactory.createEntityManager();
		// 如果对应的部门名称重复，那么1条quit数据查出两个结果
		String sql = "select e.name en,e.id ei,p.name pn,d.name dn,q.type,q.quitday from quit q left join EmployeeInfo e on q.eid=e.id left join dept d on e.deptname=d.name left join post p on e.postname=p.name ";
		sql += " where e.state = -1 ";
		if (null != exam.getFinDay() && null != exam.getBegDay()) {
			sql += " and q.quitday between '" + exam.getFinDay() + "' and " + exam.getBegDay() + "'";
		}
		if (null != exam.getUserName() && exam.getUserName().length()!=0) {
			sql += "and e.name='" + exam.getUserName() + "'";
		}
		if (null != exam.getEmpid()) {
			sql += " and e.id=" + exam.getEmpid();
		}
		if (null != exam.getQuitType()) {
			sql += " and q.type=" + exam.getQuitType();
		}
		if (null != exam.getDeptName() && exam.getDeptName().length()!=0) {
			sql += " and d.name='" + exam.getDeptName() + "'";
		}
		if (null != exam.getPostName() && exam.getPostName().length()!=0) {
			sql += " and p.name='" + exam.getPostName() + "'";
		}
		sql += " LIMIT " + (page - 1) * size + "," + size;
		List list=null;
		try {
			 list = em.createNativeQuery(sql).getResultList();
		} catch (Exception e) {
			throw new MyException(68, "通用员工列表查询失败");
		}
		
		List<Exam> exams = new ArrayList<Exam>();
		for (Object o : list) {
			Object[] os = (Object[]) o;
			Exam ex = new Exam();
			ex.setUserName((String) os[0]);
			ex.setEmpid((Integer) os[1]);
			ex.setPostName((String) os[2]);
			ex.setDeptName((String) os[3]);
			ex.setQuitType((Integer) os[4]);
			ex.setQuitDay((Date) os[5]);
			exams.add(ex);
		}
		return exams;
	}

	@Override
	public List<Exam> findExamByTransExam(Exam exam, Integer size, Integer page) throws MyException {
		EntityManager em = eFactory.createEntityManager();
		String sql = "select e.name en,e.id ei,d.name dn,d.id di,pi.process from ProbationInformation pi left join EmployeeInfo e on pi.eid=e.id left join dept d on e.deptname=d.name  ";
		sql += " where  e.state = 1 ";
		if (null != exam.getPifinDay() && null != exam.getPibegDay()) {
			sql += " and pi.process between '" + exam.getPifinDay() + "' and '" + exam.getPibegDay() + "'";
		}
		if (null != exam.getUserName() && exam.getUserName().length()!=0) {
			sql += " and e.name='" + exam.getUserName() + "'";
		}
		if (null != exam.getEmpid()) {
			sql += " and e.id=" + exam.getEmpid();
		}
		if (null != exam.getDeptName() && exam.getDeptName().length()!=0) {
			sql += " and d.name='" + exam.getDeptName() + "'";
		}
		if (null != exam.getDeptId()) {
			sql += " and d.id=" + exam.getDeptId();
		}
		sql += " LIMIT " + (page - 1) * size + "," + size;
		List list=null;
		try {
			 list = em.createNativeQuery(sql).getResultList();
		} catch (Exception e) {
			throw new MyException(68, "通用员工列表查询失败");
		}
		
		List<Exam> exams = new ArrayList<Exam>();
		for (Object o : list) {
			Object[] os = (Object[]) o;
			Exam ex = new Exam();
			ex.setUserName((String) os[0]);
			ex.setEmpid((Integer) os[1]);
			ex.setDeptName((String) os[2]);
			ex.setDeptId((Integer) os[3]);
			ex.setProcess((Date) os[4]);
			exams.add(ex);
		}
		return exams;
	}

	@Override
	public List<Exam> findExamByProbaExam(Exam exam, Integer size, Integer page) throws MyException {

		EntityManager em = eFactory.createEntityManager();
		String sql = "select e.name en,e.id ei,d.name dn,p.name pn,pi.result,e.probationstart,e.probationend from ProbationInformation pi left join EmployeeInfo e on pi.eid=e.id left join dept d on e.deptname=d.name left join post p on e.postname=p.name  ";
		sql += " where  e.state = 1 ";
		if (null != exam.getFinalDay() && null != exam.getBeginDay()) {
			sql += " and e.probationstart >= '" + exam.getBeginDay() + "' and e.probationend<= '" + exam.getFinalDay()
					+ "'";
		}
		if (null != exam.getUserName() && exam.getUserName().length()!=0) {
			sql += " and e.name='" + exam.getUserName() + "'";
		}
		if (null != exam.getEmpid()) {
			sql += " and e.id=" + exam.getEmpid();
		}
		if (null != exam.getDeptName() && exam.getDeptName().length()!=0) {
			sql += " and d.name='" + exam.getDeptName() + "'";
		}
		if (null != exam.getPostName() && exam.getPostName().length()!=0) {
			sql += " and p.name=" + exam.getPostName();
		}
		if (null != exam.getResult()) {
			sql += " and pi.result=" + exam.getResult();
		}
		sql += " LIMIT " + (page - 1) * size + "," + size;
		List list=null;
		try {
			 list = em.createNativeQuery(sql).getResultList();
		} catch (Exception e) {
			throw new MyException(68, "通用员工列表查询失败");
		}
		
		List<Exam> exams = new ArrayList<Exam>();
		for (Object o : list) {
			Object[] os = (Object[]) o;
			Exam ex = new Exam();
			ex.setUserName((String) os[0]);
			ex.setEmpid((Integer) os[1]);
			ex.setDeptName((String) os[2]);
			ex.setPostName((String) os[3]);
			ex.setResult((Integer) os[4]);
			ex.setBeginDay((Date) os[5]);
			ex.setFinalDay((Date) os[6]);
			exams.add(ex);
		}
		return exams;
	}

}
