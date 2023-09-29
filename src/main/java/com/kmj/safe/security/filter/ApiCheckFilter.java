package com.kmj.safe.security.filter;

import com.kmj.safe.security.util.JWTUtil;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Log4j2
public class ApiCheckFilter extends OncePerRequestFilter {
    private AntPathMatcher antPathMatcher;
    private String pattern;

    private JWTUtil jwtUtil;

    // 생성자를 통해 주입
    public ApiCheckFilter(String pattern, JWTUtil jwtUtil) {
        this.antPathMatcher = new AntPathMatcher();
        this.pattern = pattern;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(antPathMatcher.match(pattern, request.getRequestURI())) {
            boolean checkHeader = checkAuthHeader(request);

            // Authorization 헤더가 없거나 다른 값을 전송하는 경우.. 403 Error
            if(checkHeader) {
                filterChain.doFilter(request, response);
                return;
            } else {
                // SC_FORBIDDEN > 403
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                // json 리턴 & 인코딩 설정
                response.setContentType("application/json;charset=utf-8");
                JSONObject json = new JSONObject();
                String message = "Fail Check API Token";
                json.put("code", "403");
                json.put("message", message);

                PrintWriter out = response.getWriter();
                out.println(json);
                return;
            }
            //return;
        }

        // 다음 필터의 단계로 넘어가는 역할을 위해서 필요
        filterChain.doFilter(request, response);
    }

    // 요청에 포함된 Authorization 헤더 값을 확인 후 boolean 타입 결과 반환
    private boolean checkAuthHeader(HttpServletRequest request) {
        boolean checkResult = false;

        String authHeader = request.getHeader("Authorization");

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer")) {
            try {
                String email = jwtUtil.validateAndExtract(authHeader.substring(7));

                checkResult = email.length() > 0;


            } catch(Exception e) {
                e.printStackTrace();
            }
            
            /* jwt 토큰 검증으로 변경
            if(authHeader.equals("12345678")) {
                checkResult = true;
            }
            */
        }

        return checkResult;
    }
}
