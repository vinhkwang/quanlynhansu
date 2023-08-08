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
import com.dmt.model.Task;
import com.dmt.model.User;

@org.springframework.stereotype.Controller
public class TaskController {
	@RequestMapping(value = "/add-task", method = RequestMethod.GET)
	public String postPorjectView(
			@RequestParam(value="idProject",required = false) Integer idProject,
			HttpServletRequest request) {
		if(idProject == null) {return "redirect:/login";}
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) 
		{
			int role = (int)session.getAttribute("role");
			if(role == Constant.Admin || role == Constant.PM) 
			{
				try {
					List<User> lt = TestDB.getAllUsers(3);
					request.setAttribute("listUser", lt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("idProject", idProject);
				return "/AddTask";
			}
		}
		return "redirect:/login";
	}
	@RequestMapping(value = "/add-task", method = RequestMethod.POST)
	public String postTask(@RequestParam("task") String task, @RequestParam("userID") int ID_User,
			@RequestParam(value="idProject",required = false) Integer idProject,
			@RequestParam(value="description",required = false) String description,
			@RequestParam(value="evidence",required = false) String evidence,
			@RequestParam(value="startDay",required = false) Date startDay,
			@RequestParam(value="endDay",required = false) Date endDay,
			
			HttpServletRequest request) {
		if(idProject == null) {return "redirect:/login";}
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) 
		{
			int role = (int)session.getAttribute("role");
			if(role == Constant.Admin || role == Constant.PM) 
			{
				try {
					Task ta = new Task(ID_User, task, 1, idProject, ID_User, startDay, endDay);
					ta.setDescription(description);
					ta.setEvidence(evidence);
					TestDB.addTask(ta);
					request.setAttribute("checkFlag", 1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "redirect:/all-task?idProject="+idProject;
			}
		}
		return "redirect:/login";
	}
	@RequestMapping(value = "/all-task", method = RequestMethod.GET)
	public String getAllProject(@RequestParam(value = "idProject", required=false) Integer idProject,
								@RequestParam(value = "id", required=false) Integer id,
								@RequestParam(value="search",required = false) String search,
								@RequestParam(value="status",required = false) Integer status,
								HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) 
		{
			int role = (int)session.getAttribute("role");
			List<Task> all = new ArrayList<>();
			try {
				if(idProject != null && role == 3 && id == null) 
				{
					return "redirect:/all-task";
				}
				if(idProject == null && (role == 1 || role == 2) && id == null) 
				{
					return "redirect:/all-project";
				}
				if(idProject != null && (role == 1 || role == 2)) 
				{
					all = TestDB.getTasksByProjectID(idProject);
					if (all.isEmpty() == false && all != null) {
						all = Helper.SearchTaskSearch(all, status != null ? status : -1, search);
						request.setAttribute("listTask", all);
						request.setAttribute("status",status);
						request.setAttribute("search",search);
					}
					request.setAttribute("idProject",idProject);
					request.setAttribute("role",Constant.PM);
				}else 
				{
					int ID = (int) session.getAttribute("ID");
					all = id == null ? TestDB.getTasksByUserID(ID) : TestDB.getTasksByUserID(id);
					if (all.isEmpty() == false && all != null) {
						all = Helper.SearchTaskSearch(all, status != null ? status : -1, search);
						request.setAttribute("listTask", all);
						request.setAttribute("status",status);
						request.setAttribute("search",search);
					}
					request.setAttribute("role",Constant.Employee);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return "/AllTask";
		}
		
		return "redirect:/login";
	}
	@RequestMapping(value = "/delete-task", method = RequestMethod.GET)
	public String delete(@RequestParam("ID") int id,HttpServletRequest request) {
		try {
			TestDB.deleteTask(id);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/all-project";
	}
	@RequestMapping(value = "/edit-task", method = RequestMethod.GET)
	public String editProject(
			@RequestParam("ID") int id,
			@RequestParam("task") String task, @RequestParam("status") int status,
			@RequestParam("ID_Project") int ID_Project,
			@RequestParam("ID_User") int ID_User,
			@RequestParam(value="startDay",required = false) Date startDay,
			@RequestParam(value="endDay",required = false) Date endDate
			,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) 
		{
			int role = (int)session.getAttribute("role");
			System.out.println(role + "role");
			try {
				List<User> listUser = TestDB.getUserByRole(3);
				Task tk = TestDB.getTaskByID(id);
				request.setAttribute("ID", id);
				request.setAttribute("task", task);
				request.setAttribute("status", status);
				request.setAttribute("ID_Project", ID_Project);
				request.setAttribute("ID_User", ID_User);
				request.setAttribute("listUser", listUser);
				System.out.println(tk.getDescription() + "0000");
				request.setAttribute("description", tk.getDescription());
				request.setAttribute("evidence", tk.getEvidence());
				request.setAttribute("role", role);
				request.setAttribute("startDay", startDay);
				request.setAttribute("endDay", endDate);
				System.out.println(listUser.size());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "/UpdateTask";
		}
		return "redirect:/login";
	}
	@RequestMapping(value = "/edit-task", method = RequestMethod.POST)
	public String edit(@RequestParam("ID") int id,@RequestParam(value="task",required = false) String task, 
			@RequestParam(value="status", required=false) Integer status
			,@RequestParam("ID_Project") int ID_Project,@RequestParam("ID_User") int ID_User
			,@RequestParam(value = "description", required=false) String description
			,@RequestParam("evidence") String evidence,
			@RequestParam(value="startDay",required = false) Date startday,
			@RequestParam(value="endDay",required = false) Date endDay,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) 
		{
			String taskName = "";
			try {
				if(task == null ) {
					Task currentTask = TestDB.getTaskByID(id);
					taskName = currentTask.getName();
				}else 
				{
					taskName = task;
				}
				Task p = new Task(id, taskName, status, ID_Project,ID_User,startday,endDay);
				p.setDescription(description);
				p.setEvidence(evidence);
				TestDB.updateTask(p);
				request.setAttribute("checkFlag", 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/all-task?idProject="+ID_Project;
		}
		return "redirect:/login";
	}
}
