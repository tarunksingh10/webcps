package com.webcps.webcps.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.webcps.webcps.model.TrTiTransin;

public class BarCodeDecoding {

	public static void main(String args[]) {

		BarCodeDecoding barCodeDecoding = new BarCodeDecoding();
		String barcode = barCodeDecoding
				.getVehicleInTimeFromBarcode("81A5M0117GADQBB882");
		System.out.println(barcode);

		Map<String, String> monthMap = new HashMap<String, String>();
		monthMap.put("B", "JAN");
		monthMap.put("C", "FEB");
		monthMap.put("D", "MAR");
		monthMap.put("E", "APR");
		monthMap.put("F", "MAY");
		monthMap.put("G", "JUN");
		monthMap.put("H", "JUL");
		monthMap.put("I", "AUG");
		monthMap.put("J", "SEP");
		monthMap.put("K", "OCT");
		monthMap.put("L", "NOV");
		monthMap.put("M", "DEC");

		Map<String, String> monthMap1 = new HashMap<String, String>();
		monthMap1.put("JAN", "01");
		monthMap1.put("FEB", "02");
		monthMap1.put("MAR", "03");
		monthMap1.put("APR", "04");
		monthMap1.put("MAY", "05");
		monthMap1.put("JUN", "06");
		monthMap1.put("JUL", "07");
		monthMap1.put("AUG", "08");
		monthMap1.put("SEP", "09");
		monthMap1.put("OCT", "10");
		monthMap1.put("NOV", "11");
		monthMap1.put("DEC", "12");

		Map<String, String> datearray = new HashMap<String, String>();
		datearray.put("A", "0");
		datearray.put("B", "1");
		datearray.put("C", "2");
		datearray.put("D", "3");
		datearray.put("E", "4");
		datearray.put("F", "5");
		datearray.put("G", "6");
		datearray.put("H", "7");
		datearray.put("I", "8");
		datearray.put("J", "9");

		Map<String, String> hourArray = new HashMap<String, String>();
		hourArray.put("A", "0");
		hourArray.put("B", "1");
		hourArray.put("C", "2");
		hourArray.put("D", "3");
		hourArray.put("E", "4");
		hourArray.put("F", "5");
		hourArray.put("G", "6");
		hourArray.put("H", "7");
		hourArray.put("I", "8");
		hourArray.put("J", "9");
		hourArray.put("K", "10");
		hourArray.put("L", "11");
		hourArray.put("M", "12");
		hourArray.put("N", "13");
		hourArray.put("O", "14");
		hourArray.put("P", "15");
		hourArray.put("Q", "16");
		hourArray.put("R", "17");
		hourArray.put("S", "18");
		hourArray.put("T", "19");
		hourArray.put("U", "20");
		hourArray.put("V", "21");
		hourArray.put("W", "22");
		hourArray.put("X", "23");

		Map<String, String> minutearray = new HashMap<String, String>();
		minutearray.put("A", "0");
		minutearray.put("B", "1");
		minutearray.put("C", "2");
		minutearray.put("D", "3");
		minutearray.put("E", "4");
		minutearray.put("F", "5");
		minutearray.put("G", "6");
		minutearray.put("H", "7");
		minutearray.put("I", "8");
		minutearray.put("J", "9");

		
		
		
		
		String barcod1e = "81A5M0117GADQBB882";

		// Gate Id
		String gateId = barcod1e.substring(4, 7);

		// year 
		String year = barcod1e.substring(7, 9);

		// Year prefix
		String yearPrefix = String.valueOf(Calendar.getInstance().get(
				Calendar.YEAR));

		// get year prefix from calcer like year
		year = yearPrefix.substring(0, 2) + year;

		// month code
		String monthval = String.valueOf(barcode.charAt(9));
		// Month code value like JAN , FEB
		monthval = monthMap.get(monthval);
		// Month code number 
		monthval = monthMap1.get(monthval);

		// From bar code get 11 and 12 char and get value from map
		String dateval = datearray.get(barcod1e.substring(10, 11))
				+ datearray.get(barcod1e.substring(11, 12));

		// get 13 char and calculate hour value
		String hourVal = hourArray.get(barcod1e.substring(12, 1));
		
		// get 14 and 15 char and get minute value
		
		String minuteval=minutearray.get(barcod1e.substring(13,1))+minutearray.get(barcod1e).substring(14,15);
		
		// By default seconds are 00
		String vehtimeinfrombarcode= year + "-" + monthval + "-" + dateval + " " + hourVal + ":"
				+ minuteval + ":00";


	}
	
	
	public void calculateRate(String barcode){
		
	/*	 $barcode = trim($_REQUEST['barcode']);
		    $outopname = $_REQUEST['opname'];
		    $exitgate = $_REQUEST['gateid'];
		    $vehtype = $_REQUEST['vehtype'];
		    $varvehno = "0000";
		    $veh_no = $_REQUEST['veh_no'];
		    $loccode_fromapp = $_REQUEST['loccode'];
		*/
		
		//to get from input box
		//String barcode;
		//From cache when app starts
		//String outopname;
		//
		String exitgate;
		// from request
		String vehtype;
		String varvehno="0000";
		//Get from request
		String veh_no;
		// From cache  when app starts
		String loccode_fromapp;
		
		
		
		String locationCode=""; // get from the se_loccode;
		String exitGate="exitgate"; // should be in request or from where to get it?
		String outopname="outopname";// should be from cache or where to get it?
		String varvehtype="vehtype";// where to get ?
		String vehtimein="decodedfrom barcode";
		
		// Fetch all member type and location code from setting table
				String sql_trftype="SELECT se_membertype, se_loccode FROM st_se_settingparameter WHERE se_membertype in ('I','O','P')";
		
		String sql_input="SELECT * FROM tr_ti_transin where ti_keyout LIKE '%"
                                        + barcode
                                        + "%'";
		
		// if entry found 
		
		//load all the values 
		
		// check if ti_datetimein is greater than current time throw error and break flow
		
		Date date = new Date();
		String date3= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		
		
	
		
	}

	public String getVehicleInTimeFromBarcode(String barcode) {
		Map<String, String> monthMap = new HashMap<String, String>();
		monthMap.put("B", "JAN");
		monthMap.put("C", "FEB");
		monthMap.put("D", "MAR");
		monthMap.put("E", "APR");
		monthMap.put("F", "MAY");
		monthMap.put("G", "JUN");
		monthMap.put("H", "JUL");
		monthMap.put("I", "AUG");
		monthMap.put("J", "SEP");
		monthMap.put("K", "OCT");
		monthMap.put("L", "NOV");
		monthMap.put("M", "DEC");

		Map<String, String> monthMap1 = new HashMap<String, String>();
		monthMap1.put("JAN", "01");
		monthMap1.put("FEB", "02");
		monthMap1.put("MAR", "03");
		monthMap1.put("APR", "04");
		monthMap1.put("MAY", "05");
		monthMap1.put("JUN", "06");
		monthMap1.put("JUL", "07");
		monthMap1.put("AUG", "08");
		monthMap1.put("SEP", "09");
		monthMap1.put("OCT", "10");
		monthMap1.put("NOV", "11");
		monthMap1.put("DEC", "12");

		String year = String.valueOf(barcode.charAt(7))
				+ String.valueOf(barcode.charAt(8));

		String yearPrefix = String.valueOf(Calendar.getInstance().get(
				Calendar.YEAR));

		year = String.valueOf(yearPrefix.charAt(0))
				+ String.valueOf(yearPrefix.charAt(1)) + year;

		String monthval = String.valueOf(barcode.charAt(9));
		monthval = monthMap.get(monthval);
		monthval = monthMap1.get(monthval);

		String dateval = String.valueOf(((int) barcode.charAt(10)) - 65)
				+ String.valueOf(((int) barcode.charAt(11)) - 65);

		String hourval = String.valueOf(((int) barcode.charAt(12)) - 65);

		String minuteval = String.valueOf(((int) barcode.charAt(13)) - 65)
				+ String.valueOf(((int) barcode.charAt(14)) - 65);

		return year + "-" + monthval + "-" + dateval + " " + hourval + ":"
				+ minuteval + ":00";

	}
	
	
	public void calcRate(){
		
		TrTiTransin tiTransin = new TrTiTransin();
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		
		Date intime= tiTransin.getTiDatetimein();
		
		if(intime.after(date)){
			// Theow an exception 
		}else{
			
			long diffInMillies = Math.abs(date.getTime() - intime.getTime());
			long totalMin = Math.abs(TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS));
			
			BigDecimal totalMins=new BigDecimal(totalMin);
			
			totalMins=totalMins.setScale(2, BigDecimal.ROUND_UP);
			
			
			long days= Math.abs(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS));
			
			BigDecimal totalDays= new BigDecimal(days).setScale(2,BigDecimal.ROUND_UP);
			
			// Call 
			
			
			//BigDecimal bg = new BigDecimal(totalSeconds);
			
			//bg=bg.
		}
		
		
		
		
	}
}
