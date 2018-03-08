package com.webcps.webcps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webcps.webcps.model.StSeSettingparameter;

public interface StSettingParamRepo extends JpaRepository<StSeSettingparameter, String> {
	
	
	@Query("SELECT T FROM StSeSettingparameter T  WHERE T.seMembertype in ('I','O','P')")
    public StSeSettingparameter findMemberType();
}
