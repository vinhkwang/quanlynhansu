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

}
