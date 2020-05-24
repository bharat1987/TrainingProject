package com.infosys.msproject.utility;

import java.time.Year;

import java.util.LinkedHashMap;
import java.util.Map;

public class CardExpiryUtility {
	
	public static Map<String,String> getListOfMonths() {
		LinkedHashMap<String,String> monthsList=new LinkedHashMap<String,String>();
		monthsList.put("01", "01");
		monthsList.put("02", "02");
		monthsList.put("03", "03");
		monthsList.put("04", "04");
		monthsList.put("05", "05");
		monthsList.put("06", "06");
		monthsList.put("07", "07");
		monthsList.put("08", "08");
		monthsList.put("09", "09");
		monthsList.put("10", "10");
		monthsList.put("11", "11");
		monthsList.put("12", "12");
		return monthsList;
		
	}
	public static Map<String,String> getListOfYears() {
		LinkedHashMap<String,String> yearsList=new LinkedHashMap<String,String>();
		int year = Year.now().getValue();
		yearsList.put(Integer.toString(year), Integer.toString(year));
		for(int i=1;i<=10;i++) {
			yearsList.put(Integer.toString(year+i), Integer.toString(year+i));
		}
		return yearsList;
	}
}
