package com.webcps.webcps.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the st_sg_settinggate database table.
 * 
 */
@Entity
@Table(name="st_sg_settinggate")
@NamedQuery(name="StSgSettinggate.findAll", query="SELECT s FROM StSgSettinggate s")
public class StSgSettinggate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sg_ip")
	private String sgIp;

	@Column(name="sg_alerttelstruk")
	private int sgAlerttelstruk;

	@Column(name="sg_backup")
	private int sgBackup;

	@Column(name="sg_countertelstruk")
	private int sgCountertelstruk;

	@Column(name="sg_customerfree")
	private byte sgCustomerfree;

	@Column(name="sg_gatename")
	private String sgGatename;

	@Column(name="sg_maxtelstruk")
	private int sgMaxtelstruk;

	@Column(name="sg_mediainput")
	private String sgMediainput;

	@Column(name="sg_se_loccode")
	private String sgSeLoccode;

	@Column(name="sg_specialgate")
	private String sgSpecialgate;

	@Column(name="sg_statuskeluarvalet")
	private String sgStatuskeluarvalet;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sg_timea")
	private Date sgTimea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sg_timee")
	private Date sgTimee;

	@Column(name="sg_transtype")
	private String sgTranstype;

	@Column(name="sg_typegate")
	private String sgTypegate;

	@Column(name="sg_userida")
	private String sgUserida;

	@Column(name="sg_useride")
	private String sgUseride;

	public StSgSettinggate() {
	}

	public String getSgIp() {
		return this.sgIp;
	}

	public void setSgIp(String sgIp) {
		this.sgIp = sgIp;
	}

	public int getSgAlerttelstruk() {
		return this.sgAlerttelstruk;
	}

	public void setSgAlerttelstruk(int sgAlerttelstruk) {
		this.sgAlerttelstruk = sgAlerttelstruk;
	}

	public int getSgBackup() {
		return this.sgBackup;
	}

	public void setSgBackup(int sgBackup) {
		this.sgBackup = sgBackup;
	}

	public int getSgCountertelstruk() {
		return this.sgCountertelstruk;
	}

	public void setSgCountertelstruk(int sgCountertelstruk) {
		this.sgCountertelstruk = sgCountertelstruk;
	}

	public byte getSgCustomerfree() {
		return this.sgCustomerfree;
	}

	public void setSgCustomerfree(byte sgCustomerfree) {
		this.sgCustomerfree = sgCustomerfree;
	}

	public String getSgGatename() {
		return this.sgGatename;
	}

	public void setSgGatename(String sgGatename) {
		this.sgGatename = sgGatename;
	}

	public int getSgMaxtelstruk() {
		return this.sgMaxtelstruk;
	}

	public void setSgMaxtelstruk(int sgMaxtelstruk) {
		this.sgMaxtelstruk = sgMaxtelstruk;
	}

	public String getSgMediainput() {
		return this.sgMediainput;
	}

	public void setSgMediainput(String sgMediainput) {
		this.sgMediainput = sgMediainput;
	}

	public String getSgSeLoccode() {
		return this.sgSeLoccode;
	}

	public void setSgSeLoccode(String sgSeLoccode) {
		this.sgSeLoccode = sgSeLoccode;
	}

	public String getSgSpecialgate() {
		return this.sgSpecialgate;
	}

	public void setSgSpecialgate(String sgSpecialgate) {
		this.sgSpecialgate = sgSpecialgate;
	}

	public String getSgStatuskeluarvalet() {
		return this.sgStatuskeluarvalet;
	}

	public void setSgStatuskeluarvalet(String sgStatuskeluarvalet) {
		this.sgStatuskeluarvalet = sgStatuskeluarvalet;
	}

	public Date getSgTimea() {
		return this.sgTimea;
	}

	public void setSgTimea(Date sgTimea) {
		this.sgTimea = sgTimea;
	}

	public Date getSgTimee() {
		return this.sgTimee;
	}

	public void setSgTimee(Date sgTimee) {
		this.sgTimee = sgTimee;
	}

	public String getSgTranstype() {
		return this.sgTranstype;
	}

	public void setSgTranstype(String sgTranstype) {
		this.sgTranstype = sgTranstype;
	}

	public String getSgTypegate() {
		return this.sgTypegate;
	}

	public void setSgTypegate(String sgTypegate) {
		this.sgTypegate = sgTypegate;
	}

	public String getSgUserida() {
		return this.sgUserida;
	}

	public void setSgUserida(String sgUserida) {
		this.sgUserida = sgUserida;
	}

	public String getSgUseride() {
		return this.sgUseride;
	}

	public void setSgUseride(String sgUseride) {
		this.sgUseride = sgUseride;
	}

}