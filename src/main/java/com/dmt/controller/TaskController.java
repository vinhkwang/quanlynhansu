package com.dmt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.dao.Constant;
import com.dmt.dao.TestDB;
import com.dmt.model.Task;
import com.dmt.model.User;

@org.springframework.stereotype.Controller
public class TaskController {
	@RequestMapping(value = "/add-task", method = RequestMethod.GET)
	public String postPorjectView(@RequestParam(value="idProject",required = false) Integer idProject,HttpServletRequest request) {
		if(idProject == null) {return "redirect:/login";}
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) 
		{
			int role = (int)session.getAttribute("role");
			if(role == Constant.Admin || role == Constant.PM) 
			{
				TestDB t = new TestDB();
				try {
					List<User> lt = t.getAllUsers();
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
			
			HttpServletRequest request) {
		if(idProject == null) {return "redirect:/login";}
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) 
		{
			int role = (int)session.getAttribute("role");
			if(role == Constant.Admin || role == Constant.PM) 
			{
				TestDB t = new TestDB();
				try {
					Task ta = new Task(ID_User, task, 1, idProject, ID_User);
					ta.setDescription(description);
					ta.setEvidence(evidence);
					t.addTask(ta);
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
								@RequestParam(value = "id", required=false) Integer id,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) 
		{
			int role = (int)session.getAttribute("role");
			List<Task> all = new ArrayList<>();
			TestDB t = new TestDB();
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
					all = t.getTasksByProjectID(idProject);
					if (all.isEmpty() == false && all != null) {
						request.setAttribute("listTask", all);
					}
					request.setAttribute("idProject",idProject);
					request.setAttribute("role",Constant.PM);
				}else 
				{
					int ID = (int) session.getAttribute("ID");
					all = id == null ? t.getTasksByUserID(ID) : t.getTasksByUserID(id);
					if (all.isEmpty() == false && all != null) {
						request.setAttribute("listTask", all);
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
		TestDB t = new TestDB();
		try {
			t.deleteTask(id);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/all-project";
	}
	@RequestMapping(value = "/edit-task", method = RequestMethod.GET)
	public String editProject(@RequestParam("ID") int id,@RequestParam("task") String task, @RequestParam("status") int status
			,@RequestParam("ID_Project") int ID_Project,@RequestParam("ID_User") int ID_User
			,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) 
		{
			int role = (int)session.getAttribute("role");
			System.out.println(role + "role");
			TestDB t = new TestDB();
			try {
				List<User> listUser = t.getUserByRole(3);
				Task tk = t.getTaskByID(id); 
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
	public String edit(@RequestParam("ID") int id,@RequestParam(value="task",required = false) String task, @RequestParam(value="status", required=false) Integer status
			,@RequestParam("ID_Project") int ID_Project,@RequestParam("ID_User") int ID_User
			,@RequestParam("description") String description
			,@RequestParam("evidence") String evidence,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("role") != null) 
		{
			TestDB t = new TestDB();
			String taskName = "";
			try {
				if(task == null ) {
					Task currentTask = t.getTaskByID(id);
					taskName = currentTask.getName();
				}else 
				{
					taskName = task;
				}
				Task p = new Task(id, taskName, status, ID_Project,ID_User);
				p.setDescription(description);
				p.setEvidence(evidence);
				t.updateTask(p);
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
