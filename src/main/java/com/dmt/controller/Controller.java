package com.dmt.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.dao.Constant;
import com.dmt.dao.Helper;
import com.dmt.dao.TestDB;
import com.dmt.model.Contract;
import com.dmt.model.Project;
import com.dmt.model.User;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping(value = "/add-project", method = RequestMethod.GET)
	public String postPorjectView(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int roleSession = (int)session.getAttribute("role");
			if( roleSession == Constant.Admin || roleSession == Constant.PM) 
			{
				try {
					request.setAttribute("PM", TestDB.getAllUsers(2));
					request.setAttribute("role", roleSession);
					return "/AddProject";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "redirect:/login";
	}
	@RequestMapping(value = "/add-project", method = RequestMethod.POST)
	public String postProject(@RequestParam("project") String project, 
			@RequestParam("ID_PM") int ID_PM,
			@RequestParam("startday") Date startDay,
			@RequestParam("enddate") Date endDate,
			@RequestParam("description") String description,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int roleSession = (int)session.getAttribute("role");
			if( roleSession == Constant.Admin || roleSession == Constant.PM) 
			{
				
				try {
					Project p = new Project(0, project, startDay, endDate, ID_PM,description);
					TestDB.addProject(p);
					request.setAttribute("checkFlag", 1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "redirect:/all-project";
			}
		}
		return "redirect:/login";
	}
	@RequestMapping(value = "/all-project", method = RequestMethod.GET)
	public String getAllProject(
			@RequestParam(value="id",required = false) Integer id, 
			@RequestParam(value="search",required = false) String search,
			@RequestParam(value="type",required = false) Integer type,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int roleSession = (int)session.getAttribute("role");
			if(roleSession == Constant.Admin || roleSession == Constant.PM) 
			{
				List<Project> all = new ArrayList<>();
				try {
					all = id == null ? TestDB.getAllProjects() : TestDB.getAllProjectsByUserId(id);
					if(type != null && search != null && search != "") {
						all = Helper.SearchProjectByType(all, type, search);
					}
					if(roleSession == Constant.PM) 
					{
						int id_pm = (int)session.getAttribute("ID");
						System.out.println(id_pm + "Hello ID PM");
						all = TestDB.getAllProjectsByPMId(id_pm);
					}
					if (all.isEmpty() == false && all != null) {
						request.setAttribute("listProject", all);
						request.setAttribute("role", roleSession);
					}
					request.setAttribute("type",type);
					request.setAttribute("search",search);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return "/AllProject";
			}
		}
		
		return "redirect:/login";
		
	}
	@RequestMapping(value = "/edit-project", method = RequestMethod.GET)
	public String editProject(@RequestParam("ID") int id,
			@RequestParam("name") String name, 
			@RequestParam("description") String description, 
			@RequestParam("ID_PM") int ID_PM, 
			@RequestParam("startDate") Date startDate
			,@RequestParam("endDate") Date endDate,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int roleSession = (int)session.getAttribute("role");
			if( roleSession == Constant.Admin || roleSession == Constant.PM) 
			{
				try {

					request.setAttribute("PM", TestDB.getAllUsers(2));
					request.setAttribute("ID_PM", ID_PM);
					request.setAttribute("ID", id);
					request.setAttribute("name", name);
					request.setAttribute("startDate", startDate);
					request.setAttribute("endDate", endDate);
					request.setAttribute("role", roleSession);
					request.setAttribute("description", description);
					return "/UpdateProject";
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/edit-project", method = RequestMethod.POST)
	public String editProjectPost(@RequestParam("ID") int id,
			@RequestParam("ID_PM") int ID_PM,
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("startDate") Date startDate
			,@RequestParam("endDate") Date endDate,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int roleSession = (int)session.getAttribute("role");
			if( roleSession == Constant.Admin || roleSession == Constant.PM) 
			{
				
				try {

					Project p = new Project(id, name, startDate, endDate, ID_PM,description);
					TestDB.updateProject(p);
					request.setAttribute("checkFlag", 1);
					request.setAttribute("role", roleSession);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "redirect:/all-project";
			}
		}
		return "redirect:/login";
	}
	@RequestMapping(value = "/delete-project", method = RequestMethod.GET)
	public String deleteProject(@RequestParam("ID") int id,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			int roleSession = (int)session.getAttribute("role");
			if( roleSession == Constant.Admin || roleSession == Constant.PM) 
			{
				
				try {
					TestDB.deleteProject(id);
					request.setAttribute("checkFlag", 1);
					request.setAttribute("role", roleSession);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "redirect:/all-project";
			}
		}
		return "redirect:/login";
	}
	
}
