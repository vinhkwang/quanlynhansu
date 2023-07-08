package com.dmt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.util.CtSym;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.dao.Constant;
import com.dmt.dao.Helper;
import com.dmt.dao.TestDB;
import com.dmt.model.Contract;
import com.dmt.model.User;

@Controller
public class UserController {
	@RequestMapping(value = "/all-member", method = RequestMethod.GET)
	public String getAll( @RequestParam(value = "idProject", required=false) Integer idProject,
						  @RequestParam(value = "search", required=false) String search,
						  @RequestParam(value = "type", required=false) Integer type, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int role = (int)session.getAttribute("role");
			if( role == Constant.Admin || role == Constant.PM) 
			{
				List<User> all = new ArrayList<>();
				
				TestDB t = new TestDB();
				try {
					all = idProject == null ? t.getAllUsers(3): t.getUserByIDProject(idProject);
					if(type != null && search != null) {
						all = Helper.SearchUserByType(all, type, search);
					}
					if (all.isEmpty() == false && all != null) {
						request.setAttribute("listUser", all);
					}
					if(idProject != null) request.setAttribute("idProject", idProject);
					request.setAttribute("search", search);
					request.setAttribute("type", type);
					request.setAttribute("role",role);
					return "/AllUser";
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/login";
		
	}
	@RequestMapping(value = "/detail-member", method = RequestMethod.GET)
	public String detail( @RequestParam(value = "id", required=false) Integer id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			if(id == null) return "redirect:/login";
			int role = (int)session.getAttribute("role");
			if( role == Constant.Admin || role == Constant.PM) 
			{
				TestDB t = new TestDB();
				
				
				try {
					Contract c = t.getContractUserID(id);
					User u = t.getUserByID(id);
					request.setAttribute("u",u);
					request.setAttribute("ct",c);
					request.setAttribute("user",id);
					System.out.println(c.getName() + " -- " + c.getIDContract()+ "---" + u.getID());
					
					request.setAttribute("role",role);
					return "/DetailUser";
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/login";
		
	}
}
