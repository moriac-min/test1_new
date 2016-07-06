package foodportal.front.common.mapper;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import foodportal.front.common.vo.FoodBaseVO;
import foodportal.front.common.vo.FoodtypeVO;
import foodportal.front.common.vo.OrgnVO;
import foodportal.front.common.vo.ShopVO;

/**
 * FrontCommonPopupMapper
 * @author 박재형
 * @since 2014.10.07
 * @version 1.0
 * @see
 * 
 * <pre>
 *  Modification Information
 *  수정일      수정자   수정내용
 *  ---------- -------- ---------------------------
 *  2014.10.07 박재형 최초 생성
 * </pre>
 * 
 * Copyright (C) 2014 by NDS., All right reserved.
 */
         
@Mapper("foodportal.front.common.mapper.FrontCommonPopupMapper")
public interface FrontCommonPopupMapper {
	
	/**
	 * 기관목록
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<OrgnVO> searchOrgn(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 기관목록 총개수
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int searchOrgnTotalCnt(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 식품유형목록
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<FoodtypeVO> searchFoodtype(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 식품유형목록 총개수
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int searchFoodtypeTotalCnt(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 원산지목록
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<FoodBaseVO> searchFoodBase(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 원산지목록 총개수
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int searchFoodBaseTotalCnt(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업소목록(등록)
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<ShopVO> searchShop(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업소목록(등록&미등록)
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List<ShopVO> searchAllShop(Map<String, Object> paramMap) throws Exception;
	
	
	/**
	 * 업소목록 총개수
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int searchShopTotalCnt(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업소목록 총개수
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int searchAllShopTotalCnt(Map<String, Object> paramMap) throws Exception;
	
}
