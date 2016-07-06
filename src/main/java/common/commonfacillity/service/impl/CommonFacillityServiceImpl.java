package common.commonfacillity.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.commonfacillity.mapper.CommonFacillityMapper;
import common.commonfacillity.service.CommonFacillityService;

@Service("commonFacillityService")
public class CommonFacillityServiceImpl extends AbstractServiceImpl implements CommonFacillityService{
	
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

//  @Resource(name = "common.commonfacillity.mapper.CommonFacillityMapper")
	@Autowired
    private CommonFacillityMapper commonFacillityMapper;
	
    /**
     * 시스템 로그를 저장한다.
     * 
     * @param map
     *            - 저장할 정보가 담긴 Map
     * @return void
     * @exception Exception
     */
    public void logInsertSysLog(Map<String, String> map) throws Exception {
    	log.debug("CommonFacillityServiceImpl logInsertSysLog entering..........");
    	log.debug("CommonFacillityServiceImpl logInsertSysLog::map::" + map);
    	commonFacillityMapper.logInsertSysLog(map);
    }
}