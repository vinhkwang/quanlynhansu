package com.dmt.model;

import java.sql.Date;

public class Project {
	private int ID;
    private String name;
    private Date startDate;
    private Date endDate;

    public Project(int ID, String name, Date startDate, Date endDate) {
        this.ID = ID;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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
}
