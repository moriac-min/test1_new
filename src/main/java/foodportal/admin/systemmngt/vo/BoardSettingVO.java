package foodportal.admin.systemmngt.vo;

import common.commonfacillity.uia.WqBaseBean;

public class BoardSettingVO extends WqBaseBean{

	private String				bbs_no;					//게시판번호
	private String				bbs_type_cd;			//게시판유형코드
	private String				bbs_nm;					//게시판명
	private String				menu_nm;				//메뉴명
	private String				bbs_templet_url;		//게시판템플릭URL
	private String				ctgry_type_cd;			//카테고리유형코드
	private String				list_img_use_yn;		//목록이미지사용여부
	private String				list_img_link_yn;		//목록이미지링크여부
	private String				atch_file_posbl_yn;		//첨부파일가능여부
	private String				perm_extnm;				//허용확장명
	private String				mxmm_file_size;			//최대파일사이즈
	private String				nticmatr_yn;			//공지사항여부
	private String				ans_yn;					//답글여부
	private String				cmt_yn;					//댓글여부
	private String				user_txt_write_yn;		//사용자글쓰기여부
	private String				user_txt_del_yn;		//사용자글삭제여부
	private String				user_txt_lock_yn;		//사용자글잠금여부
	private String				orgnl_view_use_yn;		//원문보기사용여부
	private String				inqry_cnd_use_yn;		//조회조건사용여부
	private String				kword_use_yn;			//키워드사용여부
	private String				natn_cd_use_yn;			//국가코드사용여부
	private String				outpt_type_cd;			//출력유형코드
	private String				tab_use_yn;				//TAB사용여부
	private String				tab_pdcnt;				//TAB갯수
	private String				del_yn;					//삭제여부
	private String				rm;						//비고
	private String				tag_use_yn;				//태그사용여부
	private String				meta_use_yn;			//메타사용여부
	private String				cnt;					//카운트
	private String				ctgry_use_yn;			//카테고리사요여부
	private String				bbs_type;				//게시판타입
	
	private String				user_id;				//사용자ID
	private String				user_nm;				//사용자명
	private String				ptcs_nm;				//직급명
	private String				pstofc_nm;				//직책명
	
	private String              cretr_id;				//생성자ID
	private java.sql.Date       cret_dtm;				//생성일시
	private String              last_updtr_id;			//최종수정자ID
	private java.sql.Date       last_updt_dtm;			//최종수정일시
	
	/*******************다른곳에서 쓰는것********************/
	private String              use_yn;
	
	public String getBbs_no() {
		return bbs_no;
	}
	public void setBbs_no(String bbs_no) {
		this.bbs_no = bbs_no;
	}
	public String getBbs_type_cd() {
		return bbs_type_cd;
	}
	public void setBbs_type_cd(String bbs_type_cd) {
		this.bbs_type_cd = bbs_type_cd;
	}
	public String getBbs_nm() {
		return bbs_nm;
	}
	public void setBbs_nm(String bbs_nm) {
		this.bbs_nm = bbs_nm;
	}
	public String getMenu_nm() {
		return menu_nm;
	}
	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
	}
	public String getBbs_templet_url() {
		return bbs_templet_url;
	}
	public void setBbs_templet_url(String bbs_templet_url) {
		this.bbs_templet_url = bbs_templet_url;
	}
	public String getCtgry_type_cd() {
		return ctgry_type_cd;
	}
	public void setCtgry_type_cd(String ctgry_type_cd) {
		this.ctgry_type_cd = ctgry_type_cd;
	}
	public String getList_img_use_yn() {
		return list_img_use_yn;
	}
	public void setList_img_use_yn(String list_img_use_yn) {
		this.list_img_use_yn = list_img_use_yn;
	}
	public String getList_img_link_yn() {
		return list_img_link_yn;
	}
	public void setList_img_link_yn(String list_img_link_yn) {
		this.list_img_link_yn = list_img_link_yn;
	}
	public String getAtch_file_posbl_yn() {
		return atch_file_posbl_yn;
	}
	public void setAtch_file_posbl_yn(String atch_file_posbl_yn) {
		this.atch_file_posbl_yn = atch_file_posbl_yn;
	}
	public String getPerm_extnm() {
		return perm_extnm;
	}
	public void setPerm_extnm(String perm_extnm) {
		this.perm_extnm = perm_extnm;
	}
	public String getMxmm_file_size() {
		return mxmm_file_size;
	}
	public void setMxmm_file_size(String mxmm_file_size) {
		this.mxmm_file_size = mxmm_file_size;
	}
	public String getNticmatr_yn() {
		return nticmatr_yn;
	}
	public void setNticmatr_yn(String nticmatr_yn) {
		this.nticmatr_yn = nticmatr_yn;
	}
	public String getAns_yn() {
		return ans_yn;
	}
	public void setAns_yn(String ans_yn) {
		this.ans_yn = ans_yn;
	}
	public String getCmt_yn() {
		return cmt_yn;
	}
	public void setCmt_yn(String cmt_yn) {
		this.cmt_yn = cmt_yn;
	}
	public String getUser_txt_write_yn() {
		return user_txt_write_yn;
	}
	public void setUser_txt_write_yn(String user_txt_write_yn) {
		this.user_txt_write_yn = user_txt_write_yn;
	}
	public String getUser_txt_del_yn() {
		return user_txt_del_yn;
	}
	public void setUser_txt_del_yn(String user_txt_del_yn) {
		this.user_txt_del_yn = user_txt_del_yn;
	}
	public String getUser_txt_lock_yn() {
		return user_txt_lock_yn;
	}
	public void setUser_txt_lock_yn(String user_txt_lock_yn) {
		this.user_txt_lock_yn = user_txt_lock_yn;
	}
	public String getOrgnl_view_use_yn() {
		return orgnl_view_use_yn;
	}
	public void setOrgnl_view_use_yn(String orgnl_view_use_yn) {
		this.orgnl_view_use_yn = orgnl_view_use_yn;
	}
	public String getInqry_cnd_use_yn() {
		return inqry_cnd_use_yn;
	}
	public void setInqry_cnd_use_yn(String inqry_cnd_use_yn) {
		this.inqry_cnd_use_yn = inqry_cnd_use_yn;
	}
	public String getKword_use_yn() {
		return kword_use_yn;
	}
	public void setKword_use_yn(String kword_use_yn) {
		this.kword_use_yn = kword_use_yn;
	}
	public String getNatn_cd_use_yn() {
		return natn_cd_use_yn;
	}
	public void setNatn_cd_use_yn(String natn_cd_use_yn) {
		this.natn_cd_use_yn = natn_cd_use_yn;
	}
	public String getOutpt_type_cd() {
		return outpt_type_cd;
	}
	public void setOutpt_type_cd(String outpt_type_cd) {
		this.outpt_type_cd = outpt_type_cd;
	}
	public String getTab_use_yn() {
		return tab_use_yn;
	}
	public void setTab_use_yn(String tab_use_yn) {
		this.tab_use_yn = tab_use_yn;
	}
	public String getTab_pdcnt() {
		return tab_pdcnt;
	}
	public void setTab_pdcnt(String tab_pdcnt) {
		this.tab_pdcnt = tab_pdcnt;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	public String getTag_use_yn() {
		return tag_use_yn;
	}
	public void setTag_use_yn(String tag_use_yn) {
		this.tag_use_yn = tag_use_yn;
	}
	public String getMeta_use_yn() {
		return meta_use_yn;
	}
	public void setMeta_use_yn(String meta_use_yn) {
		this.meta_use_yn = meta_use_yn;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getCtgry_use_yn() {
		return ctgry_use_yn;
	}
	public void setCtgry_use_yn(String ctgry_use_yn) {
		this.ctgry_use_yn = ctgry_use_yn;
	}
	public String getBbs_type() {
		return bbs_type;
	}
	public void setBbs_type(String bbs_type) {
		this.bbs_type = bbs_type;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getPtcs_nm() {
		return ptcs_nm;
	}
	public void setPtcs_nm(String ptcs_nm) {
		this.ptcs_nm = ptcs_nm;
	}
	public String getPstofc_nm() {
		return pstofc_nm;
	}
	public void setPstofc_nm(String pstofc_nm) {
		this.pstofc_nm = pstofc_nm;
	}
	public String getCretr_id() {
		return cretr_id;
	}
	public void setCretr_id(String cretr_id) {
		this.cretr_id = cretr_id;
	}
	public java.sql.Date getCret_dtm() {
		return cret_dtm;
	}
	public void setCret_dtm(java.sql.Date cret_dtm) {
		this.cret_dtm = cret_dtm;
	}
	public String getLast_updtr_id() {
		return last_updtr_id;
	}
	public void setLast_updtr_id(String last_updtr_id) {
		this.last_updtr_id = last_updtr_id;
	}
	public java.sql.Date getLast_updt_dtm() {
		return last_updt_dtm;
	}
	public void setLast_updt_dtm(java.sql.Date last_updt_dtm) {
		this.last_updt_dtm = last_updt_dtm;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	
}