package com.webcps.webcps.service;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcps.webcps.model.ChCcCasualcharge;
import com.webcps.webcps.model.ChHlHolidayday;
import com.webcps.webcps.model.StSeSettingparameter;
import com.webcps.webcps.model.TrTiTransin;
import com.webcps.webcps.repository.CCCasulaChargRepo;
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

	@Autowired
	private CCCasulaChargRepo CCCasulaChargRepo;

	List<String> memberTypes = new ArrayList<String>();

	public BigDecimal calculateRate(String key) {

		TrTiTransin tiTransin = new TrTiTransin();
		BigDecimal totalMins = null;

		tiTransin = trTiTransinRepo.findOne(key);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43

		String current_date = dateFormat.format(date);// check format in which
														// date is coming

		Date intime = tiTransin.getTiDatetimein();

		if (intime.after(date)) {
			// Throw an exception
		} else {

			long diffInMillies = Math.abs(date.getTime() - intime.getTime());
			long totalMin = Math.abs(TimeUnit.MINUTES.convert(diffInMillies,
					TimeUnit.MILLISECONDS));

			totalMins = new BigDecimal(totalMin);

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

		// DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		StSeSettingparameter StSeSettingparameter = stSettingParamRepo
				.findMemberType();

		String rtime = null;
		String indate;
		Time rtime1 = null;

		if ("I".equalsIgnoreCase(StSeSettingparameter.getSeMembertype())
				|| "P".equalsIgnoreCase(StSeSettingparameter.getSeMembertype())) {

			rtime = getTimeFromDate(intime);
			
			//java.sql.Time timeValue = new java.sql.Time(rtime);
			
			rtime1=java.sql.Time.valueOf(rtime);
			indate = dateFormat.format(intime).substring(0, 10);
			// indate =
		} else if ("O".equalsIgnoreCase(StSeSettingparameter.getSeMembertype())) {
			rtime = getTimeFromDate(new Date());
			rtime1=java.sql.Time.valueOf(rtime);
			
			indate = dateFormat.format(new Date()).substring(0, 10);
			
		}

		String day_type = null;
		if (memberTypes.contains(StSeSettingparameter.getSeMembertype())) {

			// check after adding data to table
			Date date_c = new Date();
			String modifiedDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(date_c);
			
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			//System.out.println(cal.getTime());
			// Output "Wed Sep 26 14:23:28 EST 2012"

			String formatted = format1.format(cal.getTime());
			System.out.println(formatted);
			ChHlHolidayday chHlHolidayday = null;
			try {
			Date d=	format1.parse(formatted);
			chHlHolidayday	 = chHolidayRepo.findOne(d);
			System.out.println(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

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

		/*ChCcCasualcharge ChCcCasualcharge = CCCasulaChargRepo.findRateByParam(
				"4_WHEELER", day_type, current_date, rtime);*/
		ChCcCasualcharge ChCcCasualcharge = CCCasulaChargRepo.findRateByParam(
				"4_WHEELER", day_type, new Date(), rtime1);
		BigDecimal cal_chrg = new BigDecimal(0);
		int str_tolerance = ChCcCasualcharge.getCcStarttolerance();
		int end_tolarance = ChCcCasualcharge.getCcEndtolerance();
		int maxchrg = ChCcCasualcharge.getCcMaxchg();
		int penchrg = ChCcCasualcharge.getCcPenaltychg();

		String cc_groupchg = "cc_groupchg";
		String cc_unit_str = "cc_unit";
		String cc_charge_str = "cc_chg";

		Map<String, String> cc_groupchgMap = new HashMap<String, String>();
		Map<String, Integer> cc_unit = new HashMap<String, Integer>();
		Map<String, Integer> cc_charge = new HashMap<String, Integer>();

		cc_groupchgMap.put("cc_groupchg1", ChCcCasualcharge.getCcGroupchg1());
		cc_groupchgMap.put("cc_groupchg2", ChCcCasualcharge.getCcGroupchg2());
		cc_groupchgMap.put("cc_groupchg3", ChCcCasualcharge.getCcGroupchg3());
		cc_groupchgMap.put("cc_groupchg4", ChCcCasualcharge.getCcGroupchg4());
		cc_groupchgMap.put("cc_groupchg5", ChCcCasualcharge.getCcGroupchg5());

		cc_unit.put("cc_unit1", ChCcCasualcharge.getCcUnit1());
		cc_unit.put("cc_unit2", ChCcCasualcharge.getCcUnit2());
		cc_unit.put("cc_unit3", ChCcCasualcharge.getCcUnit3());
		cc_unit.put("cc_unit4", ChCcCasualcharge.getCcUnit4());
		cc_unit.put("cc_unit5", ChCcCasualcharge.getCcUnit5());

		cc_charge.put("cc_chg1", ChCcCasualcharge.getCcChg1());
		cc_charge.put("cc_chg2", ChCcCasualcharge.getCcChg2());
		cc_charge.put("cc_chg3", ChCcCasualcharge.getCcChg3());
		cc_charge.put("cc_chg4", ChCcCasualcharge.getCcChg4());
		cc_charge.put("cc_chg5", ChCcCasualcharge.getCcChg5());

		if (null != ChCcCasualcharge) {

			if (totalMins.intValue() > str_tolerance
					&& totalMins.intValue() > end_tolarance) {

				BigDecimal totalTimein = totalMins;
				totalMins = totalMins.subtract(new BigDecimal(end_tolarance));

				for (int i = 1; i <= 5; i++) {

					String cc_groupchg_key = "cc_groupchg" + i;
					String cc_unit_str_key = "cc_unit" + i;
					String cc_charge_str_key = "cc_chg" + i;

					if ("F".equalsIgnoreCase(cc_groupchgMap
							.get(cc_groupchg_key)) && totalMins.intValue() > 0) {
						totalMins = totalMins.subtract(new BigDecimal(cc_unit
								.get(cc_unit_str_key)));
						cal_chrg = cal_chrg.add(new BigDecimal(cc_charge
								.get(cc_charge_str_key)));
					} else if ("P".equalsIgnoreCase(cc_groupchgMap
							.get(cc_groupchg_key)) && totalMins.intValue() > 0) {
						while (totalMins.intValue() > 0) {
							totalMins = totalMins.subtract(new BigDecimal(
									cc_unit.get(cc_unit_str_key)));
							cal_chrg = cal_chrg.add(new BigDecimal(cc_charge
									.get(cc_charge_str_key)));

						}
					}
				}
			}

		}
		return cal_chrg;
	}

	public static boolean isWeekend(String ts) {
		int year = Integer.parseInt(ts.substring(0, 4));
		int month = Integer.parseInt(ts.substring(5, 7));
		int day = Integer.parseInt(ts.substring(8, 10));
		Calendar cal = new GregorianCalendar(year, month - 1, day);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return (Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek);
	}

	private String getTimeFromDate(Date date) {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		// Date date = new Date();
		String s = dateFormat.format(date);
		System.out.println(s); // 2016/11/16 12:08:43

		String ns = s.substring(s.length() - 8);

		System.out.println(ns);

		return ns;

	}
}
