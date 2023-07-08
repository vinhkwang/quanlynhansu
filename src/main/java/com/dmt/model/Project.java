package com.dmt.model;

import java.sql.Date;

public class Project {
	private int ID;
    private String name;
    private Date startDate;
    private Date endDate;
    private int ID_PM;
    private String Description;
    private String NamePM;
    private int CountMember;

    public Project(int CountMember) {
        this.CountMember = CountMember;
    }
    public Project(String NamePM) {
        this.NamePM = NamePM;
    }
    public Project(int ID, String name, Date startDate, Date endDate, int ID_PM, String description) {
        this.ID = ID;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ID_PM = ID_PM;
        this.Description = description;
    }
    public Project(int ID, String name, Date startDate, Date endDate, int ID_PM, String description, int countMember, String namePM) {
        this.ID = ID;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ID_PM = ID_PM;
        this.Description = description;
        this.CountMember = countMember;
        this.NamePM = namePM;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

	public int getID_PM() {
		return ID_PM;
	}

	public void setID_PM(int iD_PM) {
		ID_PM = iD_PM;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getNamePM() {
		return NamePM;
	}
	public void setNamePM(String namePM) {
		NamePM = namePM;
	}
	public int getCountMember() {
		return CountMember;
	}
	public void setCountMember(int countMember) {
		CountMember = countMember;
	}
    
	
	
    
}
