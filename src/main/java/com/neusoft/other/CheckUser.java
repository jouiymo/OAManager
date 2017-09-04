package com.neusoft.other;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.neusoft.domain.ResJson;
import com.neusoft.domain.User;
import com.neusoft.exception.MyException;
import com.neusoft.service.UserService;
import com.neusoft.util.ResJsonUtil;

@Controller
public class CheckUser {

	@Autowired
	private UserService us;
	
	
	
	//用户登录并保存登录状态到session
	@GetMapping(value = "/login")
	public ResJson<User> login(@ModelAttribute User user) throws MyException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		User user2 = us.login(user);
		HttpSession session = request.getSession();
		session.setAttribute("username", user2.getName());
		session.setAttribute("rid", user2.getRid());
		session.setAttribute("path", request.getServletPath());

		return ResJsonUtil.success(user2, "登录成功");

	}

}
