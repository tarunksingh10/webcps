package com.webcps.webcps.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ch_vd_validday database table.
 * 
 */
@Entity
@Table(name="ch_vd_validday")
@NamedQuery(name="ChVdValidday.findAll", query="SELECT c FROM ChVdValidday c")
public class ChVdValidday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="vd_day")
	private int vdDay;

	@Column(name="vd_backup")
	private int vdBackup;

	@Column(name="vd_overnight")
	private byte vdOvernight;

	@Column(name="vd_se_loccode")
	private String vdSeLoccode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="vd_timea")
	private Date vdTimea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="vd_timee")
	private Date vdTimee;

	@Column(name="vd_userida")
	private String vdUserida;

	@Column(name="vd_useride")
	private String vdUseride;

	@Column(name="vd_validday")
	private String vdValidday;

	public ChVdValidday() {
	}

	public int getVdDay() {
		return this.vdDay;
	}

	public void setVdDay(int vdDay) {
		this.vdDay = vdDay;
	}

	public int getVdBackup() {
		return this.vdBackup;
	}

	public void setVdBackup(int vdBackup) {
		this.vdBackup = vdBackup;
	}

	public byte getVdOvernight() {
		return this.vdOvernight;
	}

	public void setVdOvernight(byte vdOvernight) {
		this.vdOvernight = vdOvernight;
	}

	public String getVdSeLoccode() {
		return this.vdSeLoccode;
	}

	public void setVdSeLoccode(String vdSeLoccode) {
		this.vdSeLoccode = vdSeLoccode;
	}

	public Date getVdTimea() {
		return this.vdTimea;
	}

	public void setVdTimea(Date vdTimea) {
		this.vdTimea = vdTimea;
	}

	public Date getVdTimee() {
		return this.vdTimee;
	}

	public void setVdTimee(Date vdTimee) {
		this.vdTimee = vdTimee;
	}

	public String getVdUserida() {
		return this.vdUserida;
	}

	public void setVdUserida(String vdUserida) {
		this.vdUserida = vdUserida;
	}

	public String getVdUseride() {
		return this.vdUseride;
	}

	public void setVdUseride(String vdUseride) {
		this.vdUseride = vdUseride;
	}

	public String getVdValidday() {
		return this.vdValidday;
	}

	public void setVdValidday(String vdValidday) {
		this.vdValidday = vdValidday;
	}

}