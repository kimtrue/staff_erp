package kr.co.staff.repository.dao;

import java.util.List;

import kr.co.staff.repository.vo.Staff;

public interface StaffDAO {
	//전체사원 조회
	List<Staff> selectStaff();
	
	//사원등록
	void staffRegist(Staff staff);
	
	//사원 정보
	Staff selectStaffOne(int staffNo);
	
	//사원정보수정
	void updateStaff(Staff staff);
	
	//사원검색
	List<Staff> staffSearch(Staff staff);
	
	void deleteStaff(int staffNo);

}
