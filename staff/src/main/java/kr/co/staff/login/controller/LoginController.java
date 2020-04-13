package kr.co.staff.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.staff.login.service.MemberServiceImpl;
import kr.co.staff.login.vo.Member;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private MemberServiceImpl service;
	
	/*
	@RequestMapping("/join-form.do")
	public String joinForm() {
		return "security/joinForm";
	}
	
	@RequestMapping("/join.do")
	public String join(Member member) {
		service.join(member);
		return "redirect:/security/main.do";
	}
	
	 */
	@RequestMapping("/main.do")
	public String main() {
		return "redirect:/front/main.do";
	}
	
	@RequestMapping("/loginForm.do")
	public void loginForm() {}
	
	@RequestMapping("/all.do")
	public void all() {
		System.out.println("all");
	}

	@RequestMapping("/user.do")
	public void user() {
		System.out.println("user");
	}

	@RequestMapping("/admin.do")
	public void admin() {
		System.out.println("admin");
	}

}
