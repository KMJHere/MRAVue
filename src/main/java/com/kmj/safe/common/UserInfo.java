package com.kmj.safe.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UserInfo {
	private boolean isLogin;
	
	private String companyId;
	
	private String userNo;
	
	private String userId;
	
	private String userNm;
	
	public boolean getIsLogin() {
		return isLogin;
	}

	private void setIsLogin(boolean abIsLogin) {
		this.isLogin = abIsLogin;
	}
	
	public String getUserNo() {
		return userNo;
	}
	
	private void setUserNo(String asUserNo) {
		this.userNo = asUserNo;
	}

	public String getUserId() {
		return userId;
	}

	private void setUserId(String asUserId) {
		this.userId = asUserId;
	}

	public String getUserNm() {
		return userNm;
	}

	private void setUserNm(String asUserNm) {
		this.userNm = asUserNm;
	}
	
	public String getCompanyId() {
		return companyId;
	}

	private void setCompanyId(String asCompanyId) {
		this.companyId = asCompanyId;
	}
	
	public Map<String, Object> getFixData() {
		Map<String, Object> mData = new HashMap<>();
		
		mData.put("IS_LOGIN", this.getIsLogin());
		mData.put("COMPANY_ID", this.getCompanyId());
		mData.put("USER_NO", this.getUserNo());
		mData.put("USER_ID", this.getUserId());
		mData.put("USER_NM", this.getUserNm());
		
		return mData;
	}
	

	public void setSessionData(HttpSession session) {		
		this.setIsLogin(StringUtils.hasText((String)session.getAttribute("USER_NO")));
		this.setCompanyId((String)session.getAttribute("COMPANY_ID"));
		this.setUserNo((String)session.getAttribute("USER_NO"));
		this.setUserId((String)session.getAttribute("USER_ID"));
		this.setUserNm((String)session.getAttribute("USER_NM"));
	}
	
	public void init() {
		this.setIsLogin(false); 
		this.setCompanyId(null);
		this.setUserNo(null);
		this.setUserId(null);
		this.setUserNm(null);
	}
	
	public Map<String, Object> toMapping(Map<String, Object> amData) {
		amData.put("COMPANY_ID", this.getCompanyId());
		amData.put("USER_NO", this.getUserNo());
		amData.put("USER_ID", this.getUserId());
		amData.put("USER_NM", this.getUserNm());
		
		return amData;
	}
	
}
