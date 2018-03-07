package com.webcps.webcps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcps.webcps.model.TrTiTransin;
import com.webcps.webcps.repository.TrTiTransinRepo;

@Service
public class DataServiceImpl implements DataService {
	
	@Autowired
	private TrTiTransinRepo dataRepository;
	
	
	public TrTiTransin find (String key){
		
		return this.dataRepository.findOne(key);
	}

}
