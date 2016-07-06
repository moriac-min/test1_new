package foodportal.admin.systemmngt.vo;

import org.apache.commons.lang.builder.ToStringBuilder;

import common.commonfacillity.uia.WqBaseBean;

public class FoodLifeVO extends WqBaseBean {

	private String food_life_cd;		//식생활 게시글 연결 관리 코드
	private String menu_no;			//메뉴_번호 
	private String lv;						//뎁스
	private String hrnk_menu_no;	//상위_메뉴_번호 
	private String menu_nm;			//메뉴_명 
	private String sys_dvs_cd;		//시스템_구분_코드 
	private String menu_type_cd;	//메뉴_유형_코드
	private String bbs_no;				//게시판_번호
	private String mngt_bbs_no;		//관리_게시판_번호
	private String bbs_type_cd;		//게시판_코드
	private String rm;					//메뉴그룹코드
	private String url;					//URL
	
	private String ntctxt_no;			//게시글_번호 
	private String titl;					//연결된_게시글_제목
	private String bdt;					//요약문
	private String clmn01;				//메뉴_번호 
	private String clmn02;				//연결된_게시판_번호 
	private String clmn03;				//연결된_게시글_번호
	private String clmn04;				//메뉴명
	private String clmn05;				//이미지 요약문
	private String cret_dtm;			//연결된_게시글_작성일
	
	private String atch_file_no;		//첨부_파일_번호
	private String file_type_cd;		//파일_유형_코드
	private String file_path;			//파일_경로
	private String logic_file_nm;		//논리_파일_명
	private String physic_file_nm;	//물리_파일_명
	private String file_mg;				//파일_크기
	private String file_yn;				//파일첨부 여부
	
	private String cretr_id;				//작성자
	private String last_updtr_id;		//수정자
	
	private String param_status;		//파라미터 상태
	
	public String getMenu_no() {
		return menu_no;
	}
	public void setMenu_no(String menu_no) {
		this.menu_no = menu_no;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}
	public String getHrnk_menu_no() {
		return hrnk_menu_no;
	}
	public void setHrnk_menu_no(String hrnk_menu_no) {
		this.hrnk_menu_no = hrnk_menu_no;
	}
	public String getMenu_nm() {
		return menu_nm;
	}
	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}
	public String getSys_dvs_cd() {
		return sys_dvs_cd;
	}
	public void setSys_dvs_cd(String sys_dvs_cd) {
		this.sys_dvs_cd = sys_dvs_cd;
	}
	public String getMenu_type_cd() {
		return menu_type_cd;
	}
	public void setMenu_type_cd(String menu_type_cd) {
		this.menu_type_cd = menu_type_cd;
	}
	public String getBbs_no() {
		return bbs_no;
	}
	public void setBbs_no(String bbs_no) {
		this.bbs_no = bbs_no;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	public String getBbs_type_cd() {
		return bbs_type_cd;
	}
	public void setBbs_type_cd(String bbs_type_cd) {
		this.bbs_type_cd = bbs_type_cd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	public String getNtctxt_no() {
		return ntctxt_no;
	}
	public void setNtctxt_no(String ntctxt_no) {
		this.ntctxt_no = ntctxt_no;
	}
	public String getTitl() {
		return titl;
	}
	public void setTitl(String titl) {
		this.titl = titl;
	}
	public String getClmn01() {
		return clmn01;
	}
	public void setClmn01(String clmn01) {
		this.clmn01 = clmn01;
	}
	public String getClmn02() {
		return clmn02;
	}
	public void setClmn02(String clmn02) {
		this.clmn02 = clmn02;
	}
	public String getClmn03() {
		return clmn03;
	}
	public void setClmn03(String clmn03) {
		this.clmn03 = clmn03;
	}
	public String getClmn04() {
		return clmn04;
	}
	public void setClmn04(String clmn04) {
		this.clmn04 = clmn04;
	}
	public String getCret_dtm() {
		return cret_dtm;
	}
	public void setCret_dtm(String cret_dtm) {
		this.cret_dtm = cret_dtm;
	}
	public String getCretr_id() {
		return cretr_id;
	}
	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}
	public String getLast_updtr_id() {
		return last_updtr_id;
	}
	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}
	public String getParam_status() {
		return param_status;
	}
	public void setParam_status(String param_status) {
		this.param_status = param_status;
	}
	public String getMngt_bbs_no() {
		return mngt_bbs_no;
	}
	public void setMngt_bbs_no(String mngt_bbs_no) {
		this.mngt_bbs_no = mngt_bbs_no;
	}
	public String getBdt() {
		return bdt;
	}
	public void setBdt(String bdt) {
		this.bdt = bdt;
	}
	public String getAtch_file_no() {
		return atch_file_no;
	}
	public void setAtch_file_no(String atch_file_no) {
		this.atch_file_no = atch_file_no;
	}
	public String getFile_type_cd() {
		return file_type_cd;
	}
	public void setFile_type_cd(String file_type_cd) {
		this.file_type_cd = file_type_cd;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getLogic_file_nm() {
		return logic_file_nm;
	}
	public void setLogic_file_nm(String logic_file_nm) {
		this.logic_file_nm = logic_file_nm;
	}
	public String getPhysic_file_nm() {
		return physic_file_nm;
	}
	public void setPhysic_file_nm(String physic_file_nm) {
		this.physic_file_nm = physic_file_nm;
	}
	public String getFile_mg() {
		return file_mg;
	}
	public void setFile_mg(String file_mg) {
		this.file_mg = file_mg;
	}
	public String getFile_yn() {
		return file_yn;
	}
	public void setFile_yn(String file_yn) {
		this.file_yn = file_yn;
	}
	public String getClmn05() {
		return clmn05;
	}
	public void setClmn05(String clmn05) {
		this.clmn05 = clmn05;
	}
	public String getFood_life_cd() {
		return food_life_cd;
	}
	public void setFood_life_cd(String food_life_cd) {
		this.food_life_cd = food_life_cd;
	}
}