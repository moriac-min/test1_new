package foodportal.admin.systemmngt.vo;

import java.util.List;

import common.commonfacillity.uia.WqBaseBean;

public class AdminSystemmngtRootVO extends WqBaseBean {
	/***************************메뉴정보**************************/
	private MenuVO menuInfo;		
	private MenuVO paramMenuInfo;
	private MenuVO paramMenuList;
	private List menuList;

	private MenuVO paramBbsMoveList;
	private List bbsMoveList;
	
	private MenuVO paramBbsRelmCntntsList;	//
	private MenuVO paramBbsRelmMenuList;	//
	private List paramSaveBbsRelmMenuList;	//
	private List bbsRelmCntntsList;			//
	private List bbsRelmMenuList;			//
	
	/***************************게시판생성**************************/
	private BoardSettingVO boardSettingVO;
	private BoardSettingVO boardSettingInfo;	
	private BoardSettingVO boardSettingCheck;
	private BoardSettingVO paramBoardSettingInfo;
	private List boardSettingList;
	private List paramUserList;
	
	/***************************일반카테고리관리**************************/
	private CategorySettingVO categoryVo;
	private CategorySettingVO paramCategory;
	private List categoryList;
	private List paramCategoryList;
	private List paramRmCtgryList;
	
	/***************************계층카테고리관리**************************/
	private HCategorySettingVo hCategorySettingVo;
	private HCategorySettingVo paramHCategory;
	private HCategorySettingVo lCategorySettingVo;
	private HCategorySettingVo paramLCategory;
	private List hCategorySettingList;
	private List paramHCategorySettingList;
	private List lCategorySettingList;
	private List paramLCategorySettingList;
	
	
	/***************************공통코드관리**************************/
	private CommonCodeVO commonCode;
	private List<CommonCodeVO> commonCodeList;
	
	/***************************메타정보관리**************************/
	private MetaVO paramMeta;
	private UseMetaVO paramUseMeta;
	private List metaList;
	private List useMetaList;
	private List paramUseMetaList;
	
	/***************************사용자별카테고리맵핑**************************/
	private UserCategorySettingVO paramUserCategorySetting;
	private HCategorySettingVo paramUCategorySetting;
	private List userCategorySettingList;
	private List uCategorySettingList;
	private List paramUCategorySettingList;
	
	/***************************게시판관리**************************/
	private AdminBoardVO adminBoardVo;
	private AdminBoardVO paramAdminBoardVo;		//조회파라미터
	private AdminBoardVO adminBoardDetail;		//상세조회결과
	private List adminBoardList;				//목록조회결과
	
	/***************************관련사이트관리**************************/
	private List<AdminBoardVO> relateSiteList;
	
	/***************************뉴스레터관리**************************/
	private NewsLetterVO paramNewsLetterVO;		//조회파라미터
	private NewsLetterVO newsLetterDetail;		//상세조회결과
	private List newsLetterList;				//목록조회결과
	private List newsLetterFileList;				//목록조회결과
	
	/***************************파일업로드**************************/
	private UploadFileVO paramUploadFileVO;		//파일업로드(등록용)
	private UploadFileVO paramDeleteFileVO;		//파일업로드(삭제용)
	private UploadFileVO fileUpload;
	private List<UploadFileVO> fileList;
	
	/***************************이슈발생시관리**************************/
	private IssueVO issueVO;
	private IssueVO paramIssueVO;
	private IssueVO resultIssueVO;
	
	/***************************권한**************************/
	private AuthVO auth;
	private List<AuthVO> authList;
	
	/***************************담당자팝업**************************/
	private UserSearchVO userSearchVO;
	private UserSearchVO paramUserSearchInfo;
	private List userSearchList;
	
	/***************************권한별 메뉴**************************/
	private MenuVO menu;
	private AuthMenuVO authMenu;
	private List<AuthMenuVO> authMenuList;
	
	/***************************사용자별 권한**************************/
	private UserVO user;
	private List<UserVO> userList;
	private UserAuthVO userAuth;
	private List<UserAuthVO> userAuthList;
	private UserAuthMenuVO userAuthMenu;
	private List<UserAuthMenuVO> userAuthMenuList;
	
	/***************************배너관리**************************/
	private BannerVO bannerVO;
	private BannerVO paramBannerVO;
	private List bannerList;
	private List paramBannerList;
	private List paramRmBannerList;
	
	/***************************생애주기별정보관리**************************/
	private LifeCycleVO lifeCycleVO;
	private LifeCycleVO paramLifeCycleVO;
	
	/***************************캘린더**************************/
	private CalMngtVO calMngt;
	private CalMngtVO paramCalMngt;
	private CalMngtVO paramDateNo;
	private List<CalMngtVO> calMngtList;
	
	/***************************업체관리**************************/
	private EnterpriseVO enterprise;
	private List<EnterpriseVO> enterpriseList;
	private EnterpriseMemberVO enterpriseMember;
	private List<EnterpriseMemberVO> enterpriseMemberList;
	
	/***************************식생활 게시글 연결 관리**************************/
	private FoodLifeVO paramFoodLifeVO;
	private FoodLifeVO foodLifeVO;
	private List foodLifeList;

	/***************************메타팝업**************************/
	private MetaKeyPopupVO metaKeyPopupVO;
	private MetaKeyPopupVO paramMetaKeyPopupInfo;
	private List metaKeyPopupList;	
	
	public MenuVO getMenuInfo() {
		return menuInfo;
	}
	public void setMenuInfo(MenuVO menuInfo) {
		this.menuInfo = menuInfo;
	}
	public MenuVO getParamMenuInfo() {
		return paramMenuInfo;
	}
	public void setParamMenuInfo(MenuVO paramMenuInfo) {
		this.paramMenuInfo = paramMenuInfo;
	}
	public MenuVO getParamMenuList() {
		return paramMenuList;
	}
	public void setParamMenuList(MenuVO paramMenuList) {
		this.paramMenuList = paramMenuList;
	}
	public BoardSettingVO getBoardSettingVO() {
		return boardSettingVO;
	}
	public void setBoardSettingVO(BoardSettingVO boardSettingVO) {
		this.boardSettingVO = boardSettingVO;
	}
	public BoardSettingVO getBoardSettingInfo() {
		return boardSettingInfo;
	}
	public void setBoardSettingInfo(BoardSettingVO boardSettingInfo) {
		this.boardSettingInfo = boardSettingInfo;
	}
	public BoardSettingVO getBoardSettingCheck() {
		return boardSettingCheck;
	}
	public void setBoardSettingCheck(BoardSettingVO boardSettingCheck) {
		this.boardSettingCheck = boardSettingCheck;
	}
	public BoardSettingVO getParamBoardSettingInfo() {
		return paramBoardSettingInfo;
	}
	public void setParamBoardSettingInfo(BoardSettingVO paramBoardSettingInfo) {
		this.paramBoardSettingInfo = paramBoardSettingInfo;
	}
	public CategorySettingVO getCategoryVo() {
		return categoryVo;
	}
	public void setCategoryVo(CategorySettingVO categoryVo) {
		this.categoryVo = categoryVo;
	}
	public CategorySettingVO getParamCategory() {
		return paramCategory;
	}
	public void setParamCategory(CategorySettingVO paramCategory) {
		this.paramCategory = paramCategory;
	}
	public HCategorySettingVo gethCategorySettingVo() {
		return hCategorySettingVo;
	}
	public void sethCategorySettingVo(HCategorySettingVo hCategorySettingVo) {
		this.hCategorySettingVo = hCategorySettingVo;
	}
	public HCategorySettingVo getParamHCategory() {
		return paramHCategory;
	}
	public void setParamHCategory(HCategorySettingVo paramHCategory) {
		this.paramHCategory = paramHCategory;
	}
	public HCategorySettingVo getlCategorySettingVo() {
		return lCategorySettingVo;
	}
	public void setlCategorySettingVo(HCategorySettingVo lCategorySettingVo) {
		this.lCategorySettingVo = lCategorySettingVo;
	}
	public HCategorySettingVo getParamLCategory() {
		return paramLCategory;
	}
	public void setParamLCategory(HCategorySettingVo paramLCategory) {
		this.paramLCategory = paramLCategory;
	}
	public List getMenuList() {
		List menuListTmp = null;
		if(menuList != null){
			menuListTmp = menuList;
		}
		return menuListTmp;
	}
	public void setMenuList(List menuList) {
		this.menuList = menuList;
	}
	public List getBoardSettingList() {
		List boardSettingListTmp = null;
		if(boardSettingList != null){
			boardSettingListTmp = boardSettingList;
		}
		return boardSettingListTmp;
	}
	public void setBoardSettingList(List boardSettingList) {
		this.boardSettingList = boardSettingList;
	}
	public List getParamUserList() {
		List paramUserListTmp = null;
		if(paramUserList != null){
			paramUserListTmp = paramUserList;
		}
		return paramUserListTmp;
	}
	public void setParamUserList(List paramUserList) {
		this.paramUserList = paramUserList;
	}
	public List getCategoryList() {
		List categoryListTmp = null;
		if(categoryList != null){
			categoryListTmp = categoryList;
		}
		return categoryListTmp;
	}
	public void setCategoryList(List categoryList) {
		this.categoryList = categoryList;
	}
	public List getParamCategoryList() {
		List paramCategoryListTmp = null;
		if(paramCategoryList != null){
			paramCategoryListTmp = paramCategoryList;
		}
		return paramCategoryListTmp;
	}
	public void setParamCategoryList(List paramCategoryList) {
		this.paramCategoryList = paramCategoryList;
	}
	public List getParamRmCtgryList() {
		List paramRmCtgryListTmp = null;
		if(paramRmCtgryList != null){
			paramRmCtgryListTmp = paramRmCtgryList;
		}
		return paramRmCtgryListTmp;
	}
	public void setParamRmCtgryList(List paramRmCtgryList) {
		this.paramRmCtgryList = paramRmCtgryList;
	}
	public List gethCategorySettingList() {
		List hCategorySettingListTmp = null;
		if(hCategorySettingList != null){
			hCategorySettingListTmp = hCategorySettingList;
		}
		return hCategorySettingListTmp;
	}
	public void sethCategorySettingList(List hCategorySettingList) {
		this.hCategorySettingList = hCategorySettingList;
	}
	public List getParamHCategorySettingList() {
		List paramHCategorySettingListTmp = null;
		if(paramHCategorySettingList != null){
			paramHCategorySettingListTmp = paramHCategorySettingList;
		}
		return paramHCategorySettingListTmp;
	}
	public void setParamHCategorySettingList(List paramHCategorySettingList) {
		this.paramHCategorySettingList = paramHCategorySettingList;
	}
	public List getlCategorySettingList() {
		List lCategorySettingListTmp = null;
		if(lCategorySettingList != null){
			lCategorySettingListTmp = lCategorySettingList;
		}
		return lCategorySettingListTmp;
	}
	public void setlCategorySettingList(List lCategorySettingList) {
		this.lCategorySettingList = lCategorySettingList;
	}
	public List getParamLCategorySettingList() {
		List paramLCategorySettingListTmp = null;
		if(paramLCategorySettingList != null){
			paramLCategorySettingListTmp = paramLCategorySettingList;
		}
		return paramLCategorySettingListTmp;
	}
	public void setParamLCategorySettingList(List paramLCategorySettingList) {
		this.paramLCategorySettingList = paramLCategorySettingList;
	}
	public CommonCodeVO getCommonCode() {
		return commonCode;
	}
	public void setCommonCode(CommonCodeVO commonCode) {
		this.commonCode = commonCode;
	}
	public List<CommonCodeVO> getCommonCodeList() {
		List<CommonCodeVO> commonCodeListTmp = null;
		if(commonCodeList != null){
			commonCodeListTmp = commonCodeList;
		}
		return commonCodeListTmp;
	}
	public void setCommonCodeList(List<CommonCodeVO> commonCodeList) {
		this.commonCodeList = commonCodeList;
	}
	public List getMetaList() {
		List metaListTmp = null;
		if(metaList != null){
			metaListTmp = metaList;
		}
		return metaListTmp;
	}
	public void setMetaList(List metaList) {
		this.metaList = metaList;
	}
	public List getUseMetaList() {
		List useMetaListTmp = null;
		if(useMetaList != null){
			useMetaListTmp = useMetaList;
		}
		return useMetaListTmp;
	}
	public void setUseMetaList(List useMetaList) {
		this.useMetaList = useMetaList;
	}
	public MetaVO getParamMeta() {
		return paramMeta;
	}
	public void setParamMeta(MetaVO paramMeta) {
		this.paramMeta = paramMeta;
	}
	public UseMetaVO getParamUseMeta() {
		return paramUseMeta;
	}
	public void setParamUseMeta(UseMetaVO paramUseMeta) {
		this.paramUseMeta = paramUseMeta;
	}
	public List getParamUseMetaList() {
		List paramUseMetaListTmp = null;
		if(paramUseMetaList != null){
			paramUseMetaListTmp = paramUseMetaList;
		}
		return paramUseMetaListTmp;
	}
	public void setParamUseMetaList(List paramUseMetaList) {
		this.paramUseMetaList = paramUseMetaList;
	}
	public AdminBoardVO getNtcTxtVo() {
		return adminBoardVo;
	}
	public void setAdminBoardVo(AdminBoardVO adminBoardVo) {
		this.adminBoardVo = adminBoardVo;
	}
	public List getAdminBoardList() {
		List adminBoardListTmp = null;
		if(adminBoardList != null){
			adminBoardListTmp = adminBoardList;
		}
		return adminBoardListTmp;
	}
	public void setAdminBoardList(List adminBoardList) {
		this.adminBoardList = adminBoardList;
	}
	public UserCategorySettingVO getParamUserCategorySetting() {
		return paramUserCategorySetting;
	}
	public void setParamUserCategorySetting(
			UserCategorySettingVO paramUserCategorySetting) {
		this.paramUserCategorySetting = paramUserCategorySetting;
	}
	public HCategorySettingVo getParamUCategorySetting() {
		return paramUCategorySetting;
	}
	public void setParamUCategorySetting(HCategorySettingVo paramUCategorySetting) {
		this.paramUCategorySetting = paramUCategorySetting;
	}
	public List getUserCategorySettingList() {
		List userCategorySettingListTmp = null;
		if(userCategorySettingList != null){
			userCategorySettingListTmp = userCategorySettingList;
		}
		return userCategorySettingListTmp;
	}
	public void setUserCategorySettingList(List userCategorySettingList) {
		this.userCategorySettingList = userCategorySettingList;
	}
	public List getuCategorySettingList() {
		List uCategorySettingListTmp = null;
		if(uCategorySettingList != null){
			uCategorySettingListTmp = uCategorySettingList;
		}
		return uCategorySettingListTmp;
	}
	public void setuCategorySettingList(List uCategorySettingList) {
		this.uCategorySettingList = uCategorySettingList;
	}
	public List getParamUCategorySettingList() {
		List paramUCategorySettingListTmp = null;
		if(paramUCategorySettingList != null){
			paramUCategorySettingListTmp = paramUCategorySettingList;
		}
		return paramUCategorySettingListTmp;
	}
	public void setParamUCategorySettingList(List paramUCategorySettingList) {
		this.paramUCategorySettingList = paramUCategorySettingList;
	}
	public AdminBoardVO getParamAdminBoardVo() {
		return paramAdminBoardVo;
	}
	public void setParamAdminBoardVo(AdminBoardVO paramAdminBoardVo) {
		this.paramAdminBoardVo = paramAdminBoardVo;
	}
	public AdminBoardVO getAdminBoardVo() {
		return adminBoardVo;
	}
	public IssueVO getIssueVO() {
		return issueVO;
	}
	public void setIssueVO(IssueVO issueVO) {
		this.issueVO = issueVO;
	}
	public IssueVO getParamIssueVO() {
		return paramIssueVO;
	}
	public void setParamIssueVO(IssueVO paramIssueVO) {
		this.paramIssueVO = paramIssueVO;
	}
	public IssueVO getResultIssueVO() {
		return resultIssueVO;
	}
	public void setResultIssueVO(IssueVO resultIssueVO) {
		this.resultIssueVO = resultIssueVO;
	}
	public AdminBoardVO getAdminBoardDetail() {
		return adminBoardDetail;
	}
	public void setAdminBoardDetail(AdminBoardVO adminBoardDetail) {
		this.adminBoardDetail = adminBoardDetail;
	}
	public AuthVO getAuth() {
		return auth;
	}
	public void setAuth(AuthVO auth) {
		this.auth = auth;
	}
	public List<AuthVO> getAuthList() {
		List<AuthVO> authListTmp = null;
		if(authList != null){
			authListTmp = authList;
		}
		return authListTmp;
	}
	public void setAuthList(List<AuthVO> authList) {
		this.authList = authList;
	}
	public UserSearchVO getUserSearchVO() {
		return userSearchVO;
	}
	public void setUserSearchVO(UserSearchVO userSearchVO) {
		this.userSearchVO = userSearchVO;
	}
	public UserSearchVO getParamUserSearchInfo() {
		return paramUserSearchInfo;
	}
	public void setParamUserSearchInfo(UserSearchVO paramUserSearchInfo) {
		this.paramUserSearchInfo = paramUserSearchInfo;
	}
	public List getUserSearchList() {
		List userSearchListTmp = null;
		if(userSearchList != null){
			userSearchListTmp = userSearchList;
		}
		return userSearchListTmp;
	}
	public void setUserSearchList(List userSearchList) {
		this.userSearchList = userSearchList;
	}
	public MenuVO getMenu() {
		return menu;
	}
	public void setMenu(MenuVO menu) {
		this.menu = menu;
	}
	public AuthMenuVO getAuthMenu() {
		return authMenu;
	}
	public void setAuthMenu(AuthMenuVO authMenu) {
		this.authMenu = authMenu;
	}
	public List<AuthMenuVO> getAuthMenuList() {
		List<AuthMenuVO> authMenuListTmp = null;
		if(authMenuList != null){
			authMenuListTmp = authMenuList;
		}
		return authMenuListTmp;
	}
	public void setAuthMenuList(List<AuthMenuVO> authMenuList) {
		this.authMenuList = authMenuList;
	}
	public MenuVO getParamBbsMoveList() {
		return paramBbsMoveList;
	}
	public void setParamBbsMoveList(MenuVO paramBbsMoveList) {
		this.paramBbsMoveList = paramBbsMoveList;
	}
	public List getBbsMoveList() {
		List bbsMoveListTmp = null;
		if(bbsMoveList != null){
			bbsMoveListTmp = bbsMoveList;
		}
		return bbsMoveListTmp;
	}
	public void setBbsMoveList(List bbsMoveList) {
		this.bbsMoveList = bbsMoveList;
	}
	public BannerVO getBannerVO() {
		return bannerVO;
	}
	public void setBannerVO(BannerVO bannerVO) {
		this.bannerVO = bannerVO;
	}
	public BannerVO getParamBannerVO() {
		return paramBannerVO;
	}
	public void setParamBannerVO(BannerVO paramBannerVO) {
		this.paramBannerVO = paramBannerVO;
	}
	public List getBannerList() {
		List bannerListTmp = null;
		if(bannerList != null){
			bannerListTmp = bannerList;
		}
		return bannerListTmp;
	}
	public void setBannerList(List bannerList) {
		this.bannerList = bannerList;
	}
	public List getParamBannerList() {
		List paramBannerListTmp = null;
		if(paramBannerList != null){
			paramBannerListTmp = paramBannerList;
		}
		return paramBannerListTmp;
	}
	public void setParamBannerList(List paramBannerList) {
		this.paramBannerList = paramBannerList;
	}
	public List getParamRmBannerList() {
		List paramRmBannerListTmp = null;
		if(paramRmBannerList != null){
			paramRmBannerListTmp = paramRmBannerList;
		}
		return paramRmBannerListTmp;
	}
	public void setParamRmBannerList(List paramRmBannerList) {
		this.paramRmBannerList = paramRmBannerList;
	}
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	public List<UserVO> getUserList() {
		List<UserVO> userListTmp = null;
		if(userList != null){
			userListTmp = userList;
		}
		return userListTmp;
	}
	public void setUserList(List<UserVO> userList) {
		this.userList = userList;
	}
	public UserAuthVO getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(UserAuthVO userAuth) {
		this.userAuth = userAuth;
	}
	public List<UserAuthVO> getUserAuthList() {
		List<UserAuthVO> userAuthListTmp = null;
		if(userAuthList != null){
			userAuthListTmp = userAuthList;
		}
		return userAuthListTmp;
	}
	public void setUserAuthList(List<UserAuthVO> userAuthList) {
		this.userAuthList = userAuthList;
	}
	public UserAuthMenuVO getUserAuthMenu() {
		return userAuthMenu;
	}
	public void setUserAuthMenu(UserAuthMenuVO userAuthMenu) {
		this.userAuthMenu = userAuthMenu;
	}
	public List<UserAuthMenuVO> getUserAuthMenuList() {
		List<UserAuthMenuVO> userAuthMenuListTmp = null;
		if(userAuthMenuList != null){
			userAuthMenuListTmp = userAuthMenuList;
		}
		return userAuthMenuListTmp;
	}
	public void setUserAuthMenuList(List<UserAuthMenuVO> userAuthMenuList) {
		this.userAuthMenuList = userAuthMenuList;
	}
	public LifeCycleVO getLifeCycleVO() {
		return lifeCycleVO;
	}
	public void setLifeCycleVO(LifeCycleVO lifeCycleVO) {
		this.lifeCycleVO = lifeCycleVO;
	}
	public LifeCycleVO getParamLifeCycleVO() {
		return paramLifeCycleVO;
	}
	public void setParamLifeCycleVO(LifeCycleVO paramLifeCycleVO) {
		this.paramLifeCycleVO = paramLifeCycleVO;
	}
	public NewsLetterVO getParamNewsLetterVO() {
		return paramNewsLetterVO;
	}
	public void setParamNewsLetterVO(NewsLetterVO paramNewsLetterVO) {
		this.paramNewsLetterVO = paramNewsLetterVO;
	}
	public NewsLetterVO getNewsLetterDetail() {
		return newsLetterDetail;
	}
	public void setNewsLetterDetail(NewsLetterVO newsLetterDetail) {
		this.newsLetterDetail = newsLetterDetail;
	}
	public List getNewsLetterList() {
		List newsLetterListTmp = null;
		if(newsLetterList != null){
			newsLetterListTmp = newsLetterList;
		}
		return newsLetterListTmp;
	}
	public void setNewsLetterList(List newsLetterList) {
		this.newsLetterList = newsLetterList;
	}
	public List getNewsLetterFileList() {
		List newsLetterFileListTmp = null;
		if(newsLetterFileList != null){
			newsLetterFileListTmp = newsLetterFileList;
		}
		return newsLetterFileListTmp;
	}
	public void setNewsLetterFileList(List newsLetterFileList) {
		this.newsLetterFileList = newsLetterFileList;
	}
	public List<AdminBoardVO> getRelateSiteList() {
		List<AdminBoardVO> relateSiteListTmp = null;
		if(relateSiteList != null){
			relateSiteListTmp = relateSiteList;
		}
		return relateSiteListTmp;
	}
	public void setRelateSiteList(List<AdminBoardVO> relateSiteList) {
		this.relateSiteList = relateSiteList;
	}
	public CalMngtVO getCalMngt() {
		return calMngt;
	}
	public void setCalMngt(CalMngtVO calMngt) {
		this.calMngt = calMngt;
	}
	public CalMngtVO getParamCalMngt() {
		return paramCalMngt;
	}
	public void setParamCalMngt(CalMngtVO paramCalMngt) {
		this.paramCalMngt = paramCalMngt;
	}
	public CalMngtVO getParamDateNo() {
		return paramDateNo;
	}
	public void setParamDateNo(CalMngtVO paramDateNo) {
		this.paramDateNo = paramDateNo;
	}
	public List<CalMngtVO> getCalMngtList() {
		List<CalMngtVO> calMngtListTmp = null;
		if(calMngtList != null){
			calMngtListTmp = calMngtList;
		}
		return calMngtListTmp;
	}
	public void setCalMngtList(List<CalMngtVO> calMngtList) {
		this.calMngtList = calMngtList;
	}
	public EnterpriseVO getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(EnterpriseVO enterprise) {
		this.enterprise = enterprise;
	}
	public List<EnterpriseVO> getEnterpriseList() {
		List<EnterpriseVO> enterpriseListTmp = null;
		if(enterpriseList != null){
			enterpriseListTmp = enterpriseList;
		}
		return enterpriseListTmp;
	}
	public void setEnterpriseList(List<EnterpriseVO> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}
	public EnterpriseMemberVO getEnterpriseMember() {
		return enterpriseMember;
	}
	public void setEnterpriseMember(EnterpriseMemberVO enterpriseMember) {
		this.enterpriseMember = enterpriseMember;
	}
	public List<EnterpriseMemberVO> getEnterpriseMemberList() {
		List<EnterpriseMemberVO> enterpriseMemberListTmp = null;
		if(enterpriseMemberList != null){
			enterpriseMemberListTmp = enterpriseMemberList;
		}
		return enterpriseMemberListTmp;
	}
	public void setEnterpriseMemberList(
			List<EnterpriseMemberVO> enterpriseMemberList) {
		this.enterpriseMemberList = enterpriseMemberList;
	}
	public UploadFileVO getParamUploadFileVO() {
		return paramUploadFileVO;
	}
	public void setParamUploadFileVO(UploadFileVO paramUploadFileVO) {
		this.paramUploadFileVO = paramUploadFileVO;
	}
	public UploadFileVO getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(UploadFileVO fileUpload) {
		this.fileUpload = fileUpload;
	}
	public UploadFileVO getParamDeleteFileVO() {
		return paramDeleteFileVO;
	}
	public void setParamDeleteFileVO(UploadFileVO paramDeleteFileVO) {
		this.paramDeleteFileVO = paramDeleteFileVO;
	}
	public FoodLifeVO getParamFoodLifeVO() {
		return paramFoodLifeVO;
	}
	public void setParamFoodLifeVO(FoodLifeVO paramFoodLifeVO) {
		this.paramFoodLifeVO = paramFoodLifeVO;
	}
	public FoodLifeVO getFoodLifeVO() {
		return foodLifeVO;
	}
	public void setFoodLifeVO(FoodLifeVO foodLifeVO) {
		this.foodLifeVO = foodLifeVO;
	}
	public List getFoodLifeList() {
		List foodLifeListTmp = null;
		if(foodLifeList != null){
			foodLifeListTmp = foodLifeList;
		}
		return foodLifeListTmp;
	}
	public void setFoodLifeList(List foodLifeList) {
		this.foodLifeList = foodLifeList;
	}
	public MenuVO getParamBbsRelmCntntsList() {
		return paramBbsRelmCntntsList;
	}
	public void setParamBbsRelmCntntsList(MenuVO paramBbsRelmCntntsList) {
		this.paramBbsRelmCntntsList = paramBbsRelmCntntsList;
	}
	public List getBbsRelmCntntsList() {
		List bbsRelmCntntsListTmp = null;
		if(bbsRelmCntntsList != null){
			bbsRelmCntntsListTmp = bbsRelmCntntsList;
		}
		return bbsRelmCntntsListTmp;
	}
	public void setBbsRelmCntntsList(List bbsRelmCntntsList) {
		this.bbsRelmCntntsList = bbsRelmCntntsList;
	}
	public List<UploadFileVO> getFileList() {
		List<UploadFileVO> fileListTmp = null;
		if(fileList != null){
			fileListTmp = fileList;
		}
		return fileListTmp;
	}
	public void setFileList(List<UploadFileVO> fileList) {
		this.fileList = fileList;
	}
	public MetaKeyPopupVO getMetaKeyPopupVO() {
		return metaKeyPopupVO;
	}
	public void setMetaKeyPopupVO(MetaKeyPopupVO metaKeyPopupVO) {
		this.metaKeyPopupVO = metaKeyPopupVO;
	}
	public MetaKeyPopupVO getParamMetaKeyPopupInfo() {
		return paramMetaKeyPopupInfo;
	}
	public void setParamMetaKeyPopupInfo(MetaKeyPopupVO paramMetaKeyPopupInfo) {
		this.paramMetaKeyPopupInfo = paramMetaKeyPopupInfo;
	}
	public List getMetaKeyPopupList() {
		List metaKeyPopupListTmp = null;
		if(metaKeyPopupList != null){
			metaKeyPopupListTmp = metaKeyPopupList;
		}
		return metaKeyPopupListTmp;
	}
	public void setMetaKeyPopupList(List metaKeyPopupList) {
		this.metaKeyPopupList = metaKeyPopupList;
	}
	public MenuVO getParamBbsRelmMenuList() {
		return paramBbsRelmMenuList;
	}
	public void setParamBbsRelmMenuList(MenuVO paramBbsRelmMenuList) {
		this.paramBbsRelmMenuList = paramBbsRelmMenuList;
	}
	public List getBbsRelmMenuList() {
		List bbsRelmMenuListTmp = null;
		if(bbsRelmMenuList != null){
			bbsRelmMenuListTmp = bbsRelmMenuList;
		}
		return bbsRelmMenuListTmp;
	}
	public void setBbsRelmMenuList(List bbsRelmMenuList) {
		this.bbsRelmMenuList = bbsRelmMenuList;
	}
	public List getParamSaveBbsRelmMenuList() {
		List paramSaveBbsRelmMenuListTmp = null;
		if(paramSaveBbsRelmMenuList != null){
			paramSaveBbsRelmMenuListTmp = paramSaveBbsRelmMenuList;
		}
		return paramSaveBbsRelmMenuListTmp;
	}
	public void setParamSaveBbsRelmMenuList(List paramSaveBbsRelmMenuList) {
		this.paramSaveBbsRelmMenuList = paramSaveBbsRelmMenuList;
	}
	
	
}
