package com.kmj.safe.security.service; 

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kmj.safe.model.Member;
import com.kmj.safe.service.MemberService;

@Service
public class MraUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberService memberService;
   
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Member member = memberService.getMember(username);
    	
    	if(member == null) {
    		throw new UsernameNotFoundException(username);
    	}
    	
    	List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
      
    	return MraUserDetails.builder()
    			.username(member.getUSER_ID())
    			.password(member.getPASS_ID())
    			.userno(member.getUSER_NO())
    			.companyid(member.getCOMPANY_ID())
    			.usernm(member.getUSER_NM())
    			.authorities(roles)
    			.build();
    }
}
