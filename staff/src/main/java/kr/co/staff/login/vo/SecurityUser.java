/**
 * spring에서 제공하는 User클래스
 * Collection<? extends GrantedAuthority> list : loginSuccessHandler에서 사용하던것
 * 	- MemberVO에 있는 Auth정보를 받아 처리한다.
 * 	User클래스(super)에 전달한다. : 사용자 id, password, auth를 주면 db와 비교해 처리해준다.
 */
package kr.co.staff.login.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class SecurityUser extends User {
	private static final long serialVersionUID = 1L;
	private Member member; // db의 사용자 정보를 담을 수 있는 변수
	public SecurityUser(Member vo, Collection<? extends GrantedAuthority> list) {
		super(vo.getStaffEmail(), vo.getPassword(), list); // User에 원하는 형태로 값을 넘겨준다.(db와 아이디 비밀번호 유효성 확인하기 위해)
		this.member = vo; // DB의 사용자 정보 추가로 관리하기 위해 넣어준다.
	}
}
