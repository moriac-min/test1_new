package foodportal.minwon.counsel.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.commonfacillity.log.CommonLog;

import foodportal.minwon.counsel.mapper.CounselMapper;
import foodportal.minwon.counsel.service.CounselService;

/**
 * CounselServiceImpl
 * @author 장영철
 * @since 2014.10.16
 * @version 1.0
 * @see
 *
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.16 장영철 최초 생성
 * </pre>
 *
 * Copyright (C) 2014 by NDS., All right reserved.
 */

@Service("CounselService")
public class CounselServiceImpl implements CounselService {
	
	@CommonLog Logger log;

	@Autowired
	CounselMapper counselMapper;

}
