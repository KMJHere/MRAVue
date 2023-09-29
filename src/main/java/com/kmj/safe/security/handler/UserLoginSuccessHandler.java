package com.kmj.safe.security.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.kmj.safe.common.UserInfo;
import com.kmj.safe.security.service.MraUserDetails;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class UserLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserInfo userInfo;
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		logger.debug("onAuthenticationSuccess Start");
		MraUserDetails member = (MraUserDetails)authentication.getPrincipal();
		
		HttpSession session = request.getSession();

    	session.setAttribute("COMPANY_ID", String.valueOf(member.getCompanyId()));
    	session.setAttribute("USER_NO", String.valueOf(member.getUserno()));
    	session.setAttribute("USER_ID", member.getUsername());
    	session.setAttribute("USER_NM", member.getUserNm());
    	
    	userInfo.setSessionData(session);

    	if(userInfo.getIsLogin() == false) {
    		response.sendRedirect("/login");
    	} else {
    		response.sendRedirect("/");
    	}
    	
    }
}
