package com.webcps.webcps.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tr_ti_transin database table.
 * 
 */
@Entity
@Table(name="tr_ti_transin")
@NamedQuery(name="TrTiTransin.findAll", query="SELECT t FROM TrTiTransin t")
public class TrTiTransin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ti_key")
	private String tiKey;

	@Column(name="ti_backup")
	private int tiBackup;

	@Lob
	@Column(name="ti_blob_imagein1")
	private byte[] tiBlobImagein1;

	@Lob
	@Column(name="ti_blob_imagein2")
	private byte[] tiBlobImagein2;

	private String ti_CardNo;

	@Column(name="ti_cm_code")
	private String tiCmCode;

	@Column(name="ti_countererror")
	private int tiCountererror;

	private String ti_DataCard;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ti_datetimein")
	private Date tiDatetimein;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ti_datetimepc")
	private Date tiDatetimepc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ti_dtpasstru")
	private Date tiDtpasstru;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ti_enddtgig")
	private Date tiEnddtgig;

	@Column(name="ti_flazzreceived")
	private int tiFlazzreceived;

	@Column(name="ti_gatein")
	private String tiGatein;

	@Column(name="ti_imagein1")
	private String tiImagein1;

	@Column(name="ti_imagein2")
	private String tiImagein2;

	@Column(name="ti_keyout")
	private String tiKeyout;

	@Column(name="ti_keyout1")
	private String tiKeyout1;

	@Column(name="ti_mm_name")
	private String tiMmName;

	@Column(name="ti_notax")
	private String tiNotax;

	@Column(name="ti_notes")
	private String tiNotes;

	@Column(name="ti_orang")
	private int tiOrang;

	@Column(name="ti_orderbay")
	private byte tiOrderbay;

	@Column(name="ti_paymentchg")
	private int tiPaymentchg;

	@Column(name="ti_policeno")
	private String tiPoliceno;

	@Column(name="ti_prepaidchg")
	private int tiPrepaidchg;

	@Column(name="ti_se_loccode")
	private String tiSeLoccode;

	@Column(name="ti_standartchg")
	private int tiStandartchg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ti_startdtgig")
	private Date tiStartdtgig;

	@Column(name="ti_statustrx")
	private String tiStatustrx;

	@Column(name="ti_ticketno")
	private String tiTicketno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ti_timestartovernight")
	private Date tiTimestartovernight;

	@Column(name="ti_type")
	private int tiType;

	@Column(name="ti_usegig")
	private String tiUsegig;

	@Column(name="ti_usercancel")
	private String tiUsercancel;

	@Column(name="ti_userin")
	private String tiUserin;

	@Column(name="ti_valetchg")
	private int tiValetchg;

	@Column(name="ti_vt_name")
	private String tiVtName;

	public TrTiTransin() {
	}

	public String getTiKey() {
		return this.tiKey;
	}

	public void setTiKey(String tiKey) {
		this.tiKey = tiKey;
	}

	public int getTiBackup() {
		return this.tiBackup;
	}

	public void setTiBackup(int tiBackup) {
		this.tiBackup = tiBackup;
	}

	public byte[] getTiBlobImagein1() {
		return this.tiBlobImagein1;
	}

	public void setTiBlobImagein1(byte[] tiBlobImagein1) {
		this.tiBlobImagein1 = tiBlobImagein1;
	}

	public byte[] getTiBlobImagein2() {
		return this.tiBlobImagein2;
	}

	public void setTiBlobImagein2(byte[] tiBlobImagein2) {
		this.tiBlobImagein2 = tiBlobImagein2;
	}

	public String getTi_CardNo() {
		return this.ti_CardNo;
	}

	public void setTi_CardNo(String ti_CardNo) {
		this.ti_CardNo = ti_CardNo;
	}

	public String getTiCmCode() {
		return this.tiCmCode;
	}

	public void setTiCmCode(String tiCmCode) {
		this.tiCmCode = tiCmCode;
	}

	public int getTiCountererror() {
		return this.tiCountererror;
	}

	public void setTiCountererror(int tiCountererror) {
		this.tiCountererror = tiCountererror;
	}

	public String getTi_DataCard() {
		return this.ti_DataCard;
	}

	public void setTi_DataCard(String ti_DataCard) {
		this.ti_DataCard = ti_DataCard;
	}

	public Date getTiDatetimein() {
		return this.tiDatetimein;
	}

	public void setTiDatetimein(Date tiDatetimein) {
		this.tiDatetimein = tiDatetimein;
	}

	public Date getTiDatetimepc() {
		return this.tiDatetimepc;
	}

	public void setTiDatetimepc(Date tiDatetimepc) {
		this.tiDatetimepc = tiDatetimepc;
	}

	public Date getTiDtpasstru() {
		return this.tiDtpasstru;
	}

	public void setTiDtpasstru(Date tiDtpasstru) {
		this.tiDtpasstru = tiDtpasstru;
	}

	public Date getTiEnddtgig() {
		return this.tiEnddtgig;
	}

	public void setTiEnddtgig(Date tiEnddtgig) {
		this.tiEnddtgig = tiEnddtgig;
	}

	public int getTiFlazzreceived() {
		return this.tiFlazzreceived;
	}

	public void setTiFlazzreceived(int tiFlazzreceived) {
		this.tiFlazzreceived = tiFlazzreceived;
	}

	public String getTiGatein() {
		return this.tiGatein;
	}

	public void setTiGatein(String tiGatein) {
		this.tiGatein = tiGatein;
	}

	public String getTiImagein1() {
		return this.tiImagein1;
	}

	public void setTiImagein1(String tiImagein1) {
		this.tiImagein1 = tiImagein1;
	}

	public String getTiImagein2() {
		return this.tiImagein2;
	}

	public void setTiImagein2(String tiImagein2) {
		this.tiImagein2 = tiImagein2;
	}

	public String getTiKeyout() {
		return this.tiKeyout;
	}

	public void setTiKeyout(String tiKeyout) {
		this.tiKeyout = tiKeyout;
	}

	public String getTiKeyout1() {
		return this.tiKeyout1;
	}

	public void setTiKeyout1(String tiKeyout1) {
		this.tiKeyout1 = tiKeyout1;
	}

	public String getTiMmName() {
		return this.tiMmName;
	}

	public void setTiMmName(String tiMmName) {
		this.tiMmName = tiMmName;
	}

	public String getTiNotax() {
		return this.tiNotax;
	}

	public void setTiNotax(String tiNotax) {
		this.tiNotax = tiNotax;
	}

	public String getTiNotes() {
		return this.tiNotes;
	}

	public void setTiNotes(String tiNotes) {
		this.tiNotes = tiNotes;
	}

	public int getTiOrang() {
		return this.tiOrang;
	}

	public void setTiOrang(int tiOrang) {
		this.tiOrang = tiOrang;
	}

	public byte getTiOrderbay() {
		return this.tiOrderbay;
	}

	public void setTiOrderbay(byte tiOrderbay) {
		this.tiOrderbay = tiOrderbay;
	}

	public int getTiPaymentchg() {
		return this.tiPaymentchg;
	}

	public void setTiPaymentchg(int tiPaymentchg) {
		this.tiPaymentchg = tiPaymentchg;
	}

	public String getTiPoliceno() {
		return this.tiPoliceno;
	}

	public void setTiPoliceno(String tiPoliceno) {
		this.tiPoliceno = tiPoliceno;
	}

	public int getTiPrepaidchg() {
		return this.tiPrepaidchg;
	}

	public void setTiPrepaidchg(int tiPrepaidchg) {
		this.tiPrepaidchg = tiPrepaidchg;
	}

	public String getTiSeLoccode() {
		return this.tiSeLoccode;
	}

	public void setTiSeLoccode(String tiSeLoccode) {
		this.tiSeLoccode = tiSeLoccode;
	}

	public int getTiStandartchg() {
		return this.tiStandartchg;
	}

	public void setTiStandartchg(int tiStandartchg) {
		this.tiStandartchg = tiStandartchg;
	}

	public Date getTiStartdtgig() {
		return this.tiStartdtgig;
	}

	public void setTiStartdtgig(Date tiStartdtgig) {
		this.tiStartdtgig = tiStartdtgig;
	}

	public String getTiStatustrx() {
		return this.tiStatustrx;
	}

	public void setTiStatustrx(String tiStatustrx) {
		this.tiStatustrx = tiStatustrx;
	}

	public String getTiTicketno() {
		return this.tiTicketno;
	}

	public void setTiTicketno(String tiTicketno) {
		this.tiTicketno = tiTicketno;
	}

	public Date getTiTimestartovernight() {
		return this.tiTimestartovernight;
	}

	public void setTiTimestartovernight(Date tiTimestartovernight) {
		this.tiTimestartovernight = tiTimestartovernight;
	}

	public int getTiType() {
		return this.tiType;
	}

	public void setTiType(int tiType) {
		this.tiType = tiType;
	}

	public String getTiUsegig() {
		return this.tiUsegig;
	}

	public void setTiUsegig(String tiUsegig) {
		this.tiUsegig = tiUsegig;
	}

	public String getTiUsercancel() {
		return this.tiUsercancel;
	}

	public void setTiUsercancel(String tiUsercancel) {
		this.tiUsercancel = tiUsercancel;
	}

	public String getTiUserin() {
		return this.tiUserin;
	}

	public void setTiUserin(String tiUserin) {
		this.tiUserin = tiUserin;
	}

	public int getTiValetchg() {
		return this.tiValetchg;
	}

	public void setTiValetchg(int tiValetchg) {
		this.tiValetchg = tiValetchg;
	}

	public String getTiVtName() {
		return this.tiVtName;
	}

	public void setTiVtName(String tiVtName) {
		this.tiVtName = tiVtName;
	}

}