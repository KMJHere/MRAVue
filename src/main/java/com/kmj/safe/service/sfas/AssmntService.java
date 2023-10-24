package com.kmj.safe.service.sfas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.kmj.safe.common.UserInfo;
import com.kmj.safe.model.AssmntContent;
import com.kmj.safe.model.AssmntDtlContent;
import com.kmj.safe.model.ResultAssmntContent;
import com.kmj.safe.repository.sfas.AssmntMP;

@Service
@Transactional
public class AssmntService {
	@Autowired
	private AssmntMP assmntMP;
	@Autowired
	private UserInfo userInfo;
	
	public List<AssmntContent> selectAssmntLst() throws Exception {
		return assmntMP.selectAssmntLst(userInfo.getFixData());
	}
	
	public List<AssmntDtlContent> selectAssmntDtlLst(String REGIS_SEQ) throws Exception {
		return assmntMP.selectAssmnDtltLst(REGIS_SEQ);
	}
	
	public ResultAssmntContent saveAssmntLst(List<AssmntContent> assmntContent) throws Exception {
		ResultAssmntContent rContent = new ResultAssmntContent();
		
		for(AssmntContent model : assmntContent) {
			if(model.getROW_TYPE().equals("I") ) {
				rContent = insertAssmntLst(model);
				
				if(rContent.getState() == false) break;
			} else if(model.getROW_TYPE().equals("U")) {
				rContent = updateAssmntLst(model);
				
				if(rContent.getState() == false) break;
			}
		}
		
		return rContent;
	}
	
	public ResultAssmntContent insertAssmntLst(AssmntContent assmntContent) throws Exception {		
		ResultAssmntContent rContent = new ResultAssmntContent();
		int state = assmntMP.insertAssmntLst(assmntContent);
		
		if(state == 1) {
			rContent.setState(true);
			rContent.setMessage("정상적으로 처리되었습니다.");
		} else {
			rContent.setState(false);
			rContent.setMessage("수정이 실패했습니다.");
			return rContent;
		}
		
		return rContent;
	}
	
	public ResultAssmntContent updateAssmntLst(AssmntContent assmntContent) throws Exception {	
		ResultAssmntContent rContent = new ResultAssmntContent();	
		int state = assmntMP.updateAssmntLst(assmntContent);
		
		if(state == 1) {
			rContent.setState(true);
			rContent.setMessage("정상적으로 처리되었습니다.");
		} else {
			rContent.setState(false);
			rContent.setMessage("수정이 실패했습니다.");
			return rContent;
		}
		
		return rContent;
	}

}
