package com.dmt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.dao.Constant;
import com.dmt.dao.TestDB;
import com.dmt.model.User;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String postPorjectView(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) {
			switch ((int)session.getAttribute("role")) {
			case Constant.Admin:
				session.setAttribute("role", Constant.Admin);
				return "redirect:/all-project";
			case Constant.PM:
				session.setAttribute("role", Constant.PM);
				return "redirect:/all-task";
			case Constant.Employee:
				session.setAttribute("role", Constant.Employee);
				return "redirect:/all-task";
			default:
				break;
			}
		}
		return "/Login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postTask(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request) {
		TestDB t = new TestDB();
		User u = null;
		try {
			u =  t.CheckLoginUser(username, password);
			if(u != null) {
				HttpSession session = request.getSession();
				session.setAttribute("username", u.getUsername());
				session.setAttribute("ID", u.getID());
				session.setAttribute("role", u.getID_Role());
				session.setAttribute("name", u.getTen());
				System.out.println(u.getID_Role());
				switch (u.getID_Role()) {
				case Constant.Admin:
					return "redirect:/all-project";
				case Constant.PM:
					return "redirect:/all-project";
				case Constant.Employee:
					return "redirect:/all-task";
				default:
					break;
				}
				
			}else {
				request.setAttribute("LoginFail", 1);
				return "/Login";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("role");
		session.removeAttribute("ID");
		session.removeAttribute("name");
		return "/Login";
	}
}
