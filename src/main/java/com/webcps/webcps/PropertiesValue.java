package com.webcps.webcps;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesValue {
	
	@Value("${spring.ipaddress}")
	private String ipaddress;
	
	@PostConstruct
	
	public void print(){
		System.out.println(ipaddress);
	}
}
