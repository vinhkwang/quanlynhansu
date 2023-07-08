package com.dmt.model;

import java.util.Date;

public class Task {
	 	private int ID;
	    private String name;
		private int status;
	    private int projectID;
	    private int userID;
	    private String assign;
	    private String nameProject;
	    private String description;
	    private String evidence;
	    private java.sql.Date StartDay;
	    private java.sql.Date EndDay;

	    public Task(int ID, String name, int status, int projectID, int userID, java.sql.Date startDay, java.sql.Date endDay) {
	        this.ID = ID;
	        this.name = name;
	        this.status = status;
	        this.projectID = projectID;
	        this.userID = userID;
	        this.StartDay = startDay;
	        this.EndDay = endDay;
	    }
	    public Task(int ID, String name, int status, int projectID, int userID, String assign, java.sql.Date startDay, java.sql.Date endDay) {
	        this.ID = ID;
	        this.name = name;
	        this.status = status;
	        this.projectID = projectID;
	        this.userID = userID;
	        this.assign = assign;
	        this.StartDay = startDay;
	        this.EndDay = endDay;
	    }
	    public Task(int ID, String name, int status, int projectID, int userID, String assign, String nameProject, java.sql.Date startDay, java.sql.Date endDay) {
	        this.ID = ID;
	        this.name = name;
	        this.status = status;
	        this.projectID = projectID;
	        this.userID = userID;
	        this.assign = assign;
	        this.nameProject = nameProject;
	        this.StartDay = startDay;
	        this.EndDay = endDay;
	    }

	    public String getNameProject() {
    		return nameProject;
	    }
	    public String getAssign() {
			return assign;
		}
		public void setAssign(String assign) {
			this.assign = assign;
		}
		public int getID() {
	        return ID;
	    }

	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
			this.name = name;
		}

	    public int getStatus() {
	        return status;
	    }

	    public int getProjectID() {
	        return projectID;
	    }

		public int getUserID() {
			return userID;
		}

		public void setUserID(int userID) {
			this.userID = userID;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public void setProjectID(int projectID) {
			this.projectID = projectID;
		}
		
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getEvidence() {
			return evidence;
		}
		public void setEvidence(String evidence) {
			this.evidence = evidence;
		}
		public java.sql.Date getStartDay() {
			return StartDay;
		}
		public void setStartDay(java.sql.Date startDay) {
			StartDay = startDay;
		}
		public java.sql.Date getEndDay() {
			return EndDay;
		}
		public void setEndDay(java.sql.Date endDay) {
			EndDay = endDay;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public void setNameProject(String nameProject) {
			this.nameProject = nameProject;
		}
		
		
		
	    
}
