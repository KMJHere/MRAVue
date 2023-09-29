package com.kmj.safe.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kmj.safe.model.Member;
import com.kmj.safe.service.CommonService;
import com.kmj.safe.service.MemberService;
import com.kmj.safe.common.DatatableUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class JoinController {
	private static Logger logger = LoggerFactory.getLogger(JoinController.class); 
	@Autowired
	private MemberService memberService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private DatatableUtil datatableUtil;
	
	@GetMapping("/join")
	public void join() {
	}
	
	@PostMapping("/join/searchCompanyId")
	@ResponseBody
	public Map<String, Object> searchCompanyId(@RequestParam("draw") String asDtDraw,
			@RequestParam("start") int anDtStart,
			@RequestParam("length") int anDtLength,
			@RequestParam("companyName") String asCompanyName) throws Exception {
		Map<String, Object> mRtnDat = new HashMap<>();
		
		try {
			mRtnDat = datatableUtil.convertData(commonService.selectCompanyLst(asCompanyName, anDtStart, anDtLength), asDtDraw);
		} catch(Exception e) {
			logger.error("searchCompanyIdError: " + e);
		}
		
		return mRtnDat;
	}
	
	@PostMapping("/join/searchProjCode")
	@ResponseBody
	public Map<String, Object> searchProjCode(@RequestParam("draw") String asDtDraw,
			@RequestParam("start") int anDtStart,
			@RequestParam("length") int anDtLength,
			@RequestParam(value="companyId", required=false) Integer asCompanyId,
			@RequestParam("projName") String asProjName) throws Exception {
		Map<String, Object> mRtnDat = new HashMap<>();
		
		try {
			mRtnDat = datatableUtil.convertData(commonService.selectProjLst(asCompanyId, asProjName, anDtStart, anDtLength), asDtDraw);
		} catch(Exception e) {
			logger.error("searchProjCodeError: " + e);
		}
		
		return mRtnDat;
	}
	
	@GetMapping("/join/searchPosiCode")
	@ResponseBody
	public Map<String, Object> searchPosiCode(
			@RequestParam("grpCodeNm") String asGrpCodeNm) throws Exception {
		Map<String, Object> mRtnDat = new HashMap<>();
		
		try {
			mRtnDat.put("data", commonService.selectPosiLst(asGrpCodeNm));
			mRtnDat.put("bSuccess", true);
		} catch(Exception e) {
			logger.error("searchPosiCodeError: " + e);
		}
		
		return mRtnDat;
	}
	
	@PostMapping("/join/joinRegis")
	public String joinRegister(Member member, RedirectAttributes rttr) {
		log.info("Member?" + member);
		
		Integer userNo = memberService.createMember(member); 
		
		log.info("userNo: " + userNo);
		
		rttr.addFlashAttribute("USER_NO", userNo);
		
		return "redirect:/login";
	}
}
