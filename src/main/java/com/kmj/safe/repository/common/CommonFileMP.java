package com.kmj.safe.repository.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface CommonFileMP {	
	/**
	 * <pre>
	 * [파일 목록 Select]     
	 * </pre> 
	 * 	 
	 * @param asJfileGrpNo 파일그룹번호
	 * @return 파일 목록
	 * @throws Exception
	 */
	List<Map<String, Object>> selectFileLst(@Param("jfileGrpNo") String asJfileGrpNo) throws Exception;
	
	
}
