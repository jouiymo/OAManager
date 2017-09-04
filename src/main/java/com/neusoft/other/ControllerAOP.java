package com.neusoft.other;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.neusoft.domain.Privilege;
import com.neusoft.domain.ResJson;
import com.neusoft.domain.Role;
import com.neusoft.exception.MyException;
import com.neusoft.service.PrivilegeService;
import com.neusoft.service.RoleService;
import com.neusoft.util.ResJsonUtil;

/**
 * 控制器切面
 * 
 * @author sky
 *
 */
@Aspect
@Component
public class ControllerAOP {

	@Autowired
	private RoleService rs;
	@Autowired
	private PrivilegeService ps;

	@Pointcut("execution(* com.neusoft.controller.*.**(..))")
	public void aceptMethod() {
	}

	@Before("aceptMethod()")
	public ResJson doCheckLogin() throws MyException {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		HttpSession session = request.getSession();
		// 用户没有登录，前台接收此错误请直接跳转到登录界面
		if (session == null) {
			return ResJsonUtil.error(99, "用户未登录");
		}

		String username = (String) session.getAttribute("username");
		// 用户登录出错，前台接收此错误请直接跳转到登录界面
		if (username == null || username == "") {
			return ResJsonUtil.error(98, "用户登录失败");
		}

		Integer roleId = (Integer) session.getAttribute("rid");
		String path = (String) session.getAttribute("path");
		// 用户的登录信息没有保存在session，前台接收此错误请跳转到登录界面
		if (null == path || "" == path) {
			return ResJsonUtil.error(97, "获取用户信息失败");
		}
		Role role = new Role();
		role.setId(roleId);
		Role frole = rs.findByRoleId(roleId);
		List<Integer> pId = frole.getPrivilegeId();
		List<Privilege> privileges = new ArrayList<Privilege>();
		for (int i = 0; i < pId.size(); i++) {
			privileges.add(ps.findByPId(pId.get(i)));
		}

		// 用户没有权限访问，前台接收此错误请直接跳转到无权访问页面
		if (privileges.size() == 0) {
			return ResJsonUtil.error(97, "该用户无权访问");

		}
		Boolean flag = false;
		for (int i = 0; i < privileges.size(); i++) {
			for (int j = 0; j < privileges.get(i).getPath().size(); j++) {
				if (path == privileges.get(i).getPath().get(j)) {
					flag = true;
				}
			}

		}
		if (flag == false) {
			// 用户没有权限访问，前台接收此错误请直接跳转到无权访问页面
			return ResJsonUtil.error(97, "该用户无权访问");
		}

		return null;

	}
}
