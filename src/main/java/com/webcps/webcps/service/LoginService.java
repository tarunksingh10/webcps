package com.webcps.webcps.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.webcps.webcps.model.UsLlLoglogin;
import com.webcps.webcps.model.UsLuListuser;
import com.webcps.webcps.model.UsUhUserhistory;
import com.webcps.webcps.model.UsUhUserhistoryPK;
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

	@Value("${spring.ipaddress}")
	private String ipaddress;

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
		// String hostip = null;
		if (usLuListuser.getLuStatus().trim().equals("A")) {

			// hostip = InetAddress.getLocalHost().getHostAddress().toString();
			if (usLuListuser.getLuLlType().equals("E")) {
				usLuListuser.setLuLlType("S");
				usLuListuser.setLuStartdate(new Date());
				usLuListuser.setLuEnddate(new Date(0000, 00, 00, 00, 00, 00));
				usLuListuser.setLuIpaddr(ipaddress);
			}
			addRecordUsLlLoglogin(usLuListuser);

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
		usLlLoglogin.setLL_NoTicketStart("");
		usLlLoglogin.setLL_NoTicketEnd("");
		usLlLoglogin.setLL_VT_Name("");
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
		// String hostip = null;
		if (usLuListuser.getLuStatus().trim().equals("A")) {
			if (usLuListuser.getLuLlType().equals("S")) {

				// hostip =
				// InetAddress.getLocalHost().getHostAddress().toString();
				usLuListuser.setLuStatus("P");
				usLuListuser.setLuLlType("E");
				usLuListuser.setLuEnddate(new Date());
				usLuListuser.setLuOldip(ipaddress);
				addRecordUsUhUserhistory(usLuListuser);

			} else if (usLuListuser.getLuLlType().equals("E")) {

			}
		}
	}

	private void addRecordUsUhUserhistory(UsLuListuser usLuListuser) {
		UsUhUserhistory usUhUserhistory = new UsUhUserhistory();
		UsUhUserhistoryPK usUhUserhistoryPK = new UsUhUserhistoryPK();
		usUhUserhistory.setLuCode(usLuListuser.getLuCode());
		usUhUserhistory.setLuInitial(usLuListuser.getLuInitial());
		usUhUserhistory.setLuUser(usLuListuser.getLuUser());
		usUhUserhistory.setLuName(usLuListuser.getLuName());
		usUhUserhistory.setLuPassword(usLuListuser.getLuPassword1());
		usUhUserhistory.setLuLvCode(usLuListuser.getLuLvCode());
		usUhUserhistory.setLuNotes(usLuListuser.getLuNotes());
		usUhUserhistory.setLuDpCode(usLuListuser.getLuDpCode());
		usUhUserhistory.setLuStatus("A");
		usUhUserhistory.setLuCreator("N");
		usUhUserhistory.setLuPrepaidlimit(0);
		usUhUserhistory.setLuAdjustlimit(0);
		usUhUserhistory.setLuIpaddr(usLuListuser.getLuIpaddr());
		usUhUserhistory.setLuOldip(usLuListuser.getLuOldip());
		usUhUserhistory.setLuSeLoccode("740");
		usUhUserhistory.setLuUseride(usLuListuser.getLuUseride());
		usUhUserhistory.setLuTimee(usLuListuser.getLuTimee());
		usUhUserhistory.setLuUserida("");
		usUhUserhistory.setLuTimea(usLuListuser.getLuTimea());
		usUhUserhistory.setLuBackup(0);
		usUhUserhistory.setLuAccess("O");
		usUhUserhistory.setLuLlType(usLuListuser.getLuLlType());

		usUhUserhistoryPK.setLuEnddate(usLuListuser.getLuEnddate());
		usUhUserhistoryPK.setLuStartdate(usLuListuser.getLuStartdate());
		usUhUserhistory.setId(usUhUserhistoryPK);

		usUhUserhistory.setLuSeod(new Date(0000, 00, 00, 00, 00, 00));
		usUhUserhistory.setLuEeod(new Date(0000, 00, 00, 00, 00, 00));
		usUhUserhistory.setLuRseod(new Date(0000, 00, 00, 00, 00, 00));
		usUhUserhistory.setLuReeod(new Date(0000, 00, 00, 00, 00, 00));
		usUhUserhistory.setLuCounter(0);
		usUhUserhistoryRepo.save(usUhUserhistory);
	}
}
