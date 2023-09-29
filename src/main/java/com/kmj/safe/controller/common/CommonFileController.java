package com.kmj.safe.controller.common;


import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.kmj.safe.service.common.CommonFileService;


@Controller
public class CommonFileController {	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonFileController.class);
	
	@Autowired
	private CommonFileService commonFileService;
	
			
	@RequestMapping("/common/file/selectFileLst.do")
	@ResponseBody	
	public String selectFileLst(@RequestBody  Map<String, Object> amDat) throws Exception {		

		String sMsg = "";
		
		try {						
			
			 commonFileService.selectFilList(amDat.get("JFILE_GRP_NO").toString());
			 sMsg = "success";
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
		
		return sMsg;
	}
	
	
	
	/**
	 * <pre>
	 * [파일 업로드]     
	 * </pre>  
	 * 
	 * @param aMultiPartRequest
	 * @return 파일
	 */
	@RequestMapping("/common/file/uploadMultiByWs.do")	
	public void uploadMultiByWs(MultipartHttpServletRequest aMultiPartRequest, HttpServletResponse aResponse) throws Exception {
		commonFileService.upload(aMultiPartRequest, aResponse);
	}
	

	
}
