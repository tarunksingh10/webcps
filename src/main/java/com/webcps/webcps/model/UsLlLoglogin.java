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
 * The persistent class for the us_ll_loglogin database table.
 * 
 */
@Entity
@Table(name = "us_ll_loglogin")
@NamedQuery(name = "UsLlLoglogin.findAll", query = "SELECT u FROM UsLlLoglogin u")
@Data
public class UsLlLoglogin implements Serializable {
	private static final long serialVersionUID = 1L;

	private int LL_BackUp;

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Date LL_DateTime;

	private String LL_Loc;

	private String LL_LW_User;

	private int LL_Modal;

	private String LL_NoTicketEnd;

	private String LL_NoTicketStart;

	private String LL_Settlement;

	@Column(name = "LL_SG_IP")
	private String llSgIp;

	private String LL_Type;

	private String LL_VT_Name;

}