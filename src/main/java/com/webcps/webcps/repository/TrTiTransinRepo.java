package com.webcps.webcps.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webcps.webcps.model.TrTiTransin;

@Repository
public interface TrTiTransinRepo extends JpaRepository< TrTiTransin, Serializable> {
	
	
}
