package com.webcps.webcps.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcps.webcps.model.ChHlHolidayday;
import com.webcps.webcps.model.StSeSettingparameter;
import com.webcps.webcps.model.TrTiTransin;
import com.webcps.webcps.repository.ChHolidayRepo;
import com.webcps.webcps.repository.StSettingParamRepo;
import com.webcps.webcps.repository.TrTiTransinRepo;

@Service
public class CalculationService {

	@Autowired
	private StSettingParamRepo stSettingParamRepo;
	@Autowired
	private TrTiTransinRepo trTiTransinRepo;
	@Autowired
	private ChHolidayRepo chHolidayRepo;

	List<String> memberTypes = new ArrayList<String>();

	public long calculateRate() {

		TrTiTransin tiTransin = new TrTiTransin();

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43

		// check format in which date is coming

		Date intime = tiTransin.getTiDatetimein();

		if (intime.after(date)) {
			// Throw an exception
		} else {

			long diffInMillies = Math.abs(date.getTime() - intime.getTime());
			long totalMin = Math.abs(TimeUnit.MINUTES.convert(diffInMillies,
					TimeUnit.MILLISECONDS));

			BigDecimal totalMins = new BigDecimal(totalMin);

			totalMins = totalMins.setScale(2, BigDecimal.ROUND_UP);

			long days = Math.abs(TimeUnit.DAYS.convert(diffInMillies,
					TimeUnit.MILLISECONDS));

			BigDecimal totalDays = new BigDecimal(days).setScale(2,
					BigDecimal.ROUND_UP);

			BigDecimal totalDays1 = totalDays.add(new BigDecimal(1));

			// String se_membertype=null; // get member Type

		}

		memberTypes.add("I");
		memberTypes.add("O");
		memberTypes.add("P");

		StSeSettingparameter StSeSettingparameter = stSettingParamRepo
				.findMemberType();

		String rtime;
		String indate;

		if ("I".equalsIgnoreCase(StSeSettingparameter.getSeMembertype())
				|| "P".equalsIgnoreCase(StSeSettingparameter.getSeMembertype())) {
			
			
     rtime = getTimeFromDate(intime);
     //indate =
		}

		if (memberTypes.contains(StSeSettingparameter.getSeMembertype())) {

			Date date_c = new Date();
			String modifiedDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(date_c);
			ChHlHolidayday chHlHolidayday = chHolidayRepo.findOne(modifiedDate);

			String day_type = null;

			// check this logic for DB
			if (null != chHlHolidayday) {
				day_type = "S";
			} else {
				if (isWeekend(modifiedDate)) {
					day_type = "H";
				} else {
					day_type = "W";
				}
			}

		}

		return 10;
	}

	public static boolean isWeekend(String ts) {
		int year = Integer.parseInt(ts.substring(0, 4));
		int month = Integer.parseInt(ts.substring(4, 6));
		int day = Integer.parseInt(ts.substring(6, 8));
		Calendar cal = new GregorianCalendar(year, month - 1, day);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek);
	}

	private String getTimeFromDate(Date date) {


		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//Date date = new Date();
		String s=dateFormat.format(date);
		System.out.println(s); //2016/11/16 12:08:43
		
		String ns= s.substring(s.length()-8);
		
		System.out.println(ns);
		
		return ns;

	}
}
