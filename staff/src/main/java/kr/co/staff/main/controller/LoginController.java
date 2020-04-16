package kr.co.staff.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.staff.main.service.LoginService;
import kr.co.staff.repository.vo.Staff;

@Controller("kr.co.staff.login.LoginController")
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService service;
	
	
	@RequestMapping("/loginForm.do")
	public void loginForm() {}
	
	@RequestMapping("/doLogin.do")
	public String staffLogin(Staff staff, HttpSession session) {
		System.out.println("넘어왔다"+ staff);
		
		Staff s = service.selectStaff(staff);
		System.out.println("오잉"+ s);
		if(s == null) {
			return "redirect:/login/loginForm.do";
		}
		session.setAttribute("loginStaff", s);
		
		return "redirect:/front/main.do";
	}
}
		

