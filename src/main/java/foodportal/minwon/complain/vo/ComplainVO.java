package foodportal.minwon.complain.vo;

import org.apache.commons.lang.builder.ToStringBuilder;


public class ComplainVO {
	
	//문서코드
	 public static final String CUSTOMER_DOC_NO_PREFIX = "A1";
	 public static final String BUSINESS_DOC_NO_PREFIX = "B1";
	
	//공통 부분
	public String doc_no; // 문서_번호 varchar(32)
	private String aplcnt_seq; // 신고자_일련번호 numeric(10)
	private String cretr_id; // 생성자_아이디 varchar(32)
	private String cret_dtm; // 생성_일시 date
	private String last_updtr_id; // 최종_수정자_아이디 varchar(32)
	private String last_updt_dtm; // 최종_수정_일시 date
	
	//aplcnt
	private String aplcnt_bnk_cd; // 신고자_은행_코드 varchar(10)
	private String aplcnt_name; // 신고자_성명 varchar(40)
	private String aplcnt_zipno; // 신고자_우편번호 varchar(6)
	private String aplcnt_postaddr; // 신고자_우편주소 varchar(256)
	private String aplcnt_dtl_addr; // 신고자_상세_주소 varchar(256)
	private String aplcnt_telno; // 신고자_전화번호 varchar(20)
	private String aplcnt_mbtpno; //핸드폰
	private String aplcnt_rsrno; // 신고자_주민등록번호 varchar(13)
	private String aplcnt_pay_acnut_no; // 신고자_지급_계좌_번호 varchar(20)
	private String aplcnt_email_addr; // 신고자_이메일_주소 varchar(128)
	
	//sttemnt_entrps
	private String sttemnt_entrps_seq;//신고_업체_일련번호 numeric(10)
	private String chrg_instt_cd;//담당_기관_코드 varchar(10)
	private String entrps_nm;//업체_명 varchar(500)
	private String induty_dvs_cd;//업종_구분_코드 varchar(1)
	private String induty_dvs_cd_nm;//업종_구분_코드명
	private String charger_name;//담당자_성명 varchar(100)
	private String charger_telno;//담당자_전화번호 varchar(256)
	
	//exam
	public String exam_dvs_cd; // 조사_구분_코드 varchar(1)
	public String prdt_mnf_dt; // 제품_제조_일자 varchar(8)
	public String prdt_purch_plc; // 제품_구매_장소 varchar(100)
	public String alnst_dispos; // 이물_성상 varchar(2048)
	public String report_wrter_id; // 보고_작성자_아이디 varchar(32)
	public String report_cn; // 보고_내용 clob
	public String exam_prgrs_yn; // 조사_진행_여부 varchar(1)
	public String reprt_reg_dtm; // 보고서_등록_일시 date

	//reportReception
	private String makr_cd; // 제조사_코드 varchar(11)
	private String makr_reg_unreg_bssh_dvs_cd; // 제조사_코드 등록 미등록 업소 구분
	private String salpr_cd; // 판매원_코드 varchar(11)
	private String salpr_reg_unreg_dvs_cd; //  판매원_코드 등록 미등록 업소 구분
	private String aplcnt_seq_nm; // 신고자_명
	private String alnst_cd; // 이물_코드 varchar(9)
	private String alnst_cd_nm; // 이물_코드_명
	private String charger_id; // 담당자_아이디 varchar(32)
	private String entrps_sttemnt_seq; // 업체_신고_일련번호 varchar(10)
	private String rcpt_dvs_cd; // 접수_구분_코드 varchar(2)
	private String rcpt_instt_dvs_cd; // 접수_기관_구분_코드 char(1)
	private String dept_cd; // 부서_코드 varchar(10)
	private String pswd; // 비밀번호 varchar(32)
	private String prsnt_stats_cd; // 현재_상태_코드 varchar(1)
	private String prdt_nm; // 제품_명 varchar(500)
	private String food_type_cd; // 식품_유형_코드 varchar(14)
	private String food_type_cd_nm; // 식품_유형_코드명
	private String prdt_frmlc_unit; // 제품_포장_단위 varchar(60)
	private String orgnp_dvs_cd; // 원산지_구분_코드 varchar(10)
	private String cnsmr_prdt_buy_plc; // 소비자_제품_구입_장소 varchar(2)
	private String cnsmr_prdt_buy_plc_nm;// 소비자_제품_구입_장소명
	private String prdt_distb_tmlmt; // 제품_유통_기한 varchar(100)
	private String prdt_buy_dt; // 제품_구입_일시 date
	private String prdt_opn_dt; // 제품_개봉_일시 date
	private String alnst_discov_dt; // 이물_발견_일시 date
	private String vilt_cl_cd; // 위반_분류_코드 varchar(1)
	private String vilt_cn_cd; // 위반_내용_코드 varchar(10)
	private String vilt_cn_cd_nm; // 위반_내용_코드명
	private String vilt_cn_prvns; // 위반_내용_사유 varchar(2048)
	private String alnst_dett_etc; // 이물_검출_기타 varchar(300)
	private String sttemnt_cn; // 신고_내용 clob
	private String reg_dtm; // 등록_일시 date
	private String cstdy_stdr; // 보관_기준 varchar(200)
	private String alnst_discov_promn; // 이물_발견_경위 clob
	private String alnst_prdt_cstdy_envrn; // 이물_제품_보관_환경 clob
	private String examr_opnn; // 조사자_의견 clob
	private String sttemnt_dt; // 신고_일시 date
	private String start_sttemnt_dt; // 시작_신고_일시 date
	private String end_sttemnt_dt; // 종료_신고_일시 date
	private String befr_sttemnt_dvs_yn; // 이전_신고_구분_여부 varchar(1)
	private String incm_natn_cd; // 수입_국가_코드 varchar(2)
	private String incm_natn_cd_nm; // 수입_국가_코드명
	private String prdt_buy_plc; // 제품_구입_장소 clob
	private String haccp_applc_prdlst_yn; // haccp_적용_품목_여부 varchar(1)
	private String ststc_incldng_yn; // 통계_포함_여부 varchar(1)
	private String exam_instt_ntcn_cn; // 조사_기관_알림_내용 clob
	private String dspth_way_cd; // 통보_방식_코드 varchar(1)
	private String dspth_way_cd_nm; // 통보_방식_코드명
	private String buy_plc_dvs_cd; // 구입_장소_구분_코드  varchar(2)

	private String qlity_mntnc_tmlmt_dt; // 품질유지기한일자
	private String vilt_cl_dtl_cd; // 위반분류 상세 코드

	
	//신고_처리_이력_일련번호
	private String sttemnt_prcs_hist_seq;

	private String now_stats_cd;
	private String now_stats_cd_nm;
	private String makr_nm;
	private String makr_zipno;
	private String makr_postaddr;
	private String makr_dtladdr;
	private String makr_telno;
	private String salpr_zipno;
	private String salpr_postaddr;
	private String salpr_dtladdr;
	private String salpr_telno;
	private String salpr_nm;

	private String search_condition;
	private String search_keyword;

	private String keep_flag_list;
	private String evdc_prdt_cstdy_dvs_cd;
	private String evdc_prdt_cstdy_dvs_cd_nm;
	
	//기관
	private String instt_telno;
	
	//파일업로드
	private String atchfl_seq;
	private String atch_file_seq;
	private String file_yn;
	private String file_save_path;
	private String file_extns;
	private String file_mg_lengt;
	private String orgnt_file_nm;
	private String physic_file_nm;
	private String file_knd_dvs_cd;

	public String getDoc_no() {
		return doc_no;
	}

	public void setDoc_no(String doc_no) {
		this.doc_no = doc_no;
	}

	public String getAplcnt_seq() {
		return aplcnt_seq;
	}

	public void setAplcnt_seq(String aplcnt_seq) {
		this.aplcnt_seq = aplcnt_seq;
	}

	public String getCretr_id() {
		return cretr_id;
	}

	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}

	public String getCret_dtm() {
		return cret_dtm;
	}

	public void setCret_dtm(String cret_dtm) {
		this.cret_dtm = cret_dtm;
	}

	public String getLast_updtr_id() {
		return last_updtr_id;
	}

	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}

	public String getLast_updt_dtm() {
		return last_updt_dtm;
	}

	public void setLast_updt_dtm(String last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}

	public String getAplcnt_bnk_cd() {
		return aplcnt_bnk_cd;
	}

	public void setAplcnt_bnk_cd(String aplcnt_bnk_cd) {
		this.aplcnt_bnk_cd = aplcnt_bnk_cd;
	}

	public String getAplcnt_name() {
		return aplcnt_name;
	}

	public void setAplcnt_name(String aplcnt_name) {
		this.aplcnt_name = aplcnt_name;
	}

	public String getAplcnt_zipno() {
		return aplcnt_zipno;
	}

	public void setAplcnt_zipno(String aplcnt_zipno) {
		this.aplcnt_zipno = aplcnt_zipno;
	}

	public String getAplcnt_postaddr() {
		return aplcnt_postaddr;
	}

	public void setAplcnt_postaddr(String aplcnt_postaddr) {
		this.aplcnt_postaddr = aplcnt_postaddr;
	}

	public String getAplcnt_dtl_addr() {
		return aplcnt_dtl_addr;
	}

	public void setAplcnt_dtl_addr(String aplcnt_dtl_addr) {
		this.aplcnt_dtl_addr = aplcnt_dtl_addr;
	}

	public String getAplcnt_telno() {
		return aplcnt_telno;
	}

	public void setAplcnt_telno(String aplcnt_telno) {
		this.aplcnt_telno = aplcnt_telno;
	}

	public String getAplcnt_mbtpno() {
		return aplcnt_mbtpno;
	}

	public void setAplcnt_mbtpno(String aplcnt_mbtpno) {
		this.aplcnt_mbtpno = aplcnt_mbtpno;
	}

	public String getAplcnt_rsrno() {
		return aplcnt_rsrno;
	}

	public void setAplcnt_rsrno(String aplcnt_rsrno) {
		this.aplcnt_rsrno = aplcnt_rsrno;
	}

	public String getAplcnt_pay_acnut_no() {
		return aplcnt_pay_acnut_no;
	}

	public void setAplcnt_pay_acnut_no(String aplcnt_pay_acnut_no) {
		this.aplcnt_pay_acnut_no = aplcnt_pay_acnut_no;
	}

	public String getAplcnt_email_addr() {
		return aplcnt_email_addr;
	}

	public void setAplcnt_email_addr(String aplcnt_email_addr) {
		this.aplcnt_email_addr = aplcnt_email_addr;
	}

	public String getExam_dvs_cd() {
		return exam_dvs_cd;
	}

	public void setExam_dvs_cd(String exam_dvs_cd) {
		this.exam_dvs_cd = exam_dvs_cd;
	}

	public String getPrdt_mnf_dt() {
		return prdt_mnf_dt;
	}

	public void setPrdt_mnf_dt(String prdt_mnf_dt) {
		this.prdt_mnf_dt = prdt_mnf_dt;
	}

	public String getPrdt_purch_plc() {
		return prdt_purch_plc;
	}

	public void setPrdt_purch_plc(String prdt_purch_plc) {
		this.prdt_purch_plc = prdt_purch_plc;
	}

	public String getAlnst_dispos() {
		return alnst_dispos;
	}

	public void setAlnst_dispos(String alnst_dispos) {
		this.alnst_dispos = alnst_dispos;
	}

	public String getReport_wrter_id() {
		return report_wrter_id;
	}

	public void setReport_wrter_id(String report_wrter_id) {
		this.report_wrter_id = report_wrter_id;
	}

	public String getReport_cn() {
		return report_cn;
	}

	public void setReport_cn(String report_cn) {
		this.report_cn = report_cn;
	}

	public String getExam_prgrs_yn() {
		return exam_prgrs_yn;
	}

	public void setExam_prgrs_yn(String exam_prgrs_yn) {
		this.exam_prgrs_yn = exam_prgrs_yn;
	}

	public String getReprt_reg_dtm() {
		return reprt_reg_dtm;
	}

	public void setReprt_reg_dtm(String reprt_reg_dtm) {
		this.reprt_reg_dtm = reprt_reg_dtm;
	}

	public String getMakr_cd() {
		return makr_cd;
	}

	public void setMakr_cd(String makr_cd) {
		this.makr_cd = makr_cd;
	}

	public String getMakr_reg_unreg_bssh_dvs_cd() {
		return makr_reg_unreg_bssh_dvs_cd;
	}

	public void setMakr_reg_unreg_bssh_dvs_cd(String makr_reg_unreg_bssh_dvs_cd) {
		this.makr_reg_unreg_bssh_dvs_cd = makr_reg_unreg_bssh_dvs_cd;
	}

	public String getSalpr_cd() {
		return salpr_cd;
	}

	public void setSalpr_cd(String salpr_cd) {
		this.salpr_cd = salpr_cd;
	}

	public String getSalpr_reg_unreg_dvs_cd() {
		return salpr_reg_unreg_dvs_cd;
	}

	public void setSalpr_reg_unreg_dvs_cd(String salpr_reg_unreg_dvs_cd) {
		this.salpr_reg_unreg_dvs_cd = salpr_reg_unreg_dvs_cd;
	}

	public String getAplcnt_seq_nm() {
		return aplcnt_seq_nm;
	}

	public void setAplcnt_seq_nm(String aplcnt_seq_nm) {
		this.aplcnt_seq_nm = aplcnt_seq_nm;
	}

	public String getAlnst_cd() {
		return alnst_cd;
	}

	public void setAlnst_cd(String alnst_cd) {
		this.alnst_cd = alnst_cd;
	}

	public String getCharger_id() {
		return charger_id;
	}

	public void setCharger_id(String charger_id) {
		this.charger_id = charger_id;
	}

	public String getEntrps_sttemnt_seq() {
		return entrps_sttemnt_seq;
	}

	public void setEntrps_sttemnt_seq(String entrps_sttemnt_seq) {
		this.entrps_sttemnt_seq = entrps_sttemnt_seq;
	}

	public String getRcpt_dvs_cd() {
		return rcpt_dvs_cd;
	}

	public void setRcpt_dvs_cd(String rcpt_dvs_cd) {
		this.rcpt_dvs_cd = rcpt_dvs_cd;
	}

	public String getRcpt_instt_dvs_cd() {
		return rcpt_instt_dvs_cd;
	}

	public void setRcpt_instt_dvs_cd(String rcpt_instt_dvs_cd) {
		this.rcpt_instt_dvs_cd = rcpt_instt_dvs_cd;
	}

	public String getDept_cd() {
		return dept_cd;
	}

	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getPrsnt_stats_cd() {
		return prsnt_stats_cd;
	}

	public void setPrsnt_stats_cd(String prsnt_stats_cd) {
		this.prsnt_stats_cd = prsnt_stats_cd;
	}

	public String getPrdt_nm() {
		return prdt_nm;
	}

	public void setPrdt_nm(String prdt_nm) {
		this.prdt_nm = prdt_nm;
	}

	public String getFood_type_cd() {
		return food_type_cd;
	}

	public void setFood_type_cd(String food_type_cd) {
		this.food_type_cd = food_type_cd;
	}

	public String getPrdt_frmlc_unit() {
		return prdt_frmlc_unit;
	}

	public void setPrdt_frmlc_unit(String prdt_frmlc_unit) {
		this.prdt_frmlc_unit = prdt_frmlc_unit;
	}

	public String getOrgnp_dvs_cd() {
		return orgnp_dvs_cd;
	}

	public void setOrgnp_dvs_cd(String orgnp_dvs_cd) {
		this.orgnp_dvs_cd = orgnp_dvs_cd;
	}

	public String getCnsmr_prdt_buy_plc() {
		return cnsmr_prdt_buy_plc;
	}

	public void setCnsmr_prdt_buy_plc(String cnsmr_prdt_buy_plc) {
		this.cnsmr_prdt_buy_plc = cnsmr_prdt_buy_plc;
	}

	public String getPrdt_distb_tmlmt() {
		return prdt_distb_tmlmt;
	}

	public void setPrdt_distb_tmlmt(String prdt_distb_tmlmt) {
		this.prdt_distb_tmlmt = prdt_distb_tmlmt;
	}

	public String getPrdt_buy_dt() {
		return prdt_buy_dt;
	}

	public void setPrdt_buy_dt(String prdt_buy_dt) {
		this.prdt_buy_dt = prdt_buy_dt;
	}

	public String getPrdt_opn_dt() {
		return prdt_opn_dt;
	}

	public void setPrdt_opn_dt(String prdt_opn_dt) {
		this.prdt_opn_dt = prdt_opn_dt;
	}

	public String getAlnst_discov_dt() {
		return alnst_discov_dt;
	}

	public void setAlnst_discov_dt(String alnst_discov_dt) {
		this.alnst_discov_dt = alnst_discov_dt;
	}

	public String getVilt_cl_cd() {
		return vilt_cl_cd;
	}

	public void setVilt_cl_cd(String vilt_cl_cd) {
		this.vilt_cl_cd = vilt_cl_cd;
	}

	public String getVilt_cn_cd() {
		return vilt_cn_cd;
	}

	public void setVilt_cn_cd(String vilt_cn_cd) {
		this.vilt_cn_cd = vilt_cn_cd;
	}

	public String getVilt_cn_prvns() {
		return vilt_cn_prvns;
	}

	public void setVilt_cn_prvns(String vilt_cn_prvns) {
		this.vilt_cn_prvns = vilt_cn_prvns;
	}

	public String getAlnst_dett_etc() {
		return alnst_dett_etc;
	}

	public void setAlnst_dett_etc(String alnst_dett_etc) {
		this.alnst_dett_etc = alnst_dett_etc;
	}

	public String getSttemnt_cn() {
		return sttemnt_cn;
	}

	public void setSttemnt_cn(String sttemnt_cn) {
		this.sttemnt_cn = sttemnt_cn;
	}

	public String getReg_dtm() {
		return reg_dtm;
	}

	public void setReg_dtm(String reg_dtm) {
		this.reg_dtm = reg_dtm;
	}

	public String getCstdy_stdr() {
		return cstdy_stdr;
	}

	public void setCstdy_stdr(String cstdy_stdr) {
		this.cstdy_stdr = cstdy_stdr;
	}

	public String getAlnst_discov_promn() {
		return alnst_discov_promn;
	}

	public void setAlnst_discov_promn(String alnst_discov_promn) {
		this.alnst_discov_promn = alnst_discov_promn;
	}

	public String getAlnst_prdt_cstdy_envrn() {
		return alnst_prdt_cstdy_envrn;
	}

	public void setAlnst_prdt_cstdy_envrn(String alnst_prdt_cstdy_envrn) {
		this.alnst_prdt_cstdy_envrn = alnst_prdt_cstdy_envrn;
	}

	public String getExamr_opnn() {
		return examr_opnn;
	}

	public void setExamr_opnn(String examr_opnn) {
		this.examr_opnn = examr_opnn;
	}

	public String getSttemnt_dt() {
		return sttemnt_dt;
	}

	public void setSttemnt_dt(String sttemnt_dt) {
		this.sttemnt_dt = sttemnt_dt;
	}

	public String getStart_sttemnt_dt() {
		return start_sttemnt_dt;
	}

	public void setStart_sttemnt_dt(String start_sttemnt_dt) {
		this.start_sttemnt_dt = start_sttemnt_dt;
	}

	public String getEnd_sttemnt_dt() {
		return end_sttemnt_dt;
	}

	public void setEnd_sttemnt_dt(String end_sttemnt_dt) {
		this.end_sttemnt_dt = end_sttemnt_dt;
	}

	public String getBefr_sttemnt_dvs_yn() {
		return befr_sttemnt_dvs_yn;
	}

	public void setBefr_sttemnt_dvs_yn(String befr_sttemnt_dvs_yn) {
		this.befr_sttemnt_dvs_yn = befr_sttemnt_dvs_yn;
	}

	public String getIncm_natn_cd() {
		return incm_natn_cd;
	}

	public void setIncm_natn_cd(String incm_natn_cd) {
		this.incm_natn_cd = incm_natn_cd;
	}

	public String getPrdt_buy_plc() {
		return prdt_buy_plc;
	}

	public void setPrdt_buy_plc(String prdt_buy_plc) {
		this.prdt_buy_plc = prdt_buy_plc;
	}

	public String getHaccp_applc_prdlst_yn() {
		return haccp_applc_prdlst_yn;
	}

	public void setHaccp_applc_prdlst_yn(String haccp_applc_prdlst_yn) {
		this.haccp_applc_prdlst_yn = haccp_applc_prdlst_yn;
	}

	public String getStstc_incldng_yn() {
		return ststc_incldng_yn;
	}

	public void setStstc_incldng_yn(String ststc_incldng_yn) {
		this.ststc_incldng_yn = ststc_incldng_yn;
	}

	public String getExam_instt_ntcn_cn() {
		return exam_instt_ntcn_cn;
	}

	public void setExam_instt_ntcn_cn(String exam_instt_ntcn_cn) {
		this.exam_instt_ntcn_cn = exam_instt_ntcn_cn;
	}

	public String getDspth_way_cd() {
		return dspth_way_cd;
	}

	public void setDspth_way_cd(String dspth_way_cd) {
		this.dspth_way_cd = dspth_way_cd;
	}

	public String getBuy_plc_dvs_cd() {
		return buy_plc_dvs_cd;
	}

	public void setBuy_plc_dvs_cd(String buy_plc_dvs_cd) {
		this.buy_plc_dvs_cd = buy_plc_dvs_cd;
	}

	public String getQlity_mntnc_tmlmt_dt() {
		return qlity_mntnc_tmlmt_dt;
	}

	public void setQlity_mntnc_tmlmt_dt(String qlity_mntnc_tmlmt_dt) {
		this.qlity_mntnc_tmlmt_dt = qlity_mntnc_tmlmt_dt;
	}

	public String getVilt_cl_dtl_cd() {
		return vilt_cl_dtl_cd;
	}

	public void setVilt_cl_dtl_cd(String vilt_cl_dtl_cd) {
		this.vilt_cl_dtl_cd = vilt_cl_dtl_cd;
	}

	public String getSttemnt_prcs_hist_seq() {
		return sttemnt_prcs_hist_seq;
	}

	public void setSttemnt_prcs_hist_seq(String sttemnt_prcs_hist_seq) {
		this.sttemnt_prcs_hist_seq = sttemnt_prcs_hist_seq;
	}

	public String getMakr_nm() {
		return makr_nm;
	}

	public void setMakr_nm(String makr_nm) {
		this.makr_nm = makr_nm;
	}

	public String getMakr_zipno() {
		return makr_zipno;
	}

	public void setMakr_zipno(String makr_zipno) {
		this.makr_zipno = makr_zipno;
	}

	public String getMakr_postaddr() {
		return makr_postaddr;
	}

	public void setMakr_postaddr(String makr_postaddr) {
		this.makr_postaddr = makr_postaddr;
	}

	public String getMakr_dtladdr() {
		return makr_dtladdr;
	}

	public void setMakr_dtladdr(String makr_dtladdr) {
		this.makr_dtladdr = makr_dtladdr;
	}

	public String getMakr_telno() {
		return makr_telno;
	}

	public void setMakr_telno(String makr_telno) {
		this.makr_telno = makr_telno;
	}

	public String getSalpr_zipno() {
		return salpr_zipno;
	}

	public void setSalpr_zipno(String salpr_zipno) {
		this.salpr_zipno = salpr_zipno;
	}

	public String getSalpr_postaddr() {
		return salpr_postaddr;
	}

	public void setSalpr_postaddr(String salpr_postaddr) {
		this.salpr_postaddr = salpr_postaddr;
	}

	public String getSalpr_dtladdr() {
		return salpr_dtladdr;
	}

	public void setSalpr_dtladdr(String salpr_dtladdr) {
		this.salpr_dtladdr = salpr_dtladdr;
	}

	public String getSalpr_telno() {
		return salpr_telno;
	}

	public void setSalpr_telno(String salpr_telno) {
		this.salpr_telno = salpr_telno;
	}

	public String getSalpr_nm() {
		return salpr_nm;
	}

	public void setSalpr_nm(String salpr_nm) {
		this.salpr_nm = salpr_nm;
	}

	public String getSearch_condition() {
		return search_condition;
	}

	public void setSearch_condition(String search_condition) {
		this.search_condition = search_condition;
	}

	public String getSearch_keyword() {
		return search_keyword;
	}

	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}

	public String getKeep_flag_list() {
		return keep_flag_list;
	}

	public void setKeep_flag_list(String keep_flag_list) {
		this.keep_flag_list = keep_flag_list;
	}
	
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public String getInstt_telno() {
		return instt_telno;
	}

	public void setInstt_telno(String instt_telno) {
		this.instt_telno = instt_telno;
	}

	public String getNow_stats_cd() {
		return now_stats_cd;
	}

	public void setNow_stats_cd(String now_stats_cd) {
		this.now_stats_cd = now_stats_cd;
	}

	public String getEvdc_prdt_cstdy_dvs_cd() {
		return evdc_prdt_cstdy_dvs_cd;
	}

	public void setEvdc_prdt_cstdy_dvs_cd(String evdc_prdt_cstdy_dvs_cd) {
		this.evdc_prdt_cstdy_dvs_cd = evdc_prdt_cstdy_dvs_cd;
	}

	public String getEvdc_prdt_cstdy_dvs_cd_nm() {
		return evdc_prdt_cstdy_dvs_cd_nm;
	}

	public void setEvdc_prdt_cstdy_dvs_cd_nm(String evdc_prdt_cstdy_dvs_cd_nm) {
		this.evdc_prdt_cstdy_dvs_cd_nm = evdc_prdt_cstdy_dvs_cd_nm;
	}

	public String getNow_stats_cd_nm() {
		return now_stats_cd_nm;
	}

	public void setNow_stats_cd_nm(String now_stats_cd_nm) {
		this.now_stats_cd_nm = now_stats_cd_nm;
	}

	public String getVilt_cn_cd_nm() {
		return vilt_cn_cd_nm;
	}

	public void setVilt_cn_cd_nm(String vilt_cn_cd_nm) {
		this.vilt_cn_cd_nm = vilt_cn_cd_nm;
	}

	public String getAlnst_cd_nm() {
		return alnst_cd_nm;
	}

	public void setAlnst_cd_nm(String alnst_cd_nm) {
		this.alnst_cd_nm = alnst_cd_nm;
	}

	public String getIncm_natn_cd_nm() {
		return incm_natn_cd_nm;
	}

	public void setIncm_natn_cd_nm(String incm_natn_cd_nm) {
		this.incm_natn_cd_nm = incm_natn_cd_nm;
	}

	public String getFood_type_cd_nm() {
		return food_type_cd_nm;
	}

	public void setFood_type_cd_nm(String food_type_cd_nm) {
		this.food_type_cd_nm = food_type_cd_nm;
	}

	public String getFile_yn() {
		return file_yn;
	}

	public void setFile_yn(String file_yn) {
		this.file_yn = file_yn;
	}

	public String getAtchfl_seq() {
		return atchfl_seq;
	}

	public void setAtchfl_seq(String atchfl_seq) {
		this.atchfl_seq = atchfl_seq;
	}

	public String getAtch_file_seq() {
		return atch_file_seq;
	}

	public void setAtch_file_seq(String atch_file_seq) {
		this.atch_file_seq = atch_file_seq;
	}

	public String getFile_save_path() {
		return file_save_path;
	}

	public void setFile_save_path(String file_save_path) {
		this.file_save_path = file_save_path;
	}

	public String getFile_extns() {
		return file_extns;
	}

	public void setFile_extns(String file_extns) {
		this.file_extns = file_extns;
	}

	public String getFile_mg_lengt() {
		return file_mg_lengt;
	}

	public void setFile_mg_lengt(String file_mg_lengt) {
		this.file_mg_lengt = file_mg_lengt;
	}

	public String getOrgnt_file_nm() {
		return orgnt_file_nm;
	}

	public void setOrgnt_file_nm(String orgnt_file_nm) {
		this.orgnt_file_nm = orgnt_file_nm;
	}

	public String getPhysic_file_nm() {
		return physic_file_nm;
	}

	public void setPhysic_file_nm(String physic_file_nm) {
		this.physic_file_nm = physic_file_nm;
	}

	public String getFile_knd_dvs_cd() {
		return file_knd_dvs_cd;
	}

	public void setFile_knd_dvs_cd(String file_knd_dvs_cd) {
		this.file_knd_dvs_cd = file_knd_dvs_cd;
	}

	public String getSttemnt_entrps_seq() {
		return sttemnt_entrps_seq;
	}

	public void setSttemnt_entrps_seq(String sttemnt_entrps_seq) {
		this.sttemnt_entrps_seq = sttemnt_entrps_seq;
	}

	public String getChrg_instt_cd() {
		return chrg_instt_cd;
	}

	public void setChrg_instt_cd(String chrg_instt_cd) {
		this.chrg_instt_cd = chrg_instt_cd;
	}

	public String getEntrps_nm() {
		return entrps_nm;
	}

	public void setEntrps_nm(String entrps_nm) {
		this.entrps_nm = entrps_nm;
	}

	public String getInduty_dvs_cd() {
		return induty_dvs_cd;
	}

	public void setInduty_dvs_cd(String induty_dvs_cd) {
		this.induty_dvs_cd = induty_dvs_cd;
	}

	public String getCharger_name() {
		return charger_name;
	}

	public void setCharger_name(String charger_name) {
		this.charger_name = charger_name;
	}

	public String getCharger_telno() {
		return charger_telno;
	}

	public void setCharger_telno(String charger_telno) {
		this.charger_telno = charger_telno;
	}

	public String getInduty_dvs_cd_nm() {
		return induty_dvs_cd_nm;
	}

	public void setInduty_dvs_cd_nm(String induty_dvs_cd_nm) {
		this.induty_dvs_cd_nm = induty_dvs_cd_nm;
	}

	public String getDspth_way_cd_nm() {
		return dspth_way_cd_nm;
	}

	public void setDspth_way_cd_nm(String dspth_way_cd_nm) {
		this.dspth_way_cd_nm = dspth_way_cd_nm;
	}

	public static String getCustomerDocNoPrefix() {
		return CUSTOMER_DOC_NO_PREFIX;
	}

	public static String getBusinessDocNoPrefix() {
		return BUSINESS_DOC_NO_PREFIX;
	}

}

