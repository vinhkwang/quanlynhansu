package com.dmt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.dao.Constant;
import com.dmt.dao.TestDB;
import com.dmt.model.Contract;
import com.dmt.model.User;

@Controller
public class ContractController {
	@RequestMapping(value = "/all-contract", method = RequestMethod.GET)
	public String getAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int role = (int)session.getAttribute("role");
			if( role == Constant.Admin) 
			{
				List<Contract> all = new ArrayList<>();
				TestDB t = new TestDB();
				try {
					all = t.getAllContracts();
					if (all.isEmpty() == false && all != null) {
						request.setAttribute("listContract", all);
					}
					request.setAttribute("role",role);
					return "/AllContract";
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/login";
		
	}
	@RequestMapping(value = "/add-contract", method = RequestMethod.GET)
	public String add(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int role = (int)session.getAttribute("role");
			if( role == Constant.Admin) 
			{
				List<Contract> all = new ArrayList<>();
				TestDB t = new TestDB();
				try {
					all = t.getAllContracts();
					if (all.isEmpty() == false && all != null) {
						request.setAttribute("listContract", all);
					}
					request.setAttribute("role",role);
					return "/AddContract";
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/login";
		
	}
	@RequestMapping(value = "/add-contract", method = RequestMethod.POST)
	public String add(@RequestParam("contract") String contract, @RequestParam("nameEmployee") String nameEmployee,
			@RequestParam("userName") String userName,@RequestParam("password") String password,@RequestParam("birthday") java.sql.Date birthday,
			@RequestParam("ThoiHan") int ThoiHan ,@RequestParam("role") int role ,HttpServletRequest request) {

		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int roleSession = (int)session.getAttribute("role");
			if( roleSession == Constant.Admin) 
			{
				TestDB t = new TestDB();
				try {
					User u = new User(0, userName, password, nameEmployee, birthday,role,0,true);
					t.addNewUser(u);
					int idUser = t.IsUser(userName).getID();
					Date currentDate = new Date();
			        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
			        System.out.println("Current Date (java.sql.Date): " + sqlDate);
					Contract ct = new Contract(contract, idUser, 0, ThoiHan, sqlDate);
					t.addContract(ct);
					request.setAttribute("checkFlag", 1);
					return "redirect:/all-contract";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "redirect:/login";
		
		
	}
}
