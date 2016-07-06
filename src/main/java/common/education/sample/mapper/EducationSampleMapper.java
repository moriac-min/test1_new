package common.education.sample.mapper;

import java.util.List;
import java.util.Map;

import common.education.sample.service.EducationSampleRootVO;
import common.education.sample.service.EducationSampleVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("common.education.sample.mapper.EducationSampleMapper")
public interface EducationSampleMapper {
	
	public List<EducationSampleVO> selectEduSawonList(Map<String, Object> map);
	
	public int countEduSawon(Map<String, Object> map);
	
	public int insertEduSawon(Map<String, Object> map);
	
	public int updateEduSawon(Map<String, Object> map);
	
	public int deleteEduSawon(Map<String, Object> map);
}
