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
 * The persistent class for the us_lu_listuser database table.
 * 
 */
@Entity
@Table(name = "us_lu_listuser")
@NamedQuery(name = "UsLuListuser.findAll", query = "SELECT u FROM UsLuListuser u")
@Data
public class UsLuListuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "lu_user")
	private String luUser;

	@Column(name = "lu_access")
	private String luAccess;

	@Column(name = "lu_adjustlimit")
	private int luAdjustlimit;

	@Column(name = "lu_backup")
	private int luBackup;

	@Column(name = "lu_code")
	private String luCode;

	@Column(name = "lu_creator")
	private String luCreator;

	@Column(name = "lu_dp_code")
	private String luDpCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lu_enddate")
	private Date luEnddate;

	@Column(name = "lu_initial")
	private String luInitial;

	@Column(name = "lu_ipaddr")
	private String luIpaddr;

	@Column(name = "lu_ll_type")
	private String luLlType;

	@Column(name = "lu_lv_code")
	private int luLvCode;

	@Column(name = "lu_name")
	private String luName;

	@Column(name = "lu_notes")
	private String luNotes;

	@Column(name = "lu_oldip")
	private String luOldip;

	@Column(name = "lu_password")
	private String luPassword;

	@Column(name = "lu_password1")
	private String luPassword1;

	@Column(name = "lu_prepaidlimit")
	private int luPrepaidlimit;

	@Column(name = "lu_se_loccode")
	private String luSeLoccode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lu_startdate")
	private Date luStartdate;

	@Column(name = "lu_status")
	private String luStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lu_timea")
	private Date luTimea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lu_timee")
	private Date luTimee;

	@Column(name = "lu_userida")
	private String luUserida;

	@Column(name = "lu_useride")
	private String luUseride;

}