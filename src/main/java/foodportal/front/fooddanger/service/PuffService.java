package foodportal.front.fooddanger.service;

import java.util.Map;

/**
 * PuffService
 * @author 최승희
 * @since 2014.10.06
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일     수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.06 최승희 	최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */

public interface PuffService {

	Map<String, Object> selectPuffList(Map<String, Object> map) throws Exception;

	Map<String, Object> selectPuffDetail(Map<String, Object> map) throws Exception;

}
