package foodportal.api.vo;

public class DatasetVO{
	
	private String svc_no;				//서비스번호
	private String svc_nm;				//서비스명
	private String provd_instt;			//제공기관코드
	private String provd_instt_nm;		//제공기관명
	private String cl_cd;				//분류타입코드
	private String cl_cd_nm;			//분류타입명
	private String path;				//경로
	private String use_stats_cd;		//서비스상태
	private String use_stats_cd_nm;		//서비스상태명
	private String sheet_yn;			//sheet 여부
	private String chart_yn;			//chart 여부
	private String map_yn;				//map 여부
	private String file_yn;				//file 여부
	private String link_yn;				//link 여부
	private String openapi_yn;			//api 여부
	
	private String no;					//순번
	
	private String rm;					//비고
	private String cretr_id;			//생성자 아이디
	private String cret_dtm;			//생성일시
	private String last_updtr_id;		//수정자 아이디
	private String last_updt_dtm;		//수정일시
	
	private String svc_type_cd;			//서비스유형
	private String link_url;			//링크경로
	private String sample_url;			//샘플경로
	
	private String itm_cd;				//항목코드
	private String ordno;				//순번
	private String itm_nm;				//항목명
	private String itm_desc;			//항목설명
	
	private String del_yn;				//삭제여부
	
	//첨부파일
	private String atch_file_no;	//첨부파일번호
	private String rprsnt_img_yn;	//대표이미지여부
	private String img_link_url;	//이미지링크URL
	private String file_type_cd;	//파일유형코드
	private String file_path;		//파일경로
	private String logic_file_nm;	//논리파일명
	private String physic_file_nm;	//물리파일명
	private String file_mg;			//파일크기
	public String getSvc_no() {
		return svc_no;
	}
	public void setSvc_no(String svc_no) {
		this.svc_no = svc_no;
	}
	public String getSvc_nm() {
		return svc_nm;
	}
	public void setSvc_nm(String svc_nm) {
		this.svc_nm = svc_nm;
	}
	public String getProvd_instt() {
		return provd_instt;
	}
	public void setProvd_instt(String provd_instt) {
		this.provd_instt = provd_instt;
	}
	public String getProvd_instt_nm() {
		return provd_instt_nm;
	}
	public void setProvd_instt_nm(String provd_instt_nm) {
		this.provd_instt_nm = provd_instt_nm;
	}
	public String getCl_cd() {
		return cl_cd;
	}
	public void setCl_cd(String cl_cd) {
		this.cl_cd = cl_cd;
	}
	public String getCl_cd_nm() {
		return cl_cd_nm;
	}
	public void setCl_cd_nm(String cl_cd_nm) {
		this.cl_cd_nm = cl_cd_nm;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUse_stats_cd() {
		return use_stats_cd;
	}
	public void setUse_stats_cd(String use_stats_cd) {
		this.use_stats_cd = use_stats_cd;
	}
	public String getUse_stats_cd_nm() {
		return use_stats_cd_nm;
	}
	public void setUse_stats_cd_nm(String use_stats_cd_nm) {
		this.use_stats_cd_nm = use_stats_cd_nm;
	}
	public String getSheet_yn() {
		return sheet_yn;
	}
	public void setSheet_yn(String sheet_yn) {
		this.sheet_yn = sheet_yn;
	}
	public String getChart_yn() {
		return chart_yn;
	}
	public void setChart_yn(String chart_yn) {
		this.chart_yn = chart_yn;
	}
	public String getMap_yn() {
		return map_yn;
	}
	public void setMap_yn(String map_yn) {
		this.map_yn = map_yn;
	}
	public String getFile_yn() {
		return file_yn;
	}
	public void setFile_yn(String file_yn) {
		this.file_yn = file_yn;
	}
	public String getLink_yn() {
		return link_yn;
	}
	public void setLink_yn(String link_yn) {
		this.link_yn = link_yn;
	}
	public String getOpenapi_yn() {
		return openapi_yn;
	}
	public void setOpenapi_yn(String openapi_yn) {
		this.openapi_yn = openapi_yn;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
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
	public String getSvc_type_cd() {
		return svc_type_cd;
	}
	public void setSvc_type_cd(String svc_type_cd) {
		this.svc_type_cd = svc_type_cd;
	}
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	public String getSample_url() {
		return sample_url;
	}
	public void setSample_url(String sample_url) {
		this.sample_url = sample_url;
	}
	public String getItm_cd() {
		return itm_cd;
	}
	public void setItm_cd(String itm_cd) {
		this.itm_cd = itm_cd;
	}
	public String getOrdno() {
		return ordno;
	}
	public void setOrdno(String ordno) {
		this.ordno = ordno;
	}
	public String getItm_nm() {
		return itm_nm;
	}
	public void setItm_nm(String itm_nm) {
		this.itm_nm = itm_nm;
	}
	public String getItm_desc() {
		return itm_desc;
	}
	public void setItm_desc(String itm_desc) {
		this.itm_desc = itm_desc;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getAtch_file_no() {
		return atch_file_no;
	}
	public void setAtch_file_no(String atch_file_no) {
		this.atch_file_no = atch_file_no;
	}
	public String getRprsnt_img_yn() {
		return rprsnt_img_yn;
	}
	public void setRprsnt_img_yn(String rprsnt_img_yn) {
		this.rprsnt_img_yn = rprsnt_img_yn;
	}
	public String getImg_link_url() {
		return img_link_url;
	}
	public void setImg_link_url(String img_link_url) {
		this.img_link_url = img_link_url;
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
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	
}