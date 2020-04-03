package kr.co.staff.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.staff.repository.dao.StaffDAO;
import kr.co.staff.repository.vo.Staff;


@Service("kr.co.staff.front.main.service.StaffServiceImpl")
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDAO dao;
	//사원등록
	
	//전체검색
	@Override
	public List<Staff> staffList() {
		return dao.selectStaff();
	}
	//등록
	@Override
	public void staffRegist(Staff staff) {
		dao.staffRegist(staff);
	}

	//수정폼
	@Override
	public Staff staffupdateForm(int staffNo) {
		return dao.selectStaffOne(staffNo);
	}
	//수정
	@Override
	public void updateStaff(Staff staff) {
		dao.updateStaff(staff);
	}
	//검색
	@Override
	public List<Staff> staffSearch(Staff staff) {
		return dao.staffSearch(staff);
	}
	//삭제
	@Override
	public List<Staff> deleteStaff(int staffNo) {
		dao.deleteStaff(staffNo);
		return dao.selectStaff();
	}
	
	

}
