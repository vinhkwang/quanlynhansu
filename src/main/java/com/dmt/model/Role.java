package com.dmt.model;

public class Role {
		private int ID;
		private String Name;
		public Role() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Role(int iD, String name) {
			super();
			ID = iD;
			Name = name;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		
}
