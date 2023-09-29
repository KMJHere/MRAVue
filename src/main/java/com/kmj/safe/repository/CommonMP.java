package com.kmj.safe.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface CommonMP {
	List<Map<String, Object>> selectCompanyLst(
			@RequestParam("asCompanyName") String companyName,
			@RequestParam("anDtStart") int dtStart,
			@RequestParam("anDtLength") int dtLength) throws Exception;
	
	List<Map<String, Object>> selectProjLst(
			@RequestParam("asCompanyId") Integer companyId,
			@RequestParam("asProjName") String projName,
			@RequestParam("anDtStart") int dtStart,
			@RequestParam("anDtLength") int dtLength) throws Exception;
	
	List<Map<String, Object>> selectPosiLst(
			@RequestParam("asGrpCodeNm") String grpCodeNm
			) throws Exception;
}
