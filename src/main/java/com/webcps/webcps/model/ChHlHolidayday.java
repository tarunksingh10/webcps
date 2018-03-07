package com.webcps.webcps.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ch_hl_holidayday database table.
 * 
 */
@Entity
@Table(name="ch_hl_holidayday")
@NamedQuery(name="ChHlHolidayday.findAll", query="SELECT c FROM ChHlHolidayday c")
public class ChHlHolidayday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.DATE)
	private Date HL_Date;

	private int HL_Backup;

	private String HL_SE_LocCode;

	@Temporal(TemporalType.TIMESTAMP)
	private Date HL_TimeA;

	@Temporal(TemporalType.TIMESTAMP)
	private Date HL_TimeE;

	private String HL_UserIDA;

	private String HL_UserIDE;

	private String HL_ValidDay;

	public ChHlHolidayday() {
	}

	public Date getHL_Date() {
		return this.HL_Date;
	}

	public void setHL_Date(Date HL_Date) {
		this.HL_Date = HL_Date;
	}

	public int getHL_Backup() {
		return this.HL_Backup;
	}

	public void setHL_Backup(int HL_Backup) {
		this.HL_Backup = HL_Backup;
	}

	public String getHL_SE_LocCode() {
		return this.HL_SE_LocCode;
	}

	public void setHL_SE_LocCode(String HL_SE_LocCode) {
		this.HL_SE_LocCode = HL_SE_LocCode;
	}

	public Date getHL_TimeA() {
		return this.HL_TimeA;
	}

	public void setHL_TimeA(Date HL_TimeA) {
		this.HL_TimeA = HL_TimeA;
	}

	public Date getHL_TimeE() {
		return this.HL_TimeE;
	}

	public void setHL_TimeE(Date HL_TimeE) {
		this.HL_TimeE = HL_TimeE;
	}

	public String getHL_UserIDA() {
		return this.HL_UserIDA;
	}

	public void setHL_UserIDA(String HL_UserIDA) {
		this.HL_UserIDA = HL_UserIDA;
	}

	public String getHL_UserIDE() {
		return this.HL_UserIDE;
	}

	public void setHL_UserIDE(String HL_UserIDE) {
		this.HL_UserIDE = HL_UserIDE;
	}

	public String getHL_ValidDay() {
		return this.HL_ValidDay;
	}

	public void setHL_ValidDay(String HL_ValidDay) {
		this.HL_ValidDay = HL_ValidDay;
	}

}