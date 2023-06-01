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
import com.dmt.dao.TestDB;
import com.dmt.model.Project;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping(value = "/add-project", method = RequestMethod.GET)
	public String postPorjectView() {
		
		return "/body/AddProject";
	}
	@RequestMapping(value = "/add-project", method = RequestMethod.POST)
	public String postProject(@RequestParam("project") String project, @RequestParam("startday") Date startDay,
			@RequestParam("enddate") Date endDate,
			HttpServletRequest request) {

		TestDB t = new TestDB();
		
		try {
			Project p = new Project(0, project, startDay, endDate);
			t.addProject(p);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/all-project";
	}
	@RequestMapping(value = "/all-project", method = RequestMethod.GET)
	public String getAllProject(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role")!= null) 
		{
			if((int)session.getAttribute("role") == Constant.Admin) 
			{
				List<Project> all = new ArrayList<>();
				TestDB t = new TestDB();
				try {
					all = t.getAllProjects();
					if (all.isEmpty() == false && all != null) {
						request.setAttribute("listProject", all);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return "/body/AllProject";
			}
		}
		
		return "redirect:/login";
		
	}
	@RequestMapping(value = "/edit-project", method = RequestMethod.GET)
	public String editProject(@RequestParam("ID") int id,@RequestParam("name") String name, @RequestParam("startDate") Date startDate
			,@RequestParam("endDate") Date endDate,HttpServletRequest request) {
		request.setAttribute("ID", id);
		request.setAttribute("name", name);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		return "/body/UpdateProject";
	}
	
	@RequestMapping(value = "/edit-project", method = RequestMethod.POST)
	public String editProjectPost(@RequestParam("ID") int id,@RequestParam("name") String name, @RequestParam("startDate") Date startDate
			,@RequestParam("endDate") Date endDate,HttpServletRequest request) {
		TestDB t = new TestDB();
		
		try {
			Project p = new Project(id, name, startDate, endDate);
			t.updateProject(p);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/all-project";
	}
	@RequestMapping(value = "/delete-project", method = RequestMethod.GET)
	public String deleteProject(@RequestParam("ID") int id,HttpServletRequest request) {
		TestDB t = new TestDB();
		
		try {
			t.deleteProject(id);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/all-project";
	}
	
}
