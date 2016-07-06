package foodportal.front.safefoodlife.foodadditive.vo;

import java.sql.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class FoodAdditiveBasisInfoVO {
	
	// FOOD_ADTV_BASS_INFO
	private int			adtv_cd;
	private String		adtv_nm;
	private String		adtv_eng_nm;
	private String		ncknm;
	private String		stctr;
	private String		chmsfod;
	private String		mcwgh;
	private String		cas_no;
	private String		ins_no;
	private String		eu_no;
	private String		main_prpos;
	private String		origin;
	private String		physic_chmcl_chartr;
	private String		mnf_mthd;
	private int			procs_ordno;
	private String		procs_cl;
	private String		fema_no;
	private String		use_accdt;
	private String		jecfa_evl;
	private String		toxcty_data;
	
	// FOOD_ADTV_RVLV
	//private int			adtv_cd;
	private String		dfn;
	private String		irdnt;
	//private String		ncknm;
	private String		cont;
	private String		dispos;
	private String		cnfm_test;
	private String		puredo_test;
	private String		fdqntlaw_dvs;
	private String		fdqntlaw;
	private String		use_stdr;
	private String		itm_nm_a;
	private String		itm_cn_a;
	private String		itm_nm_b;
	private String		itm_cn_b;
	private String		itm_nm_c;
	private String		itm_cn_c;
	private String		itm_nm_d;
	private String		itm_cn_d;
	private String		itm_nm_k;
	private String		itm_cn_k;
	private String		itm_nm_l;
	private String		itm_cn_l;
	private String		fdqntlaw1;
	private String		use_stdr_itm_nm;
	private String		itm_cn_a_1;
	private String		itm_cn_b_1;
	private String		dispos_1;
	private String		use_stdr_1;
	private String		itm_cn_c_1;
	private String		itm_cn_d_1;
	private String		itm_cn_k_1;
	private String		itm_cn_l_1;
	
	// FOOD_ADTV_CFR_DTL
	//private int			adtv_cd;
	private String		cfr_no;
	//private String		mnf_mthd;
	private String		dtl_desc;
	private String		list_exps_yn;
	
	// FOOD_ADTV_PRDAN_BASS_INFO_REFO
	private int			ordno;
	private String		reform_dvs;
	private String		reform_reason;
	//private int			adtv_cd;
	private int			reform_no;
	
	// FOOD_ADTV_STDR_AND_STND_REFORM
	//private int			ordno;
	private String		ntfc_dt;
	private String		cn;
	private String		atch_file_nm;
	private int			indct_ord;
	private Date		cret_dtm;
	private String		ntfc_no;
	
	// FOOD_ADTV_JECFA_DTL
	private String		chmsnm;
	private String		prpos;
	private String		list_indct_yn;
	private String		dfn_1;
	private String		fdqntlaw_1;
	
	// FOOD_ADTV_FCC_UNISTA_OCLCMPD
	private String		puredo_test2;
	private String		frmlc_and_save_1;
	
	// FOOD_ADTV_EU_DTL
	private String		eu_legacy_list;
	
	// FOOD_ADTV_JAPAN_OCLCMPD
	private String		ignit_remn_rate;
	private String		itm_nm_e;
	private String		itm_cn_e;
	private String		itm_nm_f;
	private String		itm_cn_f;
	private String		itm_nm_g;
	private String		itm_cn_g;
	private String		itm_nm_h;
	private String		itm_cn_h;
	private String		itm_nm_i;
	private String		itm_cn_i;
	private String		itm_nm_j;
	private String		itm_cn_j;
	private String		dry_reductn;
	
	// FOOD_ADTV_CFR_USE_STDR
	private int			use_no;
	private String		cfr_cd;
	private String		use_food;
	private String		used;
	
	// FOOD_ADTV_CDX_USE_STDR
	private String		obj_food;
	private String		mxmm_perm_volum;
	
	// FOOD_ADTV_RVLV_SPICE
	private String		manage_no;
	private String		mttr_nm;
	private String		jecfa_no;
	private String		eu_fl_no;
	private String		eu_chms_grp;
	
	// Serial
	private int			com_serial;
	private int			gong_serial;
	private int			fcc_serial;
	private int			eu_serial;
	private int			cfr_serial;
	private int			ja_serial;
	private int			safety_serial;
	private int			jecfa_serial;
	private int			codex_serial;
	
	private int			totalCount;
	
	private int			page;
	private int			startidx;
	private int			endidx;
	
	private String		page_gubun;
	
	private String		keyfield;
	private String		key;
	
	private String		startword;
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public int getAdtv_cd() {
		return adtv_cd;
	}

	public void setAdtv_cd(int adtv_cd) {
		this.adtv_cd = adtv_cd;
	}

	public String getAdtv_nm() {
		return adtv_nm;
	}

	public void setAdtv_nm(String adtv_nm) {
		this.adtv_nm = adtv_nm;
	}

	public String getAdtv_eng_nm() {
		return adtv_eng_nm;
	}

	public void setAdtv_eng_nm(String adtv_eng_nm) {
		this.adtv_eng_nm = adtv_eng_nm;
	}

	public String getNcknm() {
		return ncknm;
	}

	public void setNcknm(String ncknm) {
		this.ncknm = ncknm;
	}

	public String getStctr() {
		return stctr;
	}

	public void setStctr(String stctr) {
		this.stctr = stctr;
	}

	public String getChmsfod() {
		return chmsfod;
	}

	public void setChmsfod(String chmsfod) {
		this.chmsfod = chmsfod;
	}

	public String getMcwgh() {
		return mcwgh;
	}

	public void setMcwgh(String mcwgh) {
		this.mcwgh = mcwgh;
	}

	public String getCas_no() {
		return cas_no;
	}

	public void setCas_no(String cas_no) {
		this.cas_no = cas_no;
	}

	public String getIns_no() {
		return ins_no;
	}

	public void setIns_no(String ins_no) {
		this.ins_no = ins_no;
	}

	public String getEu_no() {
		return eu_no;
	}

	public void setEu_no(String eu_no) {
		this.eu_no = eu_no;
	}

	public String getMain_prpos() {
		return main_prpos;
	}

	public void setMain_prpos(String main_prpos) {
		this.main_prpos = main_prpos;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getPhysic_chmcl_chartr() {
		return physic_chmcl_chartr;
	}

	public void setPhysic_chmcl_chartr(String physic_chmcl_chartr) {
		this.physic_chmcl_chartr = physic_chmcl_chartr;
	}

	public String getMnf_mthd() {
		return mnf_mthd;
	}

	public void setMnf_mthd(String mnf_mthd) {
		this.mnf_mthd = mnf_mthd;
	}

	public int getProcs_ordno() {
		return procs_ordno;
	}

	public void setProcs_ordno(int procs_ordno) {
		this.procs_ordno = procs_ordno;
	}

	public String getProcs_cl() {
		return procs_cl;
	}

	public void setProcs_cl(String procs_cl) {
		this.procs_cl = procs_cl;
	}

	public String getFema_no() {
		return fema_no;
	}

	public void setFema_no(String fema_no) {
		this.fema_no = fema_no;
	}

	public String getUse_accdt() {
		return use_accdt;
	}

	public void setUse_accdt(String use_accdt) {
		this.use_accdt = use_accdt;
	}

	public String getJecfa_evl() {
		return jecfa_evl;
	}

	public void setJecfa_evl(String jecfa_evl) {
		this.jecfa_evl = jecfa_evl;
	}

	public String getToxcty_data() {
		return toxcty_data;
	}

	public void setToxcty_data(String toxcty_data) {
		this.toxcty_data = toxcty_data;
	}

	public String getDfn() {
		return dfn;
	}

	public void setDfn(String dfn) {
		this.dfn = dfn;
	}

	public String getIrdnt() {
		return irdnt;
	}

	public void setIrdnt(String irdnt) {
		this.irdnt = irdnt;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public String getDispos() {
		return dispos;
	}

	public void setDispos(String dispos) {
		this.dispos = dispos;
	}

	public String getCnfm_test() {
		return cnfm_test;
	}

	public void setCnfm_test(String cnfm_test) {
		this.cnfm_test = cnfm_test;
	}

	public String getPuredo_test() {
		return puredo_test;
	}

	public void setPuredo_test(String puredo_test) {
		this.puredo_test = puredo_test;
	}

	public String getFdqntlaw_dvs() {
		return fdqntlaw_dvs;
	}

	public void setFdqntlaw_dvs(String fdqntlaw_dvs) {
		this.fdqntlaw_dvs = fdqntlaw_dvs;
	}

	public String getFdqntlaw() {
		return fdqntlaw;
	}

	public void setFdqntlaw(String fdqntlaw) {
		this.fdqntlaw = fdqntlaw;
	}

	public String getUse_stdr() {
		return use_stdr;
	}

	public void setUse_stdr(String use_stdr) {
		this.use_stdr = use_stdr;
	}

	public String getItm_nm_a() {
		return itm_nm_a;
	}

	public void setItm_nm_a(String itm_nm_a) {
		this.itm_nm_a = itm_nm_a;
	}

	public String getItm_cn_a() {
		return itm_cn_a;
	}

	public void setItm_cn_a(String itm_cn_a) {
		this.itm_cn_a = itm_cn_a;
	}

	public String getItm_nm_b() {
		return itm_nm_b;
	}

	public void setItm_nm_b(String itm_nm_b) {
		this.itm_nm_b = itm_nm_b;
	}

	public String getItm_cn_b() {
		return itm_cn_b;
	}

	public void setItm_cn_b(String itm_cn_b) {
		this.itm_cn_b = itm_cn_b;
	}

	public String getItm_nm_c() {
		return itm_nm_c;
	}

	public void setItm_nm_c(String itm_nm_c) {
		this.itm_nm_c = itm_nm_c;
	}

	public String getItm_cn_c() {
		return itm_cn_c;
	}

	public void setItm_cn_c(String itm_cn_c) {
		this.itm_cn_c = itm_cn_c;
	}

	public String getItm_nm_d() {
		return itm_nm_d;
	}

	public void setItm_nm_d(String itm_nm_d) {
		this.itm_nm_d = itm_nm_d;
	}

	public String getItm_cn_d() {
		return itm_cn_d;
	}

	public void setItm_cn_d(String itm_cn_d) {
		this.itm_cn_d = itm_cn_d;
	}

	public String getItm_nm_k() {
		return itm_nm_k;
	}

	public void setItm_nm_k(String itm_nm_k) {
		this.itm_nm_k = itm_nm_k;
	}

	public String getItm_cn_k() {
		return itm_cn_k;
	}

	public void setItm_cn_k(String itm_cn_k) {
		this.itm_cn_k = itm_cn_k;
	}

	public String getItm_nm_l() {
		return itm_nm_l;
	}

	public void setItm_nm_l(String itm_nm_l) {
		this.itm_nm_l = itm_nm_l;
	}

	public String getItm_cn_l() {
		return itm_cn_l;
	}

	public void setItm_cn_l(String itm_cn_l) {
		this.itm_cn_l = itm_cn_l;
	}

	public String getFdqntlaw1() {
		return fdqntlaw1;
	}

	public void setFdqntlaw1(String fdqntlaw1) {
		this.fdqntlaw1 = fdqntlaw1;
	}

	public String getUse_stdr_itm_nm() {
		return use_stdr_itm_nm;
	}

	public void setUse_stdr_itm_nm(String use_stdr_itm_nm) {
		this.use_stdr_itm_nm = use_stdr_itm_nm;
	}

	public String getItm_cn_a_1() {
		return itm_cn_a_1;
	}

	public void setItm_cn_a_1(String itm_cn_a_1) {
		this.itm_cn_a_1 = itm_cn_a_1;
	}

	public String getItm_cn_b_1() {
		return itm_cn_b_1;
	}

	public void setItm_cn_b_1(String itm_cn_b_1) {
		this.itm_cn_b_1 = itm_cn_b_1;
	}

	public String getDispos_1() {
		return dispos_1;
	}

	public void setDispos_1(String dispos_1) {
		this.dispos_1 = dispos_1;
	}

	public String getUse_stdr_1() {
		return use_stdr_1;
	}

	public void setUse_stdr_1(String use_stdr_1) {
		this.use_stdr_1 = use_stdr_1;
	}

	public String getItm_cn_c_1() {
		return itm_cn_c_1;
	}

	public void setItm_cn_c_1(String itm_cn_c_1) {
		this.itm_cn_c_1 = itm_cn_c_1;
	}

	public String getItm_cn_d_1() {
		return itm_cn_d_1;
	}

	public void setItm_cn_d_1(String itm_cn_d_1) {
		this.itm_cn_d_1 = itm_cn_d_1;
	}

	public String getItm_cn_k_1() {
		return itm_cn_k_1;
	}

	public void setItm_cn_k_1(String itm_cn_k_1) {
		this.itm_cn_k_1 = itm_cn_k_1;
	}

	public String getItm_cn_l_1() {
		return itm_cn_l_1;
	}

	public void setItm_cn_l_1(String itm_cn_l_1) {
		this.itm_cn_l_1 = itm_cn_l_1;
	}

	public String getCfr_no() {
		return cfr_no;
	}

	public void setCfr_no(String cfr_no) {
		this.cfr_no = cfr_no;
	}

	public String getDtl_desc() {
		return dtl_desc;
	}

	public void setDtl_desc(String dtl_desc) {
		this.dtl_desc = dtl_desc;
	}

	public String getList_exps_yn() {
		return list_exps_yn;
	}

	public void setList_exps_yn(String list_exps_yn) {
		this.list_exps_yn = list_exps_yn;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStartidx() {
		return startidx;
	}

	public void setStartidx(int startidx) {
		this.startidx = startidx;
	}

	public int getEndidx() {
		return endidx;
	}

	public void setEndidx(int endidx) {
		this.endidx = endidx;
	}

	public String getPage_gubun() {
		return page_gubun;
	}

	public void setPage_gubun(String page_gubun) {
		this.page_gubun = page_gubun;
	}

	public String getKeyfield() {
		return keyfield;
	}

	public void setKeyfield(String keyfield) {
		this.keyfield = keyfield;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getOrdno() {
		return ordno;
	}

	public void setOrdno(int ordno) {
		this.ordno = ordno;
	}

	public String getReform_dvs() {
		return reform_dvs;
	}

	public void setReform_dvs(String reform_dvs) {
		this.reform_dvs = reform_dvs;
	}

	public String getReform_reason() {
		return reform_reason;
	}

	public void setReform_reason(String reform_reason) {
		this.reform_reason = reform_reason;
	}

	public int getReform_no() {
		return reform_no;
	}

	public void setReform_no(int reform_no) {
		this.reform_no = reform_no;
	}

	public String getNtfc_dt() {
		return ntfc_dt;
	}

	public void setNtfc_dt(String ntfc_dt) {
		this.ntfc_dt = ntfc_dt;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getAtch_file_nm() {
		return atch_file_nm;
	}

	public void setAtch_file_nm(String atch_file_nm) {
		this.atch_file_nm = atch_file_nm;
	}

	public int getIndct_ord() {
		return indct_ord;
	}

	public void setIndct_ord(int indct_ord) {
		this.indct_ord = indct_ord;
	}

	public Date getCret_dtm() {
		return cret_dtm;
	}

	public void setCret_dtm(Date cret_dtm) {
		this.cret_dtm = cret_dtm;
	}

	public String getNtfc_no() {
		return ntfc_no;
	}

	public void setNtfc_no(String ntfc_no) {
		this.ntfc_no = ntfc_no;
	}

	public int getCom_serial() {
		return com_serial;
	}

	public void setCom_serial(int com_serial) {
		this.com_serial = com_serial;
	}

	public int getGong_serial() {
		return gong_serial;
	}

	public void setGong_serial(int gong_serial) {
		this.gong_serial = gong_serial;
	}

	public int getFcc_serial() {
		return fcc_serial;
	}

	public void setFcc_serial(int fcc_serial) {
		this.fcc_serial = fcc_serial;
	}

	public int getEu_serial() {
		return eu_serial;
	}

	public void setEu_serial(int eu_serial) {
		this.eu_serial = eu_serial;
	}

	public int getCfr_serial() {
		return cfr_serial;
	}

	public void setCfr_serial(int cfr_serial) {
		this.cfr_serial = cfr_serial;
	}

	public int getJa_serial() {
		return ja_serial;
	}

	public void setJa_serial(int ja_serial) {
		this.ja_serial = ja_serial;
	}

	public int getSafety_serial() {
		return safety_serial;
	}

	public void setSafety_serial(int safety_serial) {
		this.safety_serial = safety_serial;
	}

	public int getJecfa_serial() {
		return jecfa_serial;
	}

	public void setJecfa_serial(int jecfa_serial) {
		this.jecfa_serial = jecfa_serial;
	}

	public int getCodex_serial() {
		return codex_serial;
	}

	public void setCodex_serial(int codex_serial) {
		this.codex_serial = codex_serial;
	}

	public String getChmsnm() {
		return chmsnm;
	}

	public void setChmsnm(String chmsnm) {
		this.chmsnm = chmsnm;
	}

	public String getPrpos() {
		return prpos;
	}

	public void setPrpos(String prpos) {
		this.prpos = prpos;
	}

	public String getList_indct_yn() {
		return list_indct_yn;
	}

	public void setList_indct_yn(String list_indct_yn) {
		this.list_indct_yn = list_indct_yn;
	}

	public String getDfn_1() {
		return dfn_1;
	}

	public void setDfn_1(String dfn_1) {
		this.dfn_1 = dfn_1;
	}

	public String getFdqntlaw_1() {
		return fdqntlaw_1;
	}

	public void setFdqntlaw_1(String fdqntlaw_1) {
		this.fdqntlaw_1 = fdqntlaw_1;
	}

	public String getPuredo_test2() {
		return puredo_test2;
	}

	public void setPuredo_test2(String puredo_test2) {
		this.puredo_test2 = puredo_test2;
	}

	public String getFrmlc_and_save_1() {
		return frmlc_and_save_1;
	}

	public void setFrmlc_and_save_1(String frmlc_and_save_1) {
		this.frmlc_and_save_1 = frmlc_and_save_1;
	}

	public String getEu_legacy_list() {
		return eu_legacy_list;
	}

	public void setEu_legacy_list(String eu_legacy_list) {
		this.eu_legacy_list = eu_legacy_list;
	}

	public String getIgnit_remn_rate() {
		return ignit_remn_rate;
	}

	public void setIgnit_remn_rate(String ignit_remn_rate) {
		this.ignit_remn_rate = ignit_remn_rate;
	}

	public String getItm_nm_e() {
		return itm_nm_e;
	}

	public void setItm_nm_e(String itm_nm_e) {
		this.itm_nm_e = itm_nm_e;
	}

	public String getItm_cn_e() {
		return itm_cn_e;
	}

	public void setItm_cn_e(String itm_cn_e) {
		this.itm_cn_e = itm_cn_e;
	}

	public String getItm_nm_f() {
		return itm_nm_f;
	}

	public void setItm_nm_f(String itm_nm_f) {
		this.itm_nm_f = itm_nm_f;
	}

	public String getItm_cn_f() {
		return itm_cn_f;
	}

	public void setItm_cn_f(String itm_cn_f) {
		this.itm_cn_f = itm_cn_f;
	}

	public String getItm_nm_g() {
		return itm_nm_g;
	}

	public void setItm_nm_g(String itm_nm_g) {
		this.itm_nm_g = itm_nm_g;
	}

	public String getItm_cn_g() {
		return itm_cn_g;
	}

	public void setItm_cn_g(String itm_cn_g) {
		this.itm_cn_g = itm_cn_g;
	}

	public String getItm_nm_h() {
		return itm_nm_h;
	}

	public void setItm_nm_h(String itm_nm_h) {
		this.itm_nm_h = itm_nm_h;
	}

	public String getItm_cn_h() {
		return itm_cn_h;
	}

	public void setItm_cn_h(String itm_cn_h) {
		this.itm_cn_h = itm_cn_h;
	}

	public String getItm_nm_i() {
		return itm_nm_i;
	}

	public void setItm_nm_i(String itm_nm_i) {
		this.itm_nm_i = itm_nm_i;
	}

	public String getItm_cn_i() {
		return itm_cn_i;
	}

	public void setItm_cn_i(String itm_cn_i) {
		this.itm_cn_i = itm_cn_i;
	}

	public String getItm_nm_j() {
		return itm_nm_j;
	}

	public void setItm_nm_j(String itm_nm_j) {
		this.itm_nm_j = itm_nm_j;
	}

	public String getItm_cn_j() {
		return itm_cn_j;
	}

	public void setItm_cn_j(String itm_cn_j) {
		this.itm_cn_j = itm_cn_j;
	}

	public String getDry_reductn() {
		return dry_reductn;
	}

	public void setDry_reductn(String dry_reductn) {
		this.dry_reductn = dry_reductn;
	}

	public int getUse_no() {
		return use_no;
	}

	public void setUse_no(int use_no) {
		this.use_no = use_no;
	}

	public String getCfr_cd() {
		return cfr_cd;
	}

	public void setCfr_cd(String cfr_cd) {
		this.cfr_cd = cfr_cd;
	}

	public String getUse_food() {
		return use_food;
	}

	public void setUse_food(String use_food) {
		this.use_food = use_food;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	public String getObj_food() {
		return obj_food;
	}

	public void setObj_food(String obj_food) {
		this.obj_food = obj_food;
	}

	public String getMxmm_perm_volum() {
		return mxmm_perm_volum;
	}

	public void setMxmm_perm_volum(String mxmm_perm_volum) {
		this.mxmm_perm_volum = mxmm_perm_volum;
	}

	public String getManage_no() {
		return manage_no;
	}

	public void setManage_no(String manage_no) {
		this.manage_no = manage_no;
	}

	public String getMttr_nm() {
		return mttr_nm;
	}

	public void setMttr_nm(String mttr_nm) {
		this.mttr_nm = mttr_nm;
	}

	public String getJecfa_no() {
		return jecfa_no;
	}

	public void setJecfa_no(String jecfa_no) {
		this.jecfa_no = jecfa_no;
	}

	public String getEu_fl_no() {
		return eu_fl_no;
	}

	public void setEu_fl_no(String eu_fl_no) {
		this.eu_fl_no = eu_fl_no;
	}

	public String getEu_chms_grp() {
		return eu_chms_grp;
	}

	public void setEu_chms_grp(String eu_chms_grp) {
		this.eu_chms_grp = eu_chms_grp;
	}

	public String getStartword() {
		return startword;
	}

	public void setStartword(String startword) {
		this.startword = startword;
	}

}