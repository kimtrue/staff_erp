/**
 * UserDetails : 사용자에 대한 정보를 가지고 있는 인터페이스
 * Member정보를 받아서 
 * 
 */
package kr.co.staff.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kr.co.staff.login.dao.MemberDAO;
import kr.co.staff.login.vo.Auth;
import kr.co.staff.login.vo.Member;
import kr.co.staff.login.vo.SecurityUser;

@Component("myBatisUserDetailsService")
public class MyBatisUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberDAO dao;
	@Override // 
	public UserDetails loadUserByUsername(String staffEmail) throws UsernameNotFoundException {
		Member vo = dao.selectMember(staffEmail); // 아이디를 가지고 유저정보 꺼낸다.
		System.out.println("MyBatisUserDetailsService"+vo);
		
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		//VO에는 SimpleGrantedAuthority타입이 없으므로 타입을 바꿔주는 과정
		for (Auth auth : vo.getAuthList()) {
			list.add(new SimpleGrantedAuthority(auth.getAuth()));
		}
		return vo == null ? null : new SecurityUser(vo, list);
	} 
}
