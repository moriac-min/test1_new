package common.commonfacillity.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("common.commonfacillity.mapper.CommonFacillityMapper")
public interface CommonFacillityMapper {
	/**
	 * 시스템 로그를 저장한다.
	 * 
	 * @param map
	 *            - 저장할 정보가 담긴 Map
	 * @return void
	 * @exception Exception
	 */
	public void logInsertSysLog(Map<String, String> map);
}

