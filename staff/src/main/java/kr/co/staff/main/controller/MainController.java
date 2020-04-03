package kr.co.staff.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.staff.main.service.StaffService;
import kr.co.staff.repository.vo.Staff;

@Controller
@RequestMapping("/front")
public class MainController {
	@Autowired
	private StaffService service;
	
	@RequestMapping("/main.do")
	public void main() {}
	
	//사원등록폼
	@RequestMapping("/staffregistform.do")
	public void staffRegist() {}
	
	//사원등록
	@RequestMapping("/staffregist.do")
	public String staffRegistDo(Staff staff) {
		service.staffRegist(staff);
		return "redirect:main.do";
	}
	
	//사원 정보수정폼
	@RequestMapping("/staffupdateForm.do")
	public void staffupdateForm(int staffNo, Model model) {
		model.addAttribute("staff", service.staffupdateForm(staffNo));
	}
	
	@RequestMapping("/staffupdate.do")
	public String staffUpdate(Staff staff) {
		service.updateStaff(staff);
		return "redirect:main.do";
	}
	
	
	//사원 전체조회
	@RequestMapping("/stafflist.do")
	@ResponseBody
	public List<Staff> staffList() {
		return service.staffList();
	}
	
	//사원삭제
	@RequestMapping("/deletestaff.do")
	@ResponseBody
	public List<Staff> deletestaff(int staffNo) {
		return service.deleteStaff(staffNo);
	}
	
	//사원 검색조회
	@RequestMapping("/staffsearch.do")
	@ResponseBody
	public List<Staff> staffSearch(Staff staff){
		return service.staffSearch(staff);
	}

}
