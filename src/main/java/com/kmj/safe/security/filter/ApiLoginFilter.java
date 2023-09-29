package com.kmj.safe.security.filter;

import com.kmj.safe.security.util.JWTUtil;
import lombok.extern.log4j.Log4j2;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class ApiLoginFilter extends AbstractAuthenticationProcessingFilter {
    private JWTUtil jwtUtil;

    // 문자열로 패턴을 받는 생성자 반드시 필요
    public ApiLoginFilter(String defaultFilterProcessesUrl, JWTUtil jwtUtil) {
        super(defaultFilterProcessesUrl);
        this.jwtUtil = jwtUtil;
    }

    // attemptAuthentication() 반드시 필요
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String email = request.getParameter("email");
        String pw = request.getParameter("pw");

        // Authentication 타입의 객체를 만들어서 파라미터로 전달 대신 UsernamePasswordAuthenticationToken 이용 인증 처리 구현
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, pw);

        // authenticate 메서드는 파라미터, 리턴 타입 모두 Authentication 타입!
        return getAuthenticationManager().authenticate(authToken);
        /*
        if(email == null) {
            throw new BadCredentialsException("email cannot be null");
        }

        return null;
         */
    }

    // 인증 성공 처리 > 별도 클래스 대신 AbstractAuthenticationProcessingFilter 클래스 -> successfulAuthentication() 메서드 override
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        

        String token = null;

        try {
        //    token = jwtUtil.generateToken(email);

            response.setContentType("text/plain");
            response.getOutputStream().write(token.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
