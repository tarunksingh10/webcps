package com.webcps.webcps.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {


	public static void main  (String args[]){
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String s=dateFormat.format(date);
		System.out.println(s); //2016/11/16 12:08:43
		
		String ns= s.substring(s.length()-8);
		
		System.out.println(ns);
		
		//String 
	}
}
