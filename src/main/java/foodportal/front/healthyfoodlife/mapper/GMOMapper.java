package foodportal.front.healthyfoodlife.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.fooddanger.vo.FoodDangerFileVO;
import foodportal.front.healthyfoodlife.vo.ExamOrgnVO;
import foodportal.front.healthyfoodlife.vo.ExamStateVO;

@Mapper("foodportal.front.healthyfoodlife.mapper.GMOMapper")
public interface GMOMapper {
	/**
	 * 심사현황 목록
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<ExamStateVO> selectExamState(Map<String, Object> map);
	
	/*public List<ExamStateVO> selectExamState(Map<String, Object> map);*/
	/**
	 * 심사현황 목록개수
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectExamStateCnt(Map<String, Object> map);
	
	/**
	 * 심사현황 상세페이지
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public ExamStateVO selectExamStateDetail(Map<String, Object> map);
	
	/**
	 * 심사기관 목록 페이지이동
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<ExamOrgnVO> selectExamOrgn(Map<String, Object> map);
	
	/**
	 * 심사기관 목록개수
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int selectExamOrgnCnt(Map<String, Object> map);
	
	/**
	 * 심사기관 상세페이지
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public ExamOrgnVO selectExamOrgnDetail(Map<String, Object> map);
	
	/**
	 * 심사기관 첨부파일
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<FoodDangerFileVO> selectAttachFileList(Map<String, Object> map);
}
