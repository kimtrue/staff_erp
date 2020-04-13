package kr.co.staff.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.staff.login.dao.MemberMapper;
import kr.co.staff.login.vo.Auth;
import kr.co.staff.login.vo.Member;

@Service
public class MemberServiceImpl {

	@Autowired
	private MemberMapper mapper;

	@Autowired // spring-security.xml에서 관리되고 있는 클래스이다.
	private PasswordEncoder encoder;
	
	public void join(Member member) {
		//암호화된 비밀번호 들어간다.
		member.setPassword(encoder.encode(member.getPassword()));
		mapper.insertMember(member);
		Auth auth = new Auth();
		auth.setId(member.getStaffEmail());
		auth.setAuth("ROLE_U");
		mapper.insertMemberAuth(auth);
	} 
}
