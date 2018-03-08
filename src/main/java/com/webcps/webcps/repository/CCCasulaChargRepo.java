package com.webcps.webcps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webcps.webcps.model.ChCcCasualcharge;

public interface CCCasulaChargRepo extends JpaRepository<ChCcCasualcharge, String> {
	
	
	 @Query("SELECT T FROM ChCcCasualcharge WHERE T.ccVtName = :vechicalType AND T.ccValidday = :day_type AND "
		 		+ "T.ccActiveflag = 'A' AND T.ccStartdate<= :currdate "
		 		+ "AND T.ccStartlimit < :rtime AND ccEndlimit> :rtime") 
	 
	 ChCcCasualcharge findRateByParam(@Param("vechicalType") String vechicalType,@Param("day_type") String day_type, @Param("currdate") String currdate, @Param("rtime") String rtime);

	
}
