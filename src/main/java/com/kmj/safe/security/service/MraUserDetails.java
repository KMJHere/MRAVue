package com.kmj.safe.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;

@SuppressWarnings("serial")
public class MraUserDetails implements UserDetails {
	private Integer COMPANY_ID;
	private Integer USER_NO;
	private String USER_NM;
	private String USER_ID;
	private String PASS_ID;
    
    @Builder
    public MraUserDetails(Integer companyid, Integer userno, String usernm, String username, String password, List<GrantedAuthority> authorities) {
    	this.COMPANY_ID = companyid;
    	this.USER_NO = userno;
    	this.USER_NM = usernm;
    	this.USER_ID = username;  
    	this.PASS_ID = password; 
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	List<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority("ROLE_USER"));
        return auth;
    }

    @Override
    public String getPassword() {
        return PASS_ID;
    }

    @Override
    public String getUsername() {
        return USER_ID;
    }
    
    public Integer getUserno() {
    	return USER_NO;
    }
    
    public Integer getCompanyId() {
    	return COMPANY_ID;
    }
    
    public String getUserNm() {
    	return USER_NM;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
