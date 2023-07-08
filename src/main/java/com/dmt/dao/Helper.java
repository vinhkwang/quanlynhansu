package com.dmt.dao;

import java.util.ArrayList;
import java.util.List;

import com.dmt.model.Contract;
import com.dmt.model.Project;
import com.dmt.model.Task;
import com.dmt.model.User;

public class Helper {
	
	public static String getIdContract(int ID) 
	{
		if(ID < 10) 
		{
			return "HD000" + String.valueOf(ID);
		}if(ID< 100) {
			return "HD00" + String.valueOf(ID);
		}
		return "HD00000";
	}
	public static String StringtoId(String search) {
		String result_search = "";
		try {
			String[] words = search.toLowerCase().split("hd");
			if(words.length == 2) {
				try 
				{
					int sea = Integer.parseInt(words[1]);
					String e = String.valueOf(sea);
					result_search = e;
				}catch (Exception e) {
					// TODO: handle exception
				}
			}else {
				result_search = words[0];
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result_search;
	}
	public static List<User> SearchUserByType(List<User> ls, int type, String search) {
		List<User> lu = new ArrayList<User>();
		for (User user : ls) {
			if(type == 1) {
				if (user.getTen().toLowerCase().contains(search)) {
					lu.add(user);
			    }
			}
			if(type == 2) {
				if (user.getCountProject() == Integer.parseInt(search)) {
					lu.add(user);
			    }
			}
			if(type == 3) {
				if (user.getCountTask() == Integer.parseInt(search)) {
					lu.add(user);
			    }
			}
		}
		return lu;
	}
	public static List<Project> SearchProjectByType(List<Project> ls, int type, String search) {
		List<Project> lu = new ArrayList<Project>();
		for (Project user : ls) {
			if(type == 1) {
				if (user.getName().toLowerCase().contains(search.toLowerCase())) {
					lu.add(user);
			    }
			}
			if(type == 2) {
				int coutMem = -1;
				try {
					coutMem = Integer.parseInt(search);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (user.getCountMember() == coutMem) {
					lu.add(user);
			    }
			}
		}
		return lu;
	}
	public static List<Task> SearchTaskSearch(List<Task> ls, int status, String search) {
		List<Task> lu = new ArrayList<Task>();
		if(search != null) {
			for (Task task  : ls) {
				if (task.getName().toLowerCase().contains(search.toLowerCase())) {
					lu.add(task);
				}
		}
		}else {
			lu = ls;
		}
		List<Task> rt = new ArrayList<Task>();
		if(status != -1 ) {
			for (Task task  : lu) {
				if (task.getStatus() == status) {
					rt.add(task);
				}
			}
		}else {
			rt = lu;
		}
		return rt;
	}
	public static List<Contract> SearchContactByType(List<Contract> ls, int type, String search) {
		List<Contract> lu = new ArrayList<Contract>();
		for (Contract user : ls) {
			if(type == 1) {
				if (user.getIDContract().toLowerCase().contains(search.toLowerCase())) {
					lu.add(user);
			    }
			}
			if(type == 2) {
				if (user.getName().toLowerCase().contains(search.toLowerCase())) {
					lu.add(user);
			    }
			}
			if(type == 3) {
				int thoiHan = -1;
				try {
					thoiHan = Integer.parseInt(search);
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (user.getThoiHan() == thoiHan) {
					lu.add(user);
			    }
			}
		}
		return lu;
	}

}
