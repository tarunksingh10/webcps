package com.webcps.webcps.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


/**
 * The persistent class for the tr_tf_transfast database table.
 * 
 */
@Entity
@Data
@Table(name="tr_tf_transfast")
@NamedQuery(name="TrTfTransfast.findAll", query="SELECT t FROM TrTfTransfast t")
public class TrTfTransfast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="tf_backup")
	private int tfBackup;

	@Column(name="tf_baychg")
	private int tfBaychg;

	@Column(name="tf_cardno")
	private String tfCardno;

	@Column(name="tf_cm_code")
	private String tfCmCode;

	@Column(name="tf_counterpass")
	private int tfCounterpass;

	@Column(name="tf_datacard")
	private String tfDatacard;

	@Column(name="tf_dataproblem")
	private String tfDataproblem;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tf_datetimein")
	private Date tfDatetimein;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tf_datetimeout")
	private Date tfDatetimeout;

	@Column(name="tf_duration")
	private int tfDuration;

	@Column(name="tf_eksklusifchg")
	private int tfEksklusifchg;

	@Column(name="tf_firstchg")
	private int tfFirstchg;

	@Column(name="tf_flazzreceived")
	private int tfFlazzreceived;

	@Column(name="tf_gatein")
	private String tfGatein;

	@Column(name="tf_gateout")
	private String tfGateout;

	@Column(name="tf_keluar")
	private byte tfKeluar;

	@Column(name="tf_key")
	private String tfKey;

	@Id
	@Column(name="tf_keyout")
	private String tfKeyout;

	@Column(name="tf_lotre")
	private byte tfLotre;

	@Column(name="tf_manualticketno")
	private String tfManualticketno;

	@Column(name="tf_mm_name")
	private String tfMmName;

	@Column(name="tf_notax")
	private String tfNotax;

	@Column(name="tf_notes")
	private String tfNotes;

	@Column(name="tf_overnightchg")
	private int tfOvernightchg;

	@Column(name="tf_overnightchg2")
	private int tfOvernightchg2;

	@Column(name="tf_parktax")
	private int tfParktax;

	@Column(name="tf_penaltychg")
	private int tfPenaltychg;

	@Column(name="tf_policeno")
	private String tfPoliceno;

	@Column(name="tf_ppntax")
	private int tfPpntax;

	@Column(name="tf_prepaidchg")
	private int tfPrepaidchg;

	@Column(name="tf_qtyvoucher")
	private int tfQtyvoucher;

	@Column(name="tf_recstat")
	private byte tfRecstat;

	@Column(name="tf_se_loccode")
	private String tfSeLoccode;

	@Column(name="tf_standartchg")
	private int tfStandartchg;

	@Column(name="tf_standartchg2")
	private int tfStandartchg2;

	@Column(name="tf_statementstat")
	private byte tfStatementstat;

	@Column(name="tf_statustrx")
	private String tfStatustrx;

	@Column(name="tf_ticketno")
	private String tfTicketno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tf_timea")
	private Date tfTimea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tf_timestartovernight")
	private Date tfTimestartovernight;

	@Column(name="tf_type")
	private int tfType;

	@Column(name="tf_userida")
	private String tfUserida;

	@Column(name="tf_userin")
	private String tfUserin;

	@Column(name="tf_userout")
	private String tfUserout;

	@Column(name="tf_valeychg")
	private int tfValeychg;

	@Column(name="tf_voucherchg")
	private int tfVoucherchg;

	@Column(name="tf_vouchername")
	private String tfVouchername;

	@Column(name="tf_vt_name")
	private String tfVtName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tf_waktukeluar")
	private Date tfWaktukeluar;

	public TrTfTransfast() {
	}

}