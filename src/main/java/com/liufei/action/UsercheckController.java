package com.liufei.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liufei.pojo.User;
import com.liufei.pojo.Usercheck;
import com.liufei.service.UsercheckService;

@Controller
public class UsercheckController {
	@Autowired(required=false)
	private UsercheckService usercheckService;
	
	private int pages = 1;
	@ModelAttribute
	private void aaa(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
	}
	@RequestMapping("/check")
	public String check(HttpServletRequest request,HttpSession session) {
		Usercheck usercheck = new Usercheck();
		String username = request.getParameter("username");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		int hour=cal.get(Calendar.HOUR_OF_DAY);//小时
		String status = hour<9?"正常打卡":"迟到";
		usercheck.setUname(username);
		usercheck.setChecktime(format.format(new Date()));
		usercheck.setStatus(status);
		
		if(usercheckService.insertSelective(usercheck)>0) {
			return "redirect:showlist";
		} else {
			session.setAttribute("msg", "打卡失败");
			return "redirect:error.jsp";
		}
	}
	@RequestMapping("/showlist")
	public String showlist(Map<String, Object> map,HttpSession session,HttpServletRequest request) {
		int page = request.getParameter("page")==null?1:new Integer(request.getParameter("page"));
		int perpage = 10;
		User user = (User) session.getAttribute("user");
		
		List<Usercheck> userchecks = new ArrayList<>();
		int size=0;
		if(pages!=1) page=pages;
		if("3".equals(user.getLevel())) {
			userchecks = usercheckService.selectByNameAndPage(user.getUsername(), (page-1)*perpage, perpage);
			size = (usercheckService.selectByName(user.getUsername()).size()+perpage-1)/perpage;
		} else {
			userchecks = usercheckService.selectByPage((page-1)*perpage, perpage);
			size = (usercheckService.selectAll().size()+perpage-1)/perpage;
		}
		map.put("userchecks", userchecks);
		map.put("pagehide", page);
		map.put("perpagehide", perpage);
		map.put("sizehide",size);
		pages = 1;
		return "main";
	}
	@RequestMapping("/searchlist")
	public String searchlist(Map<String, Object> map,HttpServletRequest request) {
		String name = request.getParameter("search");
		int page = request.getParameter("page")==null?1:new Integer(request.getParameter("page"));
		if(name == null || "".equals(name)) {
			pages = page;
			return "redirect:showlist";
		}
		else {
			String likename = new StringBuilder("%").append(name).append("%").toString();
			int perpage = 10;
			List<Usercheck> userchecks = usercheckService.selectByNamesAndPage(likename, (page-1)*perpage, perpage);
			map.put("userchecks", userchecks);
			map.put("pagehide", page);
			map.put("perpagehide", perpage);
			map.put("search", name);
			map.put("sizehide",(usercheckService.selectByNames(likename).size()+perpage-1)/perpage);
			pages = 1;
			return "main";
		}
		
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,HttpSession session) {
		String id = request.getParameter("delid");
		String level = request.getParameter("level");
		if("1".equals(level)) {
			usercheckService.deleteByPrimaryKey(new Integer(id));
			return "redirect:showlist";
		}
		else {
			session.setAttribute("msg", "没有权限");
			return "redirect:error.jsp";
		}
		
	}
}
