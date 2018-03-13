package com.webcps.webcps.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {


	public static void main  (String args[]){
		
		 char l3_str='c';
		 String str1="c";
		 
		 System.out.println(str1.equals(String.valueOf(l3_str)));
		
		int value = 54;
		char digit = (char) value;
		System.out.println("The ASCII representation of " + value + " is ->" + digit + "<-"); 
		
		
		Double d1= 1+Math.floor(2/10)+48;
		System.out.println(d1);
		System.out.println(d1.intValue());
		
		
		
		String information="2018-03-08";
		
		System.out.println(information.substring(8,10));
		
		
	/*	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String s=dateFormat.format(date);
		System.out.println(s); //2016/11/16 12:08:43
		
		String ns= s.substring(s.length()-8);
		
		System.out.println(ns);*/
		
		//String 
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(cal.getTime());
		// Output "Wed Sep 26 14:23:28 EST 2012"

		String formatted = format1.format(cal.getTime());
		System.out.println(formatted);
		
		try {
		Date d=	format1.parse(formatted);
		System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Output "2012-09-26"

		/*try {
			System.out.println(format1.parse(formatted));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
