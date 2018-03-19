package com.webcps.webcps.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Embeddable
@Data
public class UsUhUserhistoryPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lu_enddate")
	private Date luEnddate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lu_startdate")
	private Date luStartdate;

}
