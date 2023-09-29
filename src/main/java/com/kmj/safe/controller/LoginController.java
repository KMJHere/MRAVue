package com.kmj.safe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kmj.safe.common.UserInfo;

@Controller
public class LoginController {
	@Autowired
	private HttpSession session;
	@Autowired
	private UserInfo userInfo;

	
	@GetMapping("/login")
	public Map<String, Object> login() {
		
		//if(session.getAttribute("login") != null) return "/mypage";
		HashMap<String, Object> mRtnDat = new HashMap<>();
		
		mRtnDat.put("SESSION_USER_ID", userInfo.getUserId());
		
			
		return mRtnDat;
	}
	
	@GetMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		
		
	}
	
	/*
	@PostMapping("/loginProc") 
	public String loginProc(HttpServletRequest request, HttpServletResponse response) {
		request.getParameter(null)
	}
	*/
}