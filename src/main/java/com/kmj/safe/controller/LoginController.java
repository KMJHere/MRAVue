package com.kmj.safe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kmj.safe.common.UserInfo;

@RestController
public class LoginController {
	@Autowired
	private HttpSession session;
	@Autowired
	private UserInfo userInfo;

	
	@GetMapping("/mraLogin")
	public Map<String, Object> login() {
		
		//if(session.getAttribute("login") != null) return "/mypage";
		HashMap<String, Object> mRtnDat = new HashMap<>();
		
		// 임시
		mRtnDat.put("SESSION_USER_ID", "1");
		mRtnDat.put("SESSION_COMPANY_ID", "3");
		
		return mRtnDat;
	}

	
	@GetMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		
		
	}
}