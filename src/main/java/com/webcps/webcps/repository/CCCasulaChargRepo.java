package com.webcps.webcps.repository;

import java.sql.Time;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webcps.webcps.model.ChCcCasualcharge;

public interface CCCasulaChargRepo extends JpaRepository<ChCcCasualcharge, String> {
	
	
	 @Query("SELECT T FROM ChCcCasualcharge T WHERE T.ccVtName = :vechicalType AND T.ccValidday = :day_type AND "
		 		+ "T.ccActiveflag = 'A' AND T.ccStartdate<= :currdate "
		 		+ "AND T.ccStartlimit < :rtime AND T.ccEndlimit> :rtime") 
	 
	 ChCcCasualcharge findRateByParam(@Param("vechicalType") String vechicalType,@Param("day_type") String day_type, @Param("currdate") Date currdate, @Param("rtime") Time rtime);

	
}
