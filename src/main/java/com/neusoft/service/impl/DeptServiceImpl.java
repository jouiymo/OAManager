package com.neusoft.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neusoft.domain.Dept;
import com.neusoft.domain.EmployeeInfo;
import com.neusoft.exception.MyException;
import com.neusoft.repository.DeptRepository;
import com.neusoft.repository.EmpInfoRepository;
import com.neusoft.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptRepository deptRepository;
	@Autowired
	EmpInfoRepository empInfoRepository;

	@Autowired
	EntityManagerFactory eFactory;
	/*
	 * @Autowired SessionFactory不可以使用为什么 SessionFactory sessionFactory;
	 */

	public void testQBC() {
		/*
		 * sessionFactory.getCurrentSession().createCriteria(objct.class);
		 * 直接使用hibernate来查询 另还有一种jpa自带的example的方法
		 */
		eFactory.createEntityManager().createNativeQuery("sql");
		eFactory.createEntityManager().createQuery("");// HQL查询

	}

	// ------------------------------------------------------------------------------
	@Override
	public Dept findDeptByDeptId(Integer id) throws MyException {
		try {
			return deptRepository.findByIdAndState(id, 1);
		} catch (Exception e) {
			throw new MyException(61, "查询部门列表失败");
		}

	}

	// 查询只能用全称查询，like不起作用,使用Containing可以实现
	@Override
	public List<Dept> findDeptByDeptName(String name) throws MyException {
		try {
			return deptRepository.findByNameContainingAndState(name,1);
		} catch (Exception e) {
			throw new MyException(61, "查询部门列表失败");
		}

	}

	// 对于数字类型的查询只能用全称查询，Containing，StartingWith不起作用
	@Override
	public List<Dept> findDeptByDeptType(Integer type) throws MyException {
		EntityManager em = eFactory.createEntityManager();
		Query query = em.createQuery("SELECT d FROM Dept d WHERE d.type LIKE :keyword ORDER BY d.id");
		query.setParameter("keyword", type);
		try {
			return query.getResultList();
		} catch (Exception e) {
			throw new MyException(61, "查询部门列表失败");
		}

	}

	// ------------------------------------------------------------------------------
	@Override
	@Transactional
	public Dept add(Dept dept) throws MyException {
		try {
			return deptRepository.save(dept);
		} catch (Exception e) {
			throw new MyException(13, "添加新部门失败");
		}

	}

	@Override
	@Transactional
	public Dept alter(Dept dept) throws MyException {
		try {
			return deptRepository.save(dept);
		} catch (Exception e) {
			throw new MyException(33, "修改部门失败");
		}

	}

	@Override
	@Transactional
	// 删除部门的时候判断部门下员工是否存在由controller调用empservice查询
	public Dept del(Dept dept) throws MyException {
		dept = deptRepository.findOne(dept.getId());
		List<EmployeeInfo> list = empInfoRepository.findByDeptName(dept.getName());
		if(list.size()>0){
			throw new MyException(51, "删除部门失败");
		}
		dept.setState(-1);
		try {
			return deptRepository.save(dept);
		} catch (Exception e) {
			throw new MyException(51, "删除部门失败");
		}

	}

	@Override
	public Page<Dept> findDeptByDept(Dept dept, Pageable pageable) throws MyException {
		dept.setState(1);
	/*	ExampleMatcher matcher = ExampleMatcher.matching() // 构建对象
				.withStringMatcher(StringMatcher.CONTAINING) // 改变默认字符串匹配方式：模糊查询
				.withIgnoreCase(true);
		// 改变默认大小写忽略方式：忽略大小写
		
		 * .withMatcher("address"(此处写相应对象的属性),
		 * GenericPropertyMatchers.startsWith()) //地址采用“开始匹配”的方式查询
		 * .withIgnorePaths("focus"); //忽略属性：是否关注。因为是基本类型，需要忽略掉
		  Example<Dept> ex = Example.of(dept, matcher);*/
		Page<Dept> page = deptRepository.findByAuto(dept, pageable);
	
		if (null == page.getContent()) {
			throw new MyException(61, "查询部门列表失败");
		}
		return page;
	}

}
