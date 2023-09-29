package com.kmj.safe.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kmj.safe.repository.CommonMP;

@Transactional
@Service
public class CommonService {
	@Autowired
	private CommonMP commonMP;

	public List<Map<String, Object>> selectCompanyLst(String asCompanyName, int anDtStart, int anDtLength) throws Exception {
		List<Map<String, Object>> lResult = commonMP.selectCompanyLst(asCompanyName, anDtStart, anDtLength);
		
		return lResult;
	}
	
	public List<Map<String, Object>> selectProjLst(Integer asCompanyId, String asProjName, int anDtStart, int anDtLength) throws Exception {
		List<Map<String, Object>> lResult = commonMP.selectProjLst(asCompanyId, asProjName, anDtStart, anDtLength);
		
		return lResult;
	}
	
	public List<Map<String, Object>> selectPosiLst(String asGrpCodeNm) throws Exception {
		List<Map<String, Object>> lResult = commonMP.selectPosiLst(asGrpCodeNm);
		
		return lResult;
	}
}
