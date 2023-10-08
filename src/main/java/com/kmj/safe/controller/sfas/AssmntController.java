package com.kmj.safe.controller.sfas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kmj.safe.model.AssmntContent;
import com.kmj.safe.model.AssmntDtlContent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kmj.safe.service.sfas.AssmntService;

@RestController
public class AssmntController {
	@Autowired 
	private AssmntService assmntService;

	@CrossOrigin(origins = "http://localhost:8080/assmntList")
	@GetMapping("/sfas/AssmntList")
	public List<AssmntContent> selectAssmntLst(Model model) throws Exception {	
		
		List<AssmntContent> assmntContent = assmntService.selectAssmntLst();
        model.addAttribute("AssmntLst", assmntContent);
        
        return assmntContent;
	}
	
	@GetMapping("/sfas/AssmntDtlList")
	public List<AssmntDtlContent> selectAssmnDtltLst(HttpServletRequest request, Model model, @RequestParam(required = false, defaultValue = "") String REGIS_SEQ) throws Exception {	
		
		List<AssmntDtlContent> assmntContent = assmntService.selectAssmntDtlLst(REGIS_SEQ);
        model.addAttribute("AssmntDtlLst", assmntContent);
       
        return assmntContent;
	}
}
