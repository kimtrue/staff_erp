package kr.co.staff.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.staff.main.service.LoginService;
import kr.co.staff.repository.vo.Staff;

@Controller("kr.co.staff.login.LoginController")
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService service;
	
	
	
	@RequestMapping("/loginForm.do")
	public void loginForm() {}
	
	@RequestMapping("/check.do")
	@ResponseBody
	public Staff staffCheck(Staff staff) {
		Staff s = service.selectStaff(staff);
		return s;
	}
	
	
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

	
	
	
	/*@valid를 사용한 이메일 유효성 체크*/
	/*
	@RequestMapping(value = "/loginForm.do")
    public void loginForm(Model model){
        //<form:form>의 commandName에는 여기서 정의한 이름과 일치시킨다.
        //main페이지를 띄울때 member객체를 만들어서 리턴시키고 
        //뷰에서 폼형태에 담아서 다시 컨트롤러로 보내서 @Vaild를 통해 검증하는거같다.
        //<form:form>의 commandName의 설명을 봐도 먼소리인가 싶었었다..
        model.addAttribute("staff",new Staff());
    }
	
	 @RequestMapping(value = "/check.do", method = RequestMethod.POST)
	    //@ModelAttribute @Valid 을 이용하여 폼체크를 한다.
	    public String check(@ModelAttribute @Valid Staff staff,
	            BindingResult bindingResult) {
	        System.out.println(staff);
	        //에러발생시 반환.
	        if(bindingResult.hasErrors()){
	            System.out.println("폼 점검중입니다.");
	            return "/login/loginForm";
	        }else{
	            return "success";
	        }
	    }
	 */
	
	
}
		

