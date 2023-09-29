package com.kmj.safe.repository;

import org.apache.ibatis.annotations.Mapper;

import com.kmj.safe.model.Member;

import java.util.List;

@Mapper
public interface MemberMP {
	Member getMember(String USER_ID);
	
	List<Member> getMemberList();
	
	int createMember(Member member);
	
	int updateMember(Member member);
	
	int deleteMember(int id);
}
