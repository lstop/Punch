package com.liufei.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liufei.pojo.User;
import com.liufei.service.UsersService;

@Controller
public class UserController {
	@Autowired(required=false)
	private UsersService usersService;
	@ModelAttribute
	private void aaa(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
	}
	
	@RequestMapping(path="/login",method = RequestMethod.POST)
	public String login(User user,HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(new UsernamePasswordToken(user.getUsername(), user.getPwd()));
			List<User> users = usersService.selectByUnameAndUpassword(user);
			session.setAttribute("user", users.get(0));
			return "redirect:showlist";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", "登陆失败:用户名或密码错误");
			return "redirect:error.jsp";
			// TODO: handle exception
		}
	}
	@RequestMapping("/he")
	public void hrllo() {
	}
}
