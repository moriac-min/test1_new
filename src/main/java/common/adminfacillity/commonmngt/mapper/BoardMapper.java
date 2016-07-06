package common.adminfacillity.commonmngt.mapper;

import java.util.List;
import java.util.Map;

import common.adminfacillity.commonmngt.service.BoardVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("common.adminfacillity.commonmngt.mapper.BoardMapper")
public interface BoardMapper {
	
	public List<Map<String, Object>> selectBoard(BoardVO vo);
		
	public List<Map<String, Object>> searchBoard(BoardVO vo);
	
	public void insertBoard(BoardVO vo);
	
	public void updateBoard(BoardVO vo);
	
	public void deleteBoard(BoardVO vo);
}
