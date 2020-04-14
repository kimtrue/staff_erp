/**
 * GrantedAuthority : 권한 하나별로 하나씩 생겨서 관리된다.
 * getAuthority() : 권한명을 반환한다.
 * => 반환되는 권한이름별로 로그인 후 이동 페이지 설정해준다.
 */
package kr.co.staff.login.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component("loginSuccessHandler")
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
					throws IOException, ServletException {
		Collection<? extends GrantedAuthority> list = authentication.getAuthorities();
		System.out.println("로그인핸들러"+ list);
		for (GrantedAuthority auth : list) {
			System.out.println(auth.getAuthority());
		}
		
		response.sendRedirect(request.getContextPath() + "/front/main.do");
	}

}
