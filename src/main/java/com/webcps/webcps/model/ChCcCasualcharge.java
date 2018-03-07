package com.webcps.webcps.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the ch_cc_casualcharge database table.
 * 
 */
@Entity
@Table(name="ch_cc_casualcharge")
@NamedQuery(name="ChCcCasualcharge.findAll", query="SELECT c FROM ChCcCasualcharge c")
public class ChCcCasualcharge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cc_code")
	private String ccCode;

	@Column(name="cc_activeflag")
	private String ccActiveflag;

	@Column(name="cc_backup")
	private int ccBackup;

	@Column(name="cc_bayarsekali")
	private byte ccBayarsekali;

	@Column(name="cc_chg1")
	private int ccChg1;

	@Column(name="cc_chg2")
	private int ccChg2;

	@Column(name="cc_chg3")
	private int ccChg3;

	@Column(name="cc_chg4")
	private int ccChg4;

	@Column(name="cc_chg5")
	private int ccChg5;

	@Column(name="cc_endlimit")
	private Time ccEndlimit;

	@Column(name="cc_endtolerance")
	private int ccEndtolerance;

	@Column(name="cc_flatchg")
	private int ccFlatchg;

	@Column(name="cc_groupchg1")
	private String ccGroupchg1;

	@Column(name="cc_groupchg2")
	private String ccGroupchg2;

	@Column(name="cc_groupchg3")
	private String ccGroupchg3;

	@Column(name="cc_groupchg4")
	private String ccGroupchg4;

	@Column(name="cc_groupchg5")
	private String ccGroupchg5;

	@Column(name="cc_maxchg")
	private int ccMaxchg;

	@Column(name="cc_maxhour")
	private int ccMaxhour;

	@Column(name="cc_penaltychg")
	private int ccPenaltychg;

	@Column(name="cc_se_loccode")
	private String ccSeLoccode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cc_startdate")
	private Date ccStartdate;

	@Column(name="cc_startlimit")
	private Time ccStartlimit;

	@Column(name="cc_starttolerance")
	private int ccStarttolerance;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cc_timea")
	private Date ccTimea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cc_timee")
	private Date ccTimee;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cc_timelimit")
	private Date ccTimelimit;

	@Column(name="cc_unit1")
	private int ccUnit1;

	@Column(name="cc_unit2")
	private int ccUnit2;

	@Column(name="cc_unit3")
	private int ccUnit3;

	@Column(name="cc_unit4")
	private int ccUnit4;

	@Column(name="cc_unit5")
	private int ccUnit5;

	@Column(name="cc_unitchg")
	private String ccUnitchg;

	@Column(name="cc_usemaxhour")
	private byte ccUsemaxhour;

	@Column(name="cc_userida")
	private String ccUserida;

	@Column(name="cc_useride")
	private String ccUseride;

	@Column(name="cc_usetime")
	private byte ccUsetime;

	@Column(name="cc_validday")
	private String ccValidday;

	@Column(name="cc_vt_name")
	private String ccVtName;

	@Column(name="cc_xcode")
	private String ccXcode;

	public ChCcCasualcharge() {
	}

	public String getCcCode() {
		return this.ccCode;
	}

	public void setCcCode(String ccCode) {
		this.ccCode = ccCode;
	}

	public String getCcActiveflag() {
		return this.ccActiveflag;
	}

	public void setCcActiveflag(String ccActiveflag) {
		this.ccActiveflag = ccActiveflag;
	}

	public int getCcBackup() {
		return this.ccBackup;
	}

	public void setCcBackup(int ccBackup) {
		this.ccBackup = ccBackup;
	}

	public byte getCcBayarsekali() {
		return this.ccBayarsekali;
	}

	public void setCcBayarsekali(byte ccBayarsekali) {
		this.ccBayarsekali = ccBayarsekali;
	}

	public int getCcChg1() {
		return this.ccChg1;
	}

	public void setCcChg1(int ccChg1) {
		this.ccChg1 = ccChg1;
	}

	public int getCcChg2() {
		return this.ccChg2;
	}

	public void setCcChg2(int ccChg2) {
		this.ccChg2 = ccChg2;
	}

	public int getCcChg3() {
		return this.ccChg3;
	}

	public void setCcChg3(int ccChg3) {
		this.ccChg3 = ccChg3;
	}

	public int getCcChg4() {
		return this.ccChg4;
	}

	public void setCcChg4(int ccChg4) {
		this.ccChg4 = ccChg4;
	}

	public int getCcChg5() {
		return this.ccChg5;
	}

	public void setCcChg5(int ccChg5) {
		this.ccChg5 = ccChg5;
	}

	public Time getCcEndlimit() {
		return this.ccEndlimit;
	}

	public void setCcEndlimit(Time ccEndlimit) {
		this.ccEndlimit = ccEndlimit;
	}

	public int getCcEndtolerance() {
		return this.ccEndtolerance;
	}

	public void setCcEndtolerance(int ccEndtolerance) {
		this.ccEndtolerance = ccEndtolerance;
	}

	public int getCcFlatchg() {
		return this.ccFlatchg;
	}

	public void setCcFlatchg(int ccFlatchg) {
		this.ccFlatchg = ccFlatchg;
	}

	public String getCcGroupchg1() {
		return this.ccGroupchg1;
	}

	public void setCcGroupchg1(String ccGroupchg1) {
		this.ccGroupchg1 = ccGroupchg1;
	}

	public String getCcGroupchg2() {
		return this.ccGroupchg2;
	}

	public void setCcGroupchg2(String ccGroupchg2) {
		this.ccGroupchg2 = ccGroupchg2;
	}

	public String getCcGroupchg3() {
		return this.ccGroupchg3;
	}

	public void setCcGroupchg3(String ccGroupchg3) {
		this.ccGroupchg3 = ccGroupchg3;
	}

	public String getCcGroupchg4() {
		return this.ccGroupchg4;
	}

	public void setCcGroupchg4(String ccGroupchg4) {
		this.ccGroupchg4 = ccGroupchg4;
	}

	public String getCcGroupchg5() {
		return this.ccGroupchg5;
	}

	public void setCcGroupchg5(String ccGroupchg5) {
		this.ccGroupchg5 = ccGroupchg5;
	}

	public int getCcMaxchg() {
		return this.ccMaxchg;
	}

	public void setCcMaxchg(int ccMaxchg) {
		this.ccMaxchg = ccMaxchg;
	}

	public int getCcMaxhour() {
		return this.ccMaxhour;
	}

	public void setCcMaxhour(int ccMaxhour) {
		this.ccMaxhour = ccMaxhour;
	}

	public int getCcPenaltychg() {
		return this.ccPenaltychg;
	}

	public void setCcPenaltychg(int ccPenaltychg) {
		this.ccPenaltychg = ccPenaltychg;
	}

	public String getCcSeLoccode() {
		return this.ccSeLoccode;
	}

	public void setCcSeLoccode(String ccSeLoccode) {
		this.ccSeLoccode = ccSeLoccode;
	}

	public Date getCcStartdate() {
		return this.ccStartdate;
	}

	public void setCcStartdate(Date ccStartdate) {
		this.ccStartdate = ccStartdate;
	}

	public Time getCcStartlimit() {
		return this.ccStartlimit;
	}

	public void setCcStartlimit(Time ccStartlimit) {
		this.ccStartlimit = ccStartlimit;
	}

	public int getCcStarttolerance() {
		return this.ccStarttolerance;
	}

	public void setCcStarttolerance(int ccStarttolerance) {
		this.ccStarttolerance = ccStarttolerance;
	}

	public Date getCcTimea() {
		return this.ccTimea;
	}

	public void setCcTimea(Date ccTimea) {
		this.ccTimea = ccTimea;
	}

	public Date getCcTimee() {
		return this.ccTimee;
	}

	public void setCcTimee(Date ccTimee) {
		this.ccTimee = ccTimee;
	}

	public Date getCcTimelimit() {
		return this.ccTimelimit;
	}

	public void setCcTimelimit(Date ccTimelimit) {
		this.ccTimelimit = ccTimelimit;
	}

	public int getCcUnit1() {
		return this.ccUnit1;
	}

	public void setCcUnit1(int ccUnit1) {
		this.ccUnit1 = ccUnit1;
	}

	public int getCcUnit2() {
		return this.ccUnit2;
	}

	public void setCcUnit2(int ccUnit2) {
		this.ccUnit2 = ccUnit2;
	}

	public int getCcUnit3() {
		return this.ccUnit3;
	}

	public void setCcUnit3(int ccUnit3) {
		this.ccUnit3 = ccUnit3;
	}

	public int getCcUnit4() {
		return this.ccUnit4;
	}

	public void setCcUnit4(int ccUnit4) {
		this.ccUnit4 = ccUnit4;
	}

	public int getCcUnit5() {
		return this.ccUnit5;
	}

	public void setCcUnit5(int ccUnit5) {
		this.ccUnit5 = ccUnit5;
	}

	public String getCcUnitchg() {
		return this.ccUnitchg;
	}

	public void setCcUnitchg(String ccUnitchg) {
		this.ccUnitchg = ccUnitchg;
	}

	public byte getCcUsemaxhour() {
		return this.ccUsemaxhour;
	}

	public void setCcUsemaxhour(byte ccUsemaxhour) {
		this.ccUsemaxhour = ccUsemaxhour;
	}

	public String getCcUserida() {
		return this.ccUserida;
	}

	public void setCcUserida(String ccUserida) {
		this.ccUserida = ccUserida;
	}

	public String getCcUseride() {
		return this.ccUseride;
	}

	public void setCcUseride(String ccUseride) {
		this.ccUseride = ccUseride;
	}

	public byte getCcUsetime() {
		return this.ccUsetime;
	}

	public void setCcUsetime(byte ccUsetime) {
		this.ccUsetime = ccUsetime;
	}

	public String getCcValidday() {
		return this.ccValidday;
	}

	public void setCcValidday(String ccValidday) {
		this.ccValidday = ccValidday;
	}

	public String getCcVtName() {
		return this.ccVtName;
	}

	public void setCcVtName(String ccVtName) {
		this.ccVtName = ccVtName;
	}

	public String getCcXcode() {
		return this.ccXcode;
	}

	public void setCcXcode(String ccXcode) {
		this.ccXcode = ccXcode;
	}

}