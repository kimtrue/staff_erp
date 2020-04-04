package kr.co.staff.main.service;

import java.util.List;
import java.util.Map;

import kr.co.staff.repository.vo.Staff;

public interface StaffService {
	//사원전체조회
	public List<Staff> staffList(Staff staff);
	//리뷰 페이징 처리를 위한
	public int getStaffCnt(Staff staff);
	
	//사원 수정폼 정보
	public Staff staffupdateForm(int staffNo);
	//수정하기
	public void updateStaff(Staff staff);
	
	
	//사원등록
	public void staffRegist(Staff staff);

	//사원검색
	public List<Staff> staffSearch(Staff staff);
	
	public List<Staff> deleteStaff(Staff staff);


}
