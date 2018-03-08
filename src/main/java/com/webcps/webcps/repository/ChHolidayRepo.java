package com.webcps.webcps.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webcps.webcps.model.ChHlHolidayday;

public interface ChHolidayRepo extends JpaRepository<ChHlHolidayday, Date> {
	
	
}
