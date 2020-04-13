package kr.co.staff.login.dao;

import kr.co.staff.login.vo.Auth;
import kr.co.staff.login.vo.Member;

public interface MemberMapper {
	Member selectMember(String staffEmail);
	void insertMember(Member member);	
	void insertMemberAuth(Auth auth);	
}