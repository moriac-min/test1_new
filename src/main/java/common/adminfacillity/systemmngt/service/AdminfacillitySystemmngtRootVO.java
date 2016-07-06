package common.adminfacillity.systemmngt.service;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

public class AdminfacillitySystemmngtRootVO extends WqBaseBean {
	private AuthorGroupMenuVO authorGroupMenuVO;
	private AuthorGroupVO authorGroupVO;
	private CommonCodeDataVO commonCodeDataVO;
	private CommonCodeVO commonCodeVO;
	private CommonComboVO commonComboVO;
	private CommonPopupItemVO commonPopupItemVO;
	private CommonPopupVO commonPopupVO;
	private MenuVO menuVO;
	private OrganizationAuthorGroupVO organizationAuthorGroupVO;
	private OrganizationVO organizationVO;
	private ProgramVO programVO;
	private SystemAccessLogVO systemAccessLogVO;
	private SystemMessageVO systemMessageVO;
	private SystemUseLogVO systemUseLogVO;
	private UserVO userVO;
	
	private List infoList;
	private List infoDataList;
	private List returnlist;
	private List commonCodeDataList;
	private List authorMenuList;
	
	public AuthorGroupMenuVO getAuthorGroupMenuVO() {
		return authorGroupMenuVO;
	}
	public void setAuthorGroupMenuVO(AuthorGroupMenuVO authorGroupMenuVO) {
		this.authorGroupMenuVO = authorGroupMenuVO;
	}
	public AuthorGroupVO getAuthorGroupVO() {
		return authorGroupVO;
	}
	public void setAuthorGroupVO(AuthorGroupVO authorGroupVO) {
		this.authorGroupVO = authorGroupVO;
	}
	public CommonComboVO getCommonComboVO() {
		return commonComboVO;
	}
	public void setCommonComboVO(CommonComboVO commonComboVO) {
		this.commonComboVO = commonComboVO;
	}
	public CommonPopupItemVO getCommonPopupItemVO() {
		return commonPopupItemVO;
	}
	public void setCommonPopupItemVO(CommonPopupItemVO commonPopupItemVO) {
		this.commonPopupItemVO = commonPopupItemVO;
	}
	public CommonPopupVO getCommonPopupVO() {
		return commonPopupVO;
	}
	public void setCommonPopupVO(CommonPopupVO commonPopupVO) {
		this.commonPopupVO = commonPopupVO;
	}
	public MenuVO getMenuVO() {
		return menuVO;
	}
	public void setMenuVO(MenuVO menuVO) {
		this.menuVO = menuVO;
	}
	public OrganizationAuthorGroupVO getOrganizationAuthorGroupVO() {
		return organizationAuthorGroupVO;
	}
	public void setOrganizationAuthorGroupVO(
			OrganizationAuthorGroupVO organizationAuthorGroupVO) {
		this.organizationAuthorGroupVO = organizationAuthorGroupVO;
	}
	public OrganizationVO getOrganizationVO() {
		return organizationVO;
	}
	public void setOrganizationVO(OrganizationVO organizationVO) {
		this.organizationVO = organizationVO;
	}
	public ProgramVO getProgramVO() {
		return programVO;
	}
	public void setProgramVO(ProgramVO programVO) {
		this.programVO = programVO;
	}
	public SystemAccessLogVO getSystemAccessLogVO() {
		return systemAccessLogVO;
	}
	public void setSystemAccessLogVO(SystemAccessLogVO systemAccessLogVO) {
		this.systemAccessLogVO = systemAccessLogVO;
	}
	public SystemMessageVO getSystemMessageVO() {
		return systemMessageVO;
	}
	public void setSystemMessageVO(SystemMessageVO systemMessageVO) {
		this.systemMessageVO = systemMessageVO;
	}
	public SystemUseLogVO getSystemUseLogVO() {
		return systemUseLogVO;
	}
	public void setSystemUseLogVO(SystemUseLogVO systemUseLogVO) {
		this.systemUseLogVO = systemUseLogVO;
	}
	public UserVO getUserVO() {
		return userVO;
	}
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	public List getReturnlist() {
		List returnlistTmp = null;
		if(returnlist != null){
			returnlistTmp = returnlist;
		}
		return returnlistTmp;
	}
	public void setReturnlist(List returnlist) {
		this.returnlist = returnlist;
	}
	public List getCommonCodeDataList() {
		List commonCodeDataListTmp = null;
		if(commonCodeDataList != null){
			commonCodeDataListTmp = commonCodeDataList;
		}
		return commonCodeDataListTmp;
	}
	public void setCommonCodeDataList(List commonCodeDataList) {
		this.commonCodeDataList = commonCodeDataList;
	}
	public CommonCodeDataVO getCommonCodeDataVO() {
		return commonCodeDataVO;
	}
	public void setCommonCodeDataVO(CommonCodeDataVO commonCodeDataVO) {
		this.commonCodeDataVO = commonCodeDataVO;
	}
	public CommonCodeVO getCommonCodeVO() {
		return commonCodeVO;
	}
	public void setCommonCodeVO(CommonCodeVO commonCodeVO) {
		this.commonCodeVO = commonCodeVO;
	}
	public List getInfoList() {
		List infoListTmp = null;
		if(infoList != null){
			infoListTmp = infoList;
		}
		return infoListTmp;
	}
	public void setInfoList(List infoList) {
		this.infoList = infoList;
	}
	public List getInfoDataList() {
		List infoDataListTmp = null;
		if(infoDataList != null){
			infoDataListTmp = infoDataList;
		}
		return infoDataListTmp;
	}
	public void setInfoDataList(List infoDataList) {
		this.infoDataList = infoDataList;
	}
	public List getAuthorMenuList() {
		List authorMenuListTmp = null;
		if(authorMenuList != null){
			authorMenuListTmp = authorMenuList;
		}
		return authorMenuListTmp;
	}
	public void setAuthorMenuList(List authorMenuList) {
		this.authorMenuList = authorMenuList;
	}
	
}
