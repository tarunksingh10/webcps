package com.webcps.webcps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webcps.webcps.model.StSeSettingparameter;

public interface StSettingParamRepo extends JpaRepository<StSeSettingparameter, String> {
	
	
	@Query("SELECT se_membertype, se_loccode FROM st_se_settingparameter WHERE se_membertype in ('I','O','P')")
    public StSeSettingparameter findMemberType();
}
