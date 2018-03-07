package com.webcps.webcps.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcps.webcps.model.UsLlLoglogin;
import com.webcps.webcps.model.UsLuListuser;
import com.webcps.webcps.repository.UsLlLogloginRepo;
import com.webcps.webcps.repository.UsLuListuserRepo;
import com.webcps.webcps.repository.UsUhUserhistoryRepo;

@Service
public class LoginService {

	@Autowired
	private UsLuListuserRepo usLuListuserRepo;

	@Autowired
	private UsUhUserhistoryRepo usUhUserhistoryRepo;

	@Autowired
	private UsLlLogloginRepo usLlLogloginRepo;

	public String userAuthentication(String user, String password) {
		UsLuListuser usLuListuser = usLuListuserRepo.findOne(user);
		if (usLuListuser == null || !usLuListuser.getLuPassword1().equals(password))
			return "Username Password Doesnt Match";
		else if (!usLuListuser.getLuStatus().trim().equals("A")) {
			return "User is inactive";
		}
		return null;
	}

	public void afterLogin(String user) {
		UsLuListuser usLuListuser = usLuListuserRepo.findOne(user);
		String hostip = null;
		if (usLuListuser.getLuStatus().trim().equals("A")) {
			try {
				hostip = InetAddress.getLocalHost().getHostAddress().toString();
				if (usLuListuser.getLuLlType().equals("E")) {
					usLuListuser.setLuLlType("S");
					usLuListuser.setLuStartdate(new Date());
					usLuListuser.setLuEnddate(new Date(0000, 00, 00, 00, 00, 00));
					usLuListuser.setLuIpaddr(hostip);
				}
				addRecordUsLlLoglogin(usLuListuser);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}

	}

	private void addRecordUsLlLoglogin(UsLuListuser usLuListuser) {
		UsLlLoglogin usLlLoglogin = new UsLlLoglogin();
		usLlLoglogin.setLlSgIp(usLuListuser.getLuIpaddr());
		usLlLoglogin.setLL_LW_User(usLuListuser.getLuUser());
		usLlLoglogin.setLL_Type(usLuListuser.getLuLlType());
		usLlLoglogin.setLL_DateTime(new Date());
		usLlLoglogin.setLL_BackUp(0);
		usLlLoglogin.setLL_Modal(0);
		usLlLoglogin.setLL_Loc("740");
		usLlLoglogin.setLL_Settlement("N");
		usLlLogloginRepo.save(usLlLoglogin);
	}

	public void logout(String user) {
		UsLuListuser usLuListuser = usLuListuserRepo.findOne(user);
		if (usLuListuser.getLuStatus().trim().equals("A")) {
			addRecordUsLlLoglogin(usLuListuser);
		}

	}

	public void endShift(String user) {
		UsLuListuser usLuListuser = usLuListuserRepo.findOne(user);
		String hostip = null;
		if (usLuListuser.getLuStatus().trim().equals("A")) {
			if (usLuListuser.getLuLlType().equals("S")) {
				try {
					hostip = InetAddress.getLocalHost().getHostAddress().toString();
					usLuListuser.setLuStatus("P");
					usLuListuser.setLuLlType("E");
					usLuListuser.setLuEnddate(new Date());
					usLuListuser.setLuOldip(hostip);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}

			} else if (usLuListuser.getLuLlType().equals("E")) {

			}
		}
	}
}
