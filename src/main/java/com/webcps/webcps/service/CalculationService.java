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
import com.webcps.webcps.model.TrTfTransfast;
import com.webcps.webcps.model.TrTiTransin;
import com.webcps.webcps.repository.CCCasulaChargRepo;
import com.webcps.webcps.repository.ChHolidayRepo;
import com.webcps.webcps.repository.StSettingParamRepo;
import com.webcps.webcps.repository.TrTfTransfastRepo;
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

	@Autowired
	private TrTfTransfastRepo trTfTransfastRepo;

	List<String> memberTypes = new ArrayList<String>();

	public BigDecimal calculateRate(TrTiTransin tiTransin) {

		// TrTiTransin tiTransin = new TrTiTransin();
		BigDecimal totalMins = null;

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
			long totalMin = Math.abs(TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS));

			totalMins = new BigDecimal(totalMin);

			totalMins = totalMins.setScale(2, BigDecimal.ROUND_UP);

			long days = Math.abs(TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS));

			BigDecimal totalDays = new BigDecimal(days).setScale(2, BigDecimal.ROUND_UP);

			BigDecimal totalDays1 = totalDays.add(new BigDecimal(1));

			// String se_membertype=null; // get member Type

		}

		memberTypes.add("I");
		memberTypes.add("O");
		memberTypes.add("P");

		// DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		StSeSettingparameter StSeSettingparameter = stSettingParamRepo.findMemberType();

		String rtime = null;
		String indate;
		Time rtime1 = null;

		if ("I".equalsIgnoreCase(StSeSettingparameter.getSeMembertype())
				|| "P".equalsIgnoreCase(StSeSettingparameter.getSeMembertype())) {

			rtime = getTimeFromDate(intime);

			// java.sql.Time timeValue = new java.sql.Time(rtime);

			rtime1 = java.sql.Time.valueOf(rtime);
			indate = dateFormat.format(intime).substring(0, 10);
			// indate =
		} else if ("O".equalsIgnoreCase(StSeSettingparameter.getSeMembertype())) {
			rtime = getTimeFromDate(new Date());
			rtime1 = java.sql.Time.valueOf(rtime);

			indate = dateFormat.format(new Date()).substring(0, 10);

		}

		String day_type = null;
		if (memberTypes.contains(StSeSettingparameter.getSeMembertype())) {

			// check after adding data to table
			Date date_c = new Date();
			String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date_c);

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			// System.out.println(cal.getTime());
			// Output "Wed Sep 26 14:23:28 EST 2012"

			String formatted = format1.format(cal.getTime());
			System.out.println(formatted);
			ChHlHolidayday chHlHolidayday = null;
			try {
				Date d = format1.parse(formatted);
				chHlHolidayday = chHolidayRepo.findOne(d);
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

		/*
		 * ChCcCasualcharge ChCcCasualcharge =
		 * CCCasulaChargRepo.findRateByParam( "4_WHEELER", day_type,
		 * current_date, rtime);
		 */
		ChCcCasualcharge ChCcCasualcharge = CCCasulaChargRepo.findRateByParam("4_WHEELER", day_type, new Date(),
				rtime1);
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

			if (totalMins.intValue() > str_tolerance && totalMins.intValue() > end_tolarance) {

				BigDecimal totalTimein = totalMins;
				totalMins = totalMins.subtract(new BigDecimal(end_tolarance));

				for (int i = 1; i <= 5; i++) {

					String cc_groupchg_key = "cc_groupchg" + i;
					String cc_unit_str_key = "cc_unit" + i;
					String cc_charge_str_key = "cc_chg" + i;

					if ("F".equalsIgnoreCase(cc_groupchgMap.get(cc_groupchg_key)) && totalMins.intValue() > 0) {
						totalMins = totalMins.subtract(new BigDecimal(cc_unit.get(cc_unit_str_key)));
						cal_chrg = cal_chrg.add(new BigDecimal(cc_charge.get(cc_charge_str_key)));
					} else if ("P".equalsIgnoreCase(cc_groupchgMap.get(cc_groupchg_key)) && totalMins.intValue() > 0) {
						while (totalMins.intValue() > 0) {
							totalMins = totalMins.subtract(new BigDecimal(cc_unit.get(cc_unit_str_key)));
							cal_chrg = cal_chrg.add(new BigDecimal(cc_charge.get(cc_charge_str_key)));

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

	public BigDecimal calacRateInfo(String barcode) {

		BigDecimal returnvall = new BigDecimal(-9999);

		TrTiTransin tiTransin = trTiTransinRepo.findOne(barcode);
		if (null != tiTransin) {
			returnvall = calculateRate(tiTransin);
			insertTrTfTransfast(barcode, returnvall, tiTransin);
		} else {
			insertTrTiTransin(barcode);
		}
		return returnvall;

	}

	private void insertTrTfTransfast(String barcode, BigDecimal tarrif, TrTiTransin tiTransin) {
		TrTfTransfast trTfTransfast = new TrTfTransfast();
		trTfTransfast.setTfKey("");// auto generated key
		trTfTransfast.setTfPoliceno("");
		trTfTransfast.setTfCardno("0000");
		trTfTransfast.setTfGatein(tiTransin.getTiGatein());
		trTfTransfast.setTfUserin(tiTransin.getTiUserin());
		trTfTransfast.setTfDatetimein(tiTransin.getTiDatetimein());
		trTfTransfast.setTfVtName(tiTransin.getTiVtName());
		trTfTransfast.setTfType(0);
		trTfTransfast.setTfMmName("");
		trTfTransfast.setTfCmCode("");
		trTfTransfast.setTfTicketno(tiTransin.getTiTicketno());
		trTfTransfast.setTfDatacard("");
		trTfTransfast.setTfManualticketno("");
		trTfTransfast.setTfGateout("PK10");
		trTfTransfast.setTfUserout("PP14");
		trTfTransfast.setTfDatetimeout(new Date());
		trTfTransfast.setTfDuration(0);// time difference
		trTfTransfast.setTfPrepaidchg(0);
		trTfTransfast.setTfFlazzreceived(0);
		trTfTransfast.setTfStandartchg(tarrif.intValue());
		trTfTransfast.setTfStandartchg2(tarrif.intValue());
		trTfTransfast.setTfValeychg(0);
		trTfTransfast.setTfOvernightchg(0);
		trTfTransfast.setTfOvernightchg2(0);
		trTfTransfast.setTfBaychg(0);
		trTfTransfast.setTfPenaltychg(0);
		trTfTransfast.setTfPpntax(0);
		trTfTransfast.setTfParktax(0);
		trTfTransfast.setTfStatementstat((byte) 0);
		trTfTransfast.setTfRecstat((byte) 0);
		trTfTransfast.setTfCounterpass(0);
		trTfTransfast.setTfStatustrx("N");
		trTfTransfast.setTfLotre((byte) 0);
		trTfTransfast.setTfVouchername("");
		trTfTransfast.setTfQtyvoucher(0);
		trTfTransfast.setTfVoucherchg(0);
		trTfTransfast.setTfNotes("");
		trTfTransfast.setTfDataproblem("");
		trTfTransfast.setTfSeLoccode("740"); // decode for barcode
		trTfTransfast.setTfUserida("");
		trTfTransfast.setTfTimea(new Date(0000, 00, 00, 00, 00, 00));
		trTfTransfast.setTfBackup(0);
		trTfTransfast.setTfFirstchg(0);
		trTfTransfast.setTfEksklusifchg(0);
		trTfTransfast.setTfTimestartovernight(null);
		trTfTransfast.setTfKeyout(tiTransin.getTiKeyout());
		trTfTransfast.setTfNotax("0");
		trTfTransfast.setTfKeluar((byte) 0);
		trTfTransfast.setTfWaktukeluar(null);
		trTfTransfastRepo.save(trTfTransfast);
	}

	private void insertTrTiTransin(String barcode) {
		TrTiTransin tiTransin = new TrTiTransin();
		tiTransin.setTiKey("");// auto generated key
		tiTransin.setTiGatein("");// decode from barcode
		tiTransin.setTiUserin("");
		tiTransin.setTiDatetimein(new Date());// decode from barcode
		tiTransin.setTiVtName("4_WHEELER");
		tiTransin.setTiType(0);
		tiTransin.setTiMmName("");
		tiTransin.setTiCmCode("");
		tiTransin.setTiTicketno("");// Convert the hex got from barcode decode
									// to decimal
		tiTransin.setTiOrderbay((byte) 0);
		tiTransin.setTiStandartchg(0);
		tiTransin.setTiPaymentchg(0);
		tiTransin.setTiValetchg(0);
		tiTransin.setTiPrepaidchg(0);
		tiTransin.setTiFlazzreceived(0);
		tiTransin.setTiSeLoccode("");// location code got from decoding the
										// barcode
		tiTransin.setTiBackup(0);
		tiTransin.setTi_CardNo("0");
		tiTransin.setTi_DataCard("0");
		tiTransin.setTiStatustrx("N");
		tiTransin.setTiCountererror(0);
		tiTransin.setTiDtpasstru(new Date());// Date & time decoded from the
												// Barcode - assume seconds as
												// 00
		tiTransin.setTiImagein1("");
		tiTransin.setTiImagein2("");
		tiTransin.setTiKeyout(barcode);
		tiTransin.setTiUsegig("0");
		tiTransin.setTiNotax("0");
		tiTransin.setTiUsercancel("");
		tiTransin.setTiNotes("");
		tiTransin.setTiOrang(1);
		tiTransin.setTiKeyout1("");

		trTiTransinRepo.save(tiTransin);

	}

	private String autoGeneratekey(TrTiTransin tiTransin) {
		StringBuffer key = new StringBuffer();

		key.append("00");
		key.append(tiTransin.getTiGatein());

		Date datein = tiTransin.getTiDatetimein();
		Calendar cal = Calendar.getInstance();
		cal.setTime(datein);
		Integer year = cal.get(Calendar.YEAR);
		Integer month = cal.get(Calendar.MONTH);
		Integer day = cal.get(Calendar.DAY_OF_MONTH);
		Integer hour = cal.get(Calendar.HOUR_OF_DAY);
		Integer minute = cal.get(Calendar.MINUTE);
		Integer second = cal.get(Calendar.SECOND);
		String year1 = year.toString();
		String yy = year1.substring(Math.max(year1.length() - 2, 0));
		String mm = String.format("%02d", month);
		String dd = String.format("%02d", day);
		String hh = String.format("%02d", hour);
		String mmm = String.format("%02d", minute);
		String ss = String.format("%02d", second);

		key.append(yy).append(mm).append(dd).append(hh).append(mmm).append(ss);
		return key.toString();
	}
}
