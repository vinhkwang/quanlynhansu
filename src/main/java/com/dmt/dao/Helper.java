package com.dmt.dao;

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

}
