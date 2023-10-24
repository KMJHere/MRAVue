package com.kmj.safe.repository.sfas;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kmj.safe.model.AssmntContent;
import com.kmj.safe.model.AssmntDtlContent;

@Mapper
public interface AssmntMP {
	List<AssmntContent> selectAssmntLst(Map<String, Object> usrInfo);
	
	List<AssmntDtlContent> selectAssmnDtltLst(String REGIS_SEQ);
	
	int insertAssmntLst(AssmntContent assmntContent);
	
	int insertAssmntDtlLst(AssmntDtlContent assmntContent);
	
	int updateAssmntLst(AssmntContent assmntContent);
}
