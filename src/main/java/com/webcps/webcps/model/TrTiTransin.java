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

import lombok.Data;

/**
 * The persistent class for the tr_ti_transin database table.
 * 
 */
@Entity
@Table(name = "tr_ti_transin")
@NamedQuery(name = "TrTiTransin.findAll", query = "SELECT t FROM TrTiTransin t")
@Data
public class TrTiTransin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "ti_key")
	private String tiKey;

	@Id
	@Column(name = "ti_keyout")
	private String tiKeyout;

	@Column(name = "ti_backup")
	private int tiBackup;

	@Lob
	@Column(name = "ti_blob_imagein1")
	private byte[] tiBlobImagein1;

	@Lob
	@Column(name = "ti_blob_imagein2")
	private byte[] tiBlobImagein2;

	private String ti_CardNo;

	@Column(name = "ti_cm_code")
	private String tiCmCode;

	@Column(name = "ti_countererror")
	private int tiCountererror;

	private String ti_DataCard;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ti_datetimein")
	private Date tiDatetimein;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ti_datetimepc")
	private Date tiDatetimepc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ti_dtpasstru")
	private Date tiDtpasstru;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ti_enddtgig")
	private Date tiEnddtgig;

	@Column(name = "ti_flazzreceived")
	private int tiFlazzreceived;

	@Column(name = "ti_gatein")
	private String tiGatein;

	@Column(name = "ti_imagein1")
	private String tiImagein1;

	@Column(name = "ti_imagein2")
	private String tiImagein2;

	@Column(name = "ti_keyout1")
	private String tiKeyout1;

	@Column(name = "ti_mm_name")
	private String tiMmName;

	@Column(name = "ti_notax")
	private String tiNotax;

	@Column(name = "ti_notes")
	private String tiNotes;

	@Column(name = "ti_orang")
	private int tiOrang;

	@Column(name = "ti_orderbay")
	private byte tiOrderbay;

	@Column(name = "ti_paymentchg")
	private int tiPaymentchg;

	@Column(name = "ti_policeno")
	private String tiPoliceno;

	@Column(name = "ti_prepaidchg")
	private int tiPrepaidchg;

	@Column(name = "ti_se_loccode")
	private String tiSeLoccode;

	@Column(name = "ti_standartchg")
	private int tiStandartchg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ti_startdtgig")
	private Date tiStartdtgig;

	@Column(name = "ti_statustrx")
	private String tiStatustrx;

	@Column(name = "ti_ticketno")
	private String tiTicketno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ti_timestartovernight")
	private Date tiTimestartovernight;

	@Column(name = "ti_type")
	private int tiType;

	@Column(name = "ti_usegig")
	private String tiUsegig;

	@Column(name = "ti_usercancel")
	private String tiUsercancel;

	@Column(name = "ti_userin")
	private String tiUserin;

	@Column(name = "ti_valetchg")
	private int tiValetchg;

	@Column(name = "ti_vt_name")
	private String tiVtName;

	public TrTiTransin() {
	}

}