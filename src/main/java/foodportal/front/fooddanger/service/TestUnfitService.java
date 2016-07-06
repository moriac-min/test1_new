package foodportal.front.fooddanger.service;

import java.util.Map;

/**
 * TestUnfitService
 * @author 최승희
 * @since 2014.10.02
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.02 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface TestUnfitService {

	Map<String, Object> selectTestUnfitList(Map<String, Object> map) throws Exception;

	Map<String, Object> selectTestUnfitDetail(Map<String, Object> map) throws Exception;

	Map<String, Object> selectTestUnfitAbrdList(Map<String, Object> map) throws Exception;

}
