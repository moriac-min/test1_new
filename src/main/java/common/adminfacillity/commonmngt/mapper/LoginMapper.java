package common.adminfacillity.commonmngt.mapper;

import java.util.List;
import java.util.Map;

import common.adminfacillity.commonmngt.service.LoginVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("common.adminfacillity.commonmngt.mapper.LoginMapper")
public interface LoginMapper {
	
	public int selectLogin(Map<String, String> map);
	
	public int insertLogin(Map<String, String> map);
}
