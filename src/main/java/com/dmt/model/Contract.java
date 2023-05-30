package com.dmt.model;

import java.sql.Date;

public class Contract {
	private int ID;
	private String Name;
	private int ID_Mem;
	private int ID_CEO;
	private int ThoiHan;
	private Date NgayKy;
	private String NameEmployee;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public String getNameEmployee() {
		return NameEmployee;
	}
	public void setNameEmployee(String nameEmployee) {
		NameEmployee = nameEmployee;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getID_Mem() {
		return ID_Mem;
	}
	public void setID_Mem(int iD_Mem) {
		ID_Mem = iD_Mem;
	}
	public int getID_CEO() {
		return ID_CEO;
	}
	public void setID_CEO(int iD_CEO) {
		ID_CEO = iD_CEO;
	}
	public int getThoiHan() {
		return ThoiHan;
	}
	public void setThoiHan(int thoiHan) {
		ThoiHan = thoiHan;
	}
	public Date getNgayKy() {
		return NgayKy;
	}
	public void setNgayKy(Date ngayKy) {
		NgayKy = ngayKy;
	}
	public Contract(String name, int iD_Mem, int iD_CEO, int thoiHan, Date ngayKy) {
		super();
		Name = name;
		ID_Mem = iD_Mem;
		ID_CEO = iD_CEO;
		ThoiHan = thoiHan;
		NgayKy = ngayKy;
	}
	
	public Contract(int iD, String name, int iD_Mem, int iD_CEO, int thoiHan, Date ngayKy) {
		super();
		ID = iD;
		Name = name;
		ID_Mem = iD_Mem;
		ID_CEO = iD_CEO;
		ThoiHan = thoiHan;
		NgayKy = ngayKy;
	}
	public Contract(int iD, String name, int iD_Mem, int iD_CEO, int thoiHan, Date ngayKy, String nameEmployee) {
		super();
		ID = iD;
		Name = name;
		ID_Mem = iD_Mem;
		ID_CEO = iD_CEO;
		ThoiHan = thoiHan;
		NgayKy = ngayKy;
		NameEmployee = nameEmployee;
	}
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
