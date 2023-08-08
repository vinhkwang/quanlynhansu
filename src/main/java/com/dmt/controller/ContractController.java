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
import com.dmt.dao.Helper;
import com.dmt.dao.TestDB;
import com.dmt.model.Contract;
import com.dmt.model.User;

@Controller
public class ContractController {
	@RequestMapping(value = "/all-contract", method = RequestMethod.GET)
	public String getAll(
			@RequestParam(value="search",required = false) String search,
			@RequestParam(value="type",required = false) Integer type,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int role = (int)session.getAttribute("role");
			if( role == Constant.Admin) 
			{
				List<Contract> all = new ArrayList<>();
				try {
					all =  TestDB.getAllContracts();
					if(search != null && type != -1 && type != null && search != "") 
					{
						all = Helper.SearchContactByType(all, type, search);
					}
					if (all.isEmpty() == false && all != null) {
						
						request.setAttribute("search",search);
					}
					request.setAttribute("listContract", all);
					request.setAttribute("type",type);
					request.setAttribute("role",role);
					return "/AllContract";
				}
				catch (Exception e) {
					System.out.println("Loi");
					e.printStackTrace();
				}
			}
		}
		return "redirect:/login";
		
	}
	@RequestMapping(value = "/edit-contract", method = RequestMethod.GET)
	public String edit(@RequestParam("ID") int ID,
					   @RequestParam(value = "type", required=false) Integer type, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int role = (int)session.getAttribute("role");
			
			if( role == Constant.Admin) 
			{
				try {
					
					Contract ct = TestDB.getContractByID(ID);
					User u = TestDB.getUserByID(ct.getID_Mem());
					request.setAttribute("ct", ct);
					request.setAttribute("u", u);
					if(type != null && type == 1) 
					{
						request.setAttribute("onlyview", 1);
					}
					
					return "/UpdateContract";
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/login";
		
	}
	@RequestMapping(value = "/edit-contract", method = RequestMethod.POST)
	public String edit_post(
			@RequestParam("ID") int ID,
			@RequestParam("NameContract") String NameContract,
			@RequestParam("NameEm") String NameEm,
			@RequestParam("role") int role_input,
			@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam("birthday") java.sql.Date birthday,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int role = (int)session.getAttribute("role");
			
			if( role == Constant.Admin) 
			{
				try {
					
					User u = TestDB.getUserByID(ID);
					u.setID_Role(role_input);
					u.setTen(NameEm);
					u.setPass(password);
					u.setTuoi(birthday);
					u.setUsername(userName);
					Contract ct = TestDB.getContractByID(ID);
					ct.setName(NameContract);
					TestDB.updateContract(ct);
					TestDB.updateUser(u);
					return "redirect:/edit-contract?ID="+ID;
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
				try {
					all = TestDB.getAllContracts();
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
				try {
					User u = new User(0, userName, password, nameEmployee, birthday,role,0,true);
					TestDB.addNewUser(u);
					int idUser = TestDB.IsUser(userName).getID();
					Date currentDate = new Date();
			        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
			        System.out.println("Current Date (java.sql.Date): " + sqlDate);
					Contract ct = new Contract(contract, idUser, 0, ThoiHan, sqlDate);
					TestDB.addContract(ct);
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
