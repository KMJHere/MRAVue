package com.kmj.safe.common;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
@Component
public class DatatableUtil {
	private static Logger logger = LoggerFactory.getLogger(DatatableUtil.class);  
	
	public Map<String, Object> convertData(List<Map<String, Object>> alDat, String asDraw) throws Exception {
		try {
			HashMap<String, Object> mCvtDat = new HashMap<>();
			
			for(Map<String, Object> md : alDat) {
				md.put("DT_RowId", "RID_" + md.get("SORT_NO"));	
			}
			
			int nRecordsTotal = 0;
			int nRecordFiltered = 0;
			
			if(alDat.size() > 0) {
				nRecordsTotal = ((BigDecimal)alDat.get(0).get("TOT_CN")).intValue();
				nRecordFiltered = ((BigDecimal)alDat.get(0).get("FILTERED_CN")).intValue();
			}
			
			mCvtDat.put("draw", asDraw);
			mCvtDat.put("recordsTotal", nRecordsTotal);
			mCvtDat.put("recordsFiltered", nRecordFiltered);
			mCvtDat.put("data", alDat);
			
			return mCvtDat;
		} catch(Exception ex) {
			logger.error("DatatableUtil Error: " + ex.getMessage());
			throw ex;
		}
	} 
}
