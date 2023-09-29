package com.kmj.safe.security.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserLoginFailureHandler implements AuthenticationFailureHandler {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		// MsgUtility 작성 후 comment 변경 필요
		if(exception instanceof AuthenticationServiceException) {
			request.setAttribute("LoginFailMessage", "죄송합니다. 시스템에 오류가 발생했습니다.test");
		} else if(exception instanceof BadCredentialsException) {
			request.setAttribute("LoginFailMessage", "아이디 또는 비밀번호가 일치하지 않습니다.");
		} else if(exception instanceof DisabledException) {
			request.setAttribute("LoginFailMessage", "현재 사용할 수 없는 계정입니다.");
		} else if(exception instanceof LockedException) {
			request.setAttribute("LoginFailMessage", "현재 잠긴 계정입니다.");
		} else if(exception instanceof AccountExpiredException) {
			request.setAttribute("LoginFailMessage", "이미 만료된 계정입니다.");
		} else if(exception instanceof CredentialsExpiredException) {
			request.setAttribute("LoginFailMessage", "비밀번호가 만료된 계정입니다.");
		} else request.setAttribute("LoginFailMessage", "계정을 찾을 수 없습니다.");
		
		logger.info("errorMsg: " + request.getAttribute("LoginFailMessage"));
		
		request.getRequestDispatcher("/login").forward(request, response);
    }
}
