package com.dmt.model;

public class Task {
	 	private int ID;
	    private String name;
		private int status;
	    private int projectID;
	    private int userID;
	    private String assign;
	    private String nameProject;

	    public Task(int ID, String name, int status, int projectID, int userID) {
	        this.ID = ID;
	        this.name = name;
	        this.status = status;
	        this.projectID = projectID;
	        this.userID = userID;
	    }
	    public Task(int ID, String name, int status, int projectID, int userID, String assign) {
	        this.ID = ID;
	        this.name = name;
	        this.status = status;
	        this.projectID = projectID;
	        this.userID = userID;
	        this.assign = assign;
	    }
	    public Task(int ID, String name, int status, int projectID, int userID, String assign, String nameProject) {
	        this.ID = ID;
	        this.name = name;
	        this.status = status;
	        this.projectID = projectID;
	        this.userID = userID;
	        this.assign = assign;
	        this.nameProject = nameProject;
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
	    
}
