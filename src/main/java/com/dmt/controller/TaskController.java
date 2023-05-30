package com.dmt.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.dao.TestDB;
import com.dmt.model.Task;
import com.dmt.model.User;

@org.springframework.stereotype.Controller
public class TaskController {
	@RequestMapping(value = "/add-task", method = RequestMethod.GET)
	public String postPorjectView(@RequestParam("idProject") int idProject,HttpServletRequest request) {
		request.setAttribute("idProject", idProject);
		return "/body/AddTask";
	}
	@RequestMapping(value = "/add-task", method = RequestMethod.POST)
	public String postTask(@RequestParam("task") String task, @RequestParam("userID") int ID_User,
			@RequestParam("idProject") int idProject,
			HttpServletRequest request) {

		TestDB t = new TestDB();
		
		try {
			Task ta = new Task(ID_User, task, 1, idProject, ID_User);
			t.addTask(ta);
			request.setAttribute("checkFlag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/all-task?idProject="+idProject;
	}
	@RequestMapping(value = "/all-task", method = RequestMethod.GET)
	public String getAllProject(@RequestParam("idProject") int idProject,HttpServletRequest request) {
		List<Task> all = new ArrayList<>();
		TestDB t = new TestDB();
		try {
			all = t.getTasksByProjectID(idProject);
			if (all.isEmpty() == false && all != null) {
				request.setAttribute("listTask", all);
			}
			request.setAttribute("idProject",idProject);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "/body/AllTask";
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
			,@RequestParam("ID_Project") int ID_Project,@RequestParam("ID_User") int ID_User ,HttpServletRequest request) {
		TestDB t = new TestDB();
		
		try {
			List<User> listUser = t.getAllUsers();
			request.setAttribute("ID", id);
			request.setAttribute("task", task);
			request.setAttribute("status", status);
			request.setAttribute("ID_Project", ID_Project);
			request.setAttribute("ID_User", ID_User);
			request.setAttribute("listUser", listUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/body/UpdateTask";
	}
}
