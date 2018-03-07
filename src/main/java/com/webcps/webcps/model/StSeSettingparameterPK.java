package com.webcps.webcps.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the st_se_settingparameter database table.
 * 
 */
@Embeddable
public class StSeSettingparameterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="se_loccode")
	private String seLoccode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="se_timee")
	private java.util.Date seTimee;

	public StSeSettingparameterPK() {
	}
	public String getSeLoccode() {
		return this.seLoccode;
	}
	public void setSeLoccode(String seLoccode) {
		this.seLoccode = seLoccode;
	}
	public java.util.Date getSeTimee() {
		return this.seTimee;
	}
	public void setSeTimee(java.util.Date seTimee) {
		this.seTimee = seTimee;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StSeSettingparameterPK)) {
			return false;
		}
		StSeSettingparameterPK castOther = (StSeSettingparameterPK)other;
		return 
			this.seLoccode.equals(castOther.seLoccode)
			&& this.seTimee.equals(castOther.seTimee);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.seLoccode.hashCode();
		hash = hash * prime + this.seTimee.hashCode();
		
		return hash;
	}
}