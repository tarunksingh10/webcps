package com.webcps.webcps.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the st_se_settingparameter database table.
 * 
 */
@Entity
@Table(name="st_se_settingparameter")
@NamedQuery(name="StSeSettingparameter.findAll", query="SELECT s FROM StSeSettingparameter s")
public class StSeSettingparameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StSeSettingparameterPK id;

	private String backupdir;

	private String ftpdirectory;

	private String ftphost;

	private String ftppassword;

	private String ftpuser;

	@Column(name="se_accno")
	private String seAccno;

	@Column(name="se_addr1")
	private String seAddr1;

	@Column(name="se_addr2")
	private String seAddr2;

	@Column(name="se_addr3")
	private String seAddr3;

	@Column(name="se_alertexpired")
	private int seAlertexpired;

	@Column(name="se_areacode")
	private String seAreacode;

	@Column(name="se_areaname")
	private String seAreaname;

	@Column(name="se_backup")
	private int seBackup;

	@Column(name="se_bankname")
	private String seBankname;

	@Column(name="se_baycapacity")
	private int seBaycapacity;

	@Column(name="se_cardassurance")
	private int seCardassurance;

	@Column(name="se_cardusenopolice")
	private byte seCardusenopolice;

	@Column(name="se_city")
	private String seCity;

	@Column(name="se_code")
	private String seCode;

	@Column(name="se_compname")
	private String seCompname;

	@Column(name="se_coname")
	private String seConame;

	@Column(name="se_contact")
	private String seContact;

	@Column(name="se_coregno")
	private String seCoregno;

	@Column(name="se_country")
	private String seCountry;

	@Column(name="se_curr")
	private String seCurr;

	@Column(name="se_dbname")
	private String seDbname;

	@Column(name="se_defpoliceno")
	private String seDefpoliceno;

	@Column(name="se_downpayment")
	private byte seDownpayment;

	@Column(name="se_durvalidcard")
	private int seDurvalidcard;

	@Column(name="se_eod")
	private Time seEod;

	@Column(name="se_faxno")
	private String seFaxno;

	@Column(name="se_firstmanualchg")
	private byte seFirstmanualchg;

	@Column(name="se_gc_name")
	private String seGcName;

	@Column(name="se_iin")
	private String seIin;

	@Column(name="se_imagedir")
	private String seImagedir;

	@Column(name="se_jv_code")
	private int seJvCode;

	@Column(name="se_language")
	private String seLanguage;

	@Column(name="se_lennoticket")
	private int seLennoticket;

	@Column(name="se_limitcancel")
	private int seLimitcancel;

	@Column(name="se_limitprepaid")
	private int seLimitprepaid;

	@Column(name="se_limitrefund")
	private int seLimitrefund;

	private String se_lo_nameB;

	private String se_lo_nameR;

	@Column(name="se_locname")
	private String seLocname;

	@Column(name="se_logdir")
	private String seLogdir;

	@Column(name="se_maxerrorinput")
	private int seMaxerrorinput;

	@Column(name="se_maxparkroom")
	private int seMaxparkroom;

	@Column(name="se_memberretention")
	private int seMemberretention;

	@Column(name="se_membertype")
	private String seMembertype;

	@Column(name="se_npwp")
	private String seNpwp;

	@Column(name="se_offday")
	private String seOffday;

	@Column(name="se_onretention")
	private int seOnretention;

	@Column(name="se_option")
	private String seOption;

	@Column(name="se_outputdir")
	private String seOutputdir;

	@Column(name="se_owntype")
	private int seOwntype;

	@Column(name="se_percentagetaxpark")
	private int sePercentagetaxpark;

	private int se_percentageTaxPPN;

	@Column(name="se_phoneno")
	private String sePhoneno;

	@Column(name="se_region")
	private String seRegion;

	@Column(name="se_residential")
	private int seResidential;

	@Column(name="se_retentiondbase")
	private int seRetentiondbase;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="se_startdate")
	private Date seStartdate;

	private int se_startnoCust;

	@Column(name="se_startnofaktur")
	private int seStartnofaktur;

	@Column(name="se_startnomember")
	private int seStartnomember;

	@Column(name="se_startnoprepaid")
	private int seStartnoprepaid;

	@Column(name="se_statcd")
	private String seStatcd;

	@Column(name="se_status")
	private String seStatus;

	@Column(name="se_subtype")
	private int seSubtype;

	private String SE_TaxParkBy;

	private String se_taxPPNby;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="se_timea")
	private Date seTimea;

	@Column(name="se_timeoutcentralpayment")
	private int seTimeoutcentralpayment;

	@Column(name="se_timeoutpasstru")
	private int seTimeoutpasstru;

	@Column(name="se_tolerancegig")
	private int seTolerancegig;

	@Column(name="se_totalcomplimentary")
	private int seTotalcomplimentary;

	@Column(name="se_totalgate")
	private int seTotalgate;

	@Column(name="se_totalshift")
	private int seTotalshift;

	@Column(name="se_trretention")
	private int seTrretention;

	@Column(name="se_useadvertising")
	private byte seUseadvertising;

	@Column(name="se_usebilling")
	private byte seUsebilling;

	@Column(name="se_usecentralpayment")
	private byte seUsecentralpayment;

	@Column(name="se_usecleaningservice")
	private byte seUsecleaningservice;

	@Column(name="se_usedispenser")
	private byte seUsedispenser;

	@Column(name="se_usedoorprize")
	private byte seUsedoorprize;

	@Column(name="se_usemember")
	private byte seUsemember;

	@Column(name="se_useovernight")
	private byte seUseovernight;

	@Column(name="se_useparking")
	private byte seUseparking;

	@Column(name="se_usepasstru")
	private byte seUsepasstru;

	@Column(name="se_useprepaid")
	private byte seUseprepaid;

	@Column(name="se_userefillprepaid")
	private byte seUserefillprepaid;

	@Column(name="se_userida")
	private String seUserida;

	@Column(name="se_useride")
	private String seUseride;

	@Column(name="se_usesecurity")
	private byte seUsesecurity;

	@Column(name="se_usesticker")
	private byte seUsesticker;

	@Column(name="se_usesubparking")
	private byte seUsesubparking;

	@Column(name="se_usesubvalet")
	private byte seUsesubvalet;

	@Column(name="se_usetax")
	private byte seUsetax;

	@Column(name="se_usevalet")
	private byte seUsevalet;

	@Column(name="se_usevoucher")
	private byte seUsevoucher;

	@Column(name="se_vipcardusenopol")
	private byte seVipcardusenopol;

	@Column(name="se_zipcode")
	private String seZipcode;

	private String uploaddir;

	public StSeSettingparameter() {
	}

	public StSeSettingparameterPK getId() {
		return this.id;
	}

	public void setId(StSeSettingparameterPK id) {
		this.id = id;
	}

	public String getBackupdir() {
		return this.backupdir;
	}

	public void setBackupdir(String backupdir) {
		this.backupdir = backupdir;
	}

	public String getFtpdirectory() {
		return this.ftpdirectory;
	}

	public void setFtpdirectory(String ftpdirectory) {
		this.ftpdirectory = ftpdirectory;
	}

	public String getFtphost() {
		return this.ftphost;
	}

	public void setFtphost(String ftphost) {
		this.ftphost = ftphost;
	}

	public String getFtppassword() {
		return this.ftppassword;
	}

	public void setFtppassword(String ftppassword) {
		this.ftppassword = ftppassword;
	}

	public String getFtpuser() {
		return this.ftpuser;
	}

	public void setFtpuser(String ftpuser) {
		this.ftpuser = ftpuser;
	}

	public String getSeAccno() {
		return this.seAccno;
	}

	public void setSeAccno(String seAccno) {
		this.seAccno = seAccno;
	}

	public String getSeAddr1() {
		return this.seAddr1;
	}

	public void setSeAddr1(String seAddr1) {
		this.seAddr1 = seAddr1;
	}

	public String getSeAddr2() {
		return this.seAddr2;
	}

	public void setSeAddr2(String seAddr2) {
		this.seAddr2 = seAddr2;
	}

	public String getSeAddr3() {
		return this.seAddr3;
	}

	public void setSeAddr3(String seAddr3) {
		this.seAddr3 = seAddr3;
	}

	public int getSeAlertexpired() {
		return this.seAlertexpired;
	}

	public void setSeAlertexpired(int seAlertexpired) {
		this.seAlertexpired = seAlertexpired;
	}

	public String getSeAreacode() {
		return this.seAreacode;
	}

	public void setSeAreacode(String seAreacode) {
		this.seAreacode = seAreacode;
	}

	public String getSeAreaname() {
		return this.seAreaname;
	}

	public void setSeAreaname(String seAreaname) {
		this.seAreaname = seAreaname;
	}

	public int getSeBackup() {
		return this.seBackup;
	}

	public void setSeBackup(int seBackup) {
		this.seBackup = seBackup;
	}

	public String getSeBankname() {
		return this.seBankname;
	}

	public void setSeBankname(String seBankname) {
		this.seBankname = seBankname;
	}

	public int getSeBaycapacity() {
		return this.seBaycapacity;
	}

	public void setSeBaycapacity(int seBaycapacity) {
		this.seBaycapacity = seBaycapacity;
	}

	public int getSeCardassurance() {
		return this.seCardassurance;
	}

	public void setSeCardassurance(int seCardassurance) {
		this.seCardassurance = seCardassurance;
	}

	public byte getSeCardusenopolice() {
		return this.seCardusenopolice;
	}

	public void setSeCardusenopolice(byte seCardusenopolice) {
		this.seCardusenopolice = seCardusenopolice;
	}

	public String getSeCity() {
		return this.seCity;
	}

	public void setSeCity(String seCity) {
		this.seCity = seCity;
	}

	public String getSeCode() {
		return this.seCode;
	}

	public void setSeCode(String seCode) {
		this.seCode = seCode;
	}

	public String getSeCompname() {
		return this.seCompname;
	}

	public void setSeCompname(String seCompname) {
		this.seCompname = seCompname;
	}

	public String getSeConame() {
		return this.seConame;
	}

	public void setSeConame(String seConame) {
		this.seConame = seConame;
	}

	public String getSeContact() {
		return this.seContact;
	}

	public void setSeContact(String seContact) {
		this.seContact = seContact;
	}

	public String getSeCoregno() {
		return this.seCoregno;
	}

	public void setSeCoregno(String seCoregno) {
		this.seCoregno = seCoregno;
	}

	public String getSeCountry() {
		return this.seCountry;
	}

	public void setSeCountry(String seCountry) {
		this.seCountry = seCountry;
	}

	public String getSeCurr() {
		return this.seCurr;
	}

	public void setSeCurr(String seCurr) {
		this.seCurr = seCurr;
	}

	public String getSeDbname() {
		return this.seDbname;
	}

	public void setSeDbname(String seDbname) {
		this.seDbname = seDbname;
	}

	public String getSeDefpoliceno() {
		return this.seDefpoliceno;
	}

	public void setSeDefpoliceno(String seDefpoliceno) {
		this.seDefpoliceno = seDefpoliceno;
	}

	public byte getSeDownpayment() {
		return this.seDownpayment;
	}

	public void setSeDownpayment(byte seDownpayment) {
		this.seDownpayment = seDownpayment;
	}

	public int getSeDurvalidcard() {
		return this.seDurvalidcard;
	}

	public void setSeDurvalidcard(int seDurvalidcard) {
		this.seDurvalidcard = seDurvalidcard;
	}

	public Time getSeEod() {
		return this.seEod;
	}

	public void setSeEod(Time seEod) {
		this.seEod = seEod;
	}

	public String getSeFaxno() {
		return this.seFaxno;
	}

	public void setSeFaxno(String seFaxno) {
		this.seFaxno = seFaxno;
	}

	public byte getSeFirstmanualchg() {
		return this.seFirstmanualchg;
	}

	public void setSeFirstmanualchg(byte seFirstmanualchg) {
		this.seFirstmanualchg = seFirstmanualchg;
	}

	public String getSeGcName() {
		return this.seGcName;
	}

	public void setSeGcName(String seGcName) {
		this.seGcName = seGcName;
	}

	public String getSeIin() {
		return this.seIin;
	}

	public void setSeIin(String seIin) {
		this.seIin = seIin;
	}

	public String getSeImagedir() {
		return this.seImagedir;
	}

	public void setSeImagedir(String seImagedir) {
		this.seImagedir = seImagedir;
	}

	public int getSeJvCode() {
		return this.seJvCode;
	}

	public void setSeJvCode(int seJvCode) {
		this.seJvCode = seJvCode;
	}

	public String getSeLanguage() {
		return this.seLanguage;
	}

	public void setSeLanguage(String seLanguage) {
		this.seLanguage = seLanguage;
	}

	public int getSeLennoticket() {
		return this.seLennoticket;
	}

	public void setSeLennoticket(int seLennoticket) {
		this.seLennoticket = seLennoticket;
	}

	public int getSeLimitcancel() {
		return this.seLimitcancel;
	}

	public void setSeLimitcancel(int seLimitcancel) {
		this.seLimitcancel = seLimitcancel;
	}

	public int getSeLimitprepaid() {
		return this.seLimitprepaid;
	}

	public void setSeLimitprepaid(int seLimitprepaid) {
		this.seLimitprepaid = seLimitprepaid;
	}

	public int getSeLimitrefund() {
		return this.seLimitrefund;
	}

	public void setSeLimitrefund(int seLimitrefund) {
		this.seLimitrefund = seLimitrefund;
	}

	public String getSe_lo_nameB() {
		return this.se_lo_nameB;
	}

	public void setSe_lo_nameB(String se_lo_nameB) {
		this.se_lo_nameB = se_lo_nameB;
	}

	public String getSe_lo_nameR() {
		return this.se_lo_nameR;
	}

	public void setSe_lo_nameR(String se_lo_nameR) {
		this.se_lo_nameR = se_lo_nameR;
	}

	public String getSeLocname() {
		return this.seLocname;
	}

	public void setSeLocname(String seLocname) {
		this.seLocname = seLocname;
	}

	public String getSeLogdir() {
		return this.seLogdir;
	}

	public void setSeLogdir(String seLogdir) {
		this.seLogdir = seLogdir;
	}

	public int getSeMaxerrorinput() {
		return this.seMaxerrorinput;
	}

	public void setSeMaxerrorinput(int seMaxerrorinput) {
		this.seMaxerrorinput = seMaxerrorinput;
	}

	public int getSeMaxparkroom() {
		return this.seMaxparkroom;
	}

	public void setSeMaxparkroom(int seMaxparkroom) {
		this.seMaxparkroom = seMaxparkroom;
	}

	public int getSeMemberretention() {
		return this.seMemberretention;
	}

	public void setSeMemberretention(int seMemberretention) {
		this.seMemberretention = seMemberretention;
	}

	public String getSeMembertype() {
		return this.seMembertype;
	}

	public void setSeMembertype(String seMembertype) {
		this.seMembertype = seMembertype;
	}

	public String getSeNpwp() {
		return this.seNpwp;
	}

	public void setSeNpwp(String seNpwp) {
		this.seNpwp = seNpwp;
	}

	public String getSeOffday() {
		return this.seOffday;
	}

	public void setSeOffday(String seOffday) {
		this.seOffday = seOffday;
	}

	public int getSeOnretention() {
		return this.seOnretention;
	}

	public void setSeOnretention(int seOnretention) {
		this.seOnretention = seOnretention;
	}

	public String getSeOption() {
		return this.seOption;
	}

	public void setSeOption(String seOption) {
		this.seOption = seOption;
	}

	public String getSeOutputdir() {
		return this.seOutputdir;
	}

	public void setSeOutputdir(String seOutputdir) {
		this.seOutputdir = seOutputdir;
	}

	public int getSeOwntype() {
		return this.seOwntype;
	}

	public void setSeOwntype(int seOwntype) {
		this.seOwntype = seOwntype;
	}

	public int getSePercentagetaxpark() {
		return this.sePercentagetaxpark;
	}

	public void setSePercentagetaxpark(int sePercentagetaxpark) {
		this.sePercentagetaxpark = sePercentagetaxpark;
	}

	public int getSe_percentageTaxPPN() {
		return this.se_percentageTaxPPN;
	}

	public void setSe_percentageTaxPPN(int se_percentageTaxPPN) {
		this.se_percentageTaxPPN = se_percentageTaxPPN;
	}

	public String getSePhoneno() {
		return this.sePhoneno;
	}

	public void setSePhoneno(String sePhoneno) {
		this.sePhoneno = sePhoneno;
	}

	public String getSeRegion() {
		return this.seRegion;
	}

	public void setSeRegion(String seRegion) {
		this.seRegion = seRegion;
	}

	public int getSeResidential() {
		return this.seResidential;
	}

	public void setSeResidential(int seResidential) {
		this.seResidential = seResidential;
	}

	public int getSeRetentiondbase() {
		return this.seRetentiondbase;
	}

	public void setSeRetentiondbase(int seRetentiondbase) {
		this.seRetentiondbase = seRetentiondbase;
	}

	public Date getSeStartdate() {
		return this.seStartdate;
	}

	public void setSeStartdate(Date seStartdate) {
		this.seStartdate = seStartdate;
	}

	public int getSe_startnoCust() {
		return this.se_startnoCust;
	}

	public void setSe_startnoCust(int se_startnoCust) {
		this.se_startnoCust = se_startnoCust;
	}

	public int getSeStartnofaktur() {
		return this.seStartnofaktur;
	}

	public void setSeStartnofaktur(int seStartnofaktur) {
		this.seStartnofaktur = seStartnofaktur;
	}

	public int getSeStartnomember() {
		return this.seStartnomember;
	}

	public void setSeStartnomember(int seStartnomember) {
		this.seStartnomember = seStartnomember;
	}

	public int getSeStartnoprepaid() {
		return this.seStartnoprepaid;
	}

	public void setSeStartnoprepaid(int seStartnoprepaid) {
		this.seStartnoprepaid = seStartnoprepaid;
	}

	public String getSeStatcd() {
		return this.seStatcd;
	}

	public void setSeStatcd(String seStatcd) {
		this.seStatcd = seStatcd;
	}

	public String getSeStatus() {
		return this.seStatus;
	}

	public void setSeStatus(String seStatus) {
		this.seStatus = seStatus;
	}

	public int getSeSubtype() {
		return this.seSubtype;
	}

	public void setSeSubtype(int seSubtype) {
		this.seSubtype = seSubtype;
	}

	public String getSE_TaxParkBy() {
		return this.SE_TaxParkBy;
	}

	public void setSE_TaxParkBy(String SE_TaxParkBy) {
		this.SE_TaxParkBy = SE_TaxParkBy;
	}

	public String getSe_taxPPNby() {
		return this.se_taxPPNby;
	}

	public void setSe_taxPPNby(String se_taxPPNby) {
		this.se_taxPPNby = se_taxPPNby;
	}

	public Date getSeTimea() {
		return this.seTimea;
	}

	public void setSeTimea(Date seTimea) {
		this.seTimea = seTimea;
	}

	public int getSeTimeoutcentralpayment() {
		return this.seTimeoutcentralpayment;
	}

	public void setSeTimeoutcentralpayment(int seTimeoutcentralpayment) {
		this.seTimeoutcentralpayment = seTimeoutcentralpayment;
	}

	public int getSeTimeoutpasstru() {
		return this.seTimeoutpasstru;
	}

	public void setSeTimeoutpasstru(int seTimeoutpasstru) {
		this.seTimeoutpasstru = seTimeoutpasstru;
	}

	public int getSeTolerancegig() {
		return this.seTolerancegig;
	}

	public void setSeTolerancegig(int seTolerancegig) {
		this.seTolerancegig = seTolerancegig;
	}

	public int getSeTotalcomplimentary() {
		return this.seTotalcomplimentary;
	}

	public void setSeTotalcomplimentary(int seTotalcomplimentary) {
		this.seTotalcomplimentary = seTotalcomplimentary;
	}

	public int getSeTotalgate() {
		return this.seTotalgate;
	}

	public void setSeTotalgate(int seTotalgate) {
		this.seTotalgate = seTotalgate;
	}

	public int getSeTotalshift() {
		return this.seTotalshift;
	}

	public void setSeTotalshift(int seTotalshift) {
		this.seTotalshift = seTotalshift;
	}

	public int getSeTrretention() {
		return this.seTrretention;
	}

	public void setSeTrretention(int seTrretention) {
		this.seTrretention = seTrretention;
	}

	public byte getSeUseadvertising() {
		return this.seUseadvertising;
	}

	public void setSeUseadvertising(byte seUseadvertising) {
		this.seUseadvertising = seUseadvertising;
	}

	public byte getSeUsebilling() {
		return this.seUsebilling;
	}

	public void setSeUsebilling(byte seUsebilling) {
		this.seUsebilling = seUsebilling;
	}

	public byte getSeUsecentralpayment() {
		return this.seUsecentralpayment;
	}

	public void setSeUsecentralpayment(byte seUsecentralpayment) {
		this.seUsecentralpayment = seUsecentralpayment;
	}

	public byte getSeUsecleaningservice() {
		return this.seUsecleaningservice;
	}

	public void setSeUsecleaningservice(byte seUsecleaningservice) {
		this.seUsecleaningservice = seUsecleaningservice;
	}

	public byte getSeUsedispenser() {
		return this.seUsedispenser;
	}

	public void setSeUsedispenser(byte seUsedispenser) {
		this.seUsedispenser = seUsedispenser;
	}

	public byte getSeUsedoorprize() {
		return this.seUsedoorprize;
	}

	public void setSeUsedoorprize(byte seUsedoorprize) {
		this.seUsedoorprize = seUsedoorprize;
	}

	public byte getSeUsemember() {
		return this.seUsemember;
	}

	public void setSeUsemember(byte seUsemember) {
		this.seUsemember = seUsemember;
	}

	public byte getSeUseovernight() {
		return this.seUseovernight;
	}

	public void setSeUseovernight(byte seUseovernight) {
		this.seUseovernight = seUseovernight;
	}

	public byte getSeUseparking() {
		return this.seUseparking;
	}

	public void setSeUseparking(byte seUseparking) {
		this.seUseparking = seUseparking;
	}

	public byte getSeUsepasstru() {
		return this.seUsepasstru;
	}

	public void setSeUsepasstru(byte seUsepasstru) {
		this.seUsepasstru = seUsepasstru;
	}

	public byte getSeUseprepaid() {
		return this.seUseprepaid;
	}

	public void setSeUseprepaid(byte seUseprepaid) {
		this.seUseprepaid = seUseprepaid;
	}

	public byte getSeUserefillprepaid() {
		return this.seUserefillprepaid;
	}

	public void setSeUserefillprepaid(byte seUserefillprepaid) {
		this.seUserefillprepaid = seUserefillprepaid;
	}

	public String getSeUserida() {
		return this.seUserida;
	}

	public void setSeUserida(String seUserida) {
		this.seUserida = seUserida;
	}

	public String getSeUseride() {
		return this.seUseride;
	}

	public void setSeUseride(String seUseride) {
		this.seUseride = seUseride;
	}

	public byte getSeUsesecurity() {
		return this.seUsesecurity;
	}

	public void setSeUsesecurity(byte seUsesecurity) {
		this.seUsesecurity = seUsesecurity;
	}

	public byte getSeUsesticker() {
		return this.seUsesticker;
	}

	public void setSeUsesticker(byte seUsesticker) {
		this.seUsesticker = seUsesticker;
	}

	public byte getSeUsesubparking() {
		return this.seUsesubparking;
	}

	public void setSeUsesubparking(byte seUsesubparking) {
		this.seUsesubparking = seUsesubparking;
	}

	public byte getSeUsesubvalet() {
		return this.seUsesubvalet;
	}

	public void setSeUsesubvalet(byte seUsesubvalet) {
		this.seUsesubvalet = seUsesubvalet;
	}

	public byte getSeUsetax() {
		return this.seUsetax;
	}

	public void setSeUsetax(byte seUsetax) {
		this.seUsetax = seUsetax;
	}

	public byte getSeUsevalet() {
		return this.seUsevalet;
	}

	public void setSeUsevalet(byte seUsevalet) {
		this.seUsevalet = seUsevalet;
	}

	public byte getSeUsevoucher() {
		return this.seUsevoucher;
	}

	public void setSeUsevoucher(byte seUsevoucher) {
		this.seUsevoucher = seUsevoucher;
	}

	public byte getSeVipcardusenopol() {
		return this.seVipcardusenopol;
	}

	public void setSeVipcardusenopol(byte seVipcardusenopol) {
		this.seVipcardusenopol = seVipcardusenopol;
	}

	public String getSeZipcode() {
		return this.seZipcode;
	}

	public void setSeZipcode(String seZipcode) {
		this.seZipcode = seZipcode;
	}

	public String getUploaddir() {
		return this.uploaddir;
	}

	public void setUploaddir(String uploaddir) {
		this.uploaddir = uploaddir;
	}

}