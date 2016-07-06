package common.commonfacillity.service;

import java.util.Map;

public interface CommonFacillityService {
	 /**
     * 시스템 로그를 저장한다.
     * 
     * @param map
     *            - 저장할 정보가 담긴 Map
     * @return void
     * @exception Exception
     */
    public void logInsertSysLog(Map<String, String> map) throws Exception;
}