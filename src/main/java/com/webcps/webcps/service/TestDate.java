package com.webcps.webcps.service;

import java.util.Calendar;
import java.util.Date;

public class TestDate {

	public static void main(String args[]) {

		Date datein = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(datein);
		Integer year = cal.get(Calendar.YEAR);
		Integer month = cal.get(Calendar.MONTH);
		Integer day = cal.get(Calendar.DAY_OF_MONTH);
		Integer hour = cal.get(Calendar.HOUR_OF_DAY);
		Integer minute = cal.get(Calendar.MINUTE);
		Integer second = cal.get(Calendar.SECOND);

		System.out.println("year " + year);
		System.out.println("month " + (month + 1));
		System.out.println("day " + day);
		
		System.out.println("hour " + hour);
		System.out.println("min " + minute);
		System.out.println("second " + second);
		
		String yy = year.toString();
		
		String substring = yy.substring(Math.max(yy.length() - 2, 0));
		System.out.println(substring);
	}
	
	
}
