package kr.co.staff.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public Map<String, Object> staffList(Staff staff) {
		staff.setListCnt(service.getStaffCnt(staff));
		Map<String, Object> map= new HashMap<>();
		staff.pageInfo(staff.getPage(), staff.getRange(), staff.getListCnt());
		System.out.println("페이지"+ staff);
		map.put("stafflist", service.staffList(staff));
		map.put("pagination", staff);
		
		return map;
	}
	
	//사원삭제
	@RequestMapping("/deletestaff.do")
	@ResponseBody
	public List<Staff> deletestaff(Staff staff) {
		staff.setListCnt(service.getStaffCnt(staff));
		return service.deleteStaff(staff);
	}
	
	//사원 검색조회
	@RequestMapping("/staffsearch.do")
	@ResponseBody
	public Map<String, Object> staffSearch(Staff staff){
		staff.setListCnt(service.getStaffCnt(staff));
		staff.pageInfo(staff.getPage(), staff.getRange(), staff.getListCnt());
		//검색 데이터
		if(staff.getStaffName() != null) {
			staff.setStaffName(staff.getStaffName());
		} 
		if(staff.getStaffEmail() != null) {
			staff.setStaffEmail(staff.getStaffEmail());
		}
		if(staff.getStaffPh() != null) {
			staff.setStaffPh(staff.getStaffPh());
		}
			staff.setStaffNo(staff.getStaffNo());
		

		
		Map<String, Object> map= new HashMap<>();
		map.put("stafflist", service.staffSearch(staff));
		map.put("pagination", staff);
		return map;
	}
	
	//엑셀다운로드
	@RequestMapping("/staffexceldown.do")
	public String excelDown(Map<String, Object> map, HttpServletRequest req, HttpServletResponse res, Staff staff) {
		 res.setCharacterEncoding("UTF-8");
         res.setContentType("application/vnd.ms-excel");
         res.setHeader("Pragma","public");
         res.setHeader("Expires","0");
         res.setHeader("Content-Disposition","attachment; filename = test.xls");

         List<Staff> excelList = service.staffSearch(staff);
         
//         System.out.println("엑셀스태프:" + excelList );

         map.put("excelList", excelList);
//         map.put("excelType",staff);

         return "excelView";
		
		
	}

}
