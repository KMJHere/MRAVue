package com.kmj.safe.security.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kmj.safe.security.service.MraUserDetails;

public class CustomAuthenticationManager implements AuthenticationManager {
	@Autowired
    private UserDetailsService userDetailsService;
	
	private final BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
	
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	String userId = authentication.getName(); // USER_ID
    	String userPassword = authentication.getCredentials().toString(); // PW_ID
    	
        MraUserDetails userDetails = (MraUserDetails)userDetailsService.loadUserByUsername(userId);
        
        if(!bCrypt.matches(userPassword, userDetails.getPassword())) throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername()
                , userDetails.getPassword()
                , userDetails.getAuthorities());
    }
}
