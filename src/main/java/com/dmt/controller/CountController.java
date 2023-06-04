package com.dmt.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dmt.dao.Constant;
import com.dmt.dao.TestDB;
import com.dmt.model.Contract;

@Controller
public class CountController {
	@RequestMapping(value = "/count", method = RequestMethod.GET)
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
					DecimalFormat decimalFormat = new DecimalFormat("#.00");
			        ;
					int countContract = t.countContract();
					int countTask = t.countTask();
					int countProject = t.countProject();
					String countTask_1 = decimalFormat.format((double)t.countTaskStatus(1)/countTask*100);
					String countTask_2 = decimalFormat.format((double)t.countTaskStatus(2)/countTask*100);
					String countTask_3 = decimalFormat.format( (double)t.countTaskStatus(3)/countTask*100);
					request.setAttribute("countContract", countContract);
					request.setAttribute("countTask", countTask);
					request.setAttribute("countTask_1", countTask_1);
					request.setAttribute("countTask_2", countTask_2);
					request.setAttribute("countTask_3", countTask_3);
					request.setAttribute("countProject", countProject);
					request.setAttribute("role",role);
					return "/Count";
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:/login";
		
	}
}
