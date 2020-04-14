package kr.co.staff.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.staff.login.dao.MemberDAO;
import kr.co.staff.login.vo.Auth;
import kr.co.staff.repository.dao.StaffDAO;
import kr.co.staff.repository.vo.Staff;


@Service("kr.co.staff.front.main.service.StaffServiceImpl")
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDAO dao;
	@Autowired // spring-security.xml에서 관리되고 있는 클래스이다.
	private PasswordEncoder encoder;
	@Autowired
	private MemberDAO mapper;
	
	
	
	
	
	//전체검색
	@Override
	public List<Staff> staffList(Staff staff) {
		return dao.selectStaff(staff);
	}
	//등록
	@Override
	public void staffRegist(Staff staff) {
		staff.setPassword(encoder.encode(staff.getPassword()));
		System.out.println("서비스임플"+staff.getPassword());
		
		dao.staffRegist(staff);
		Auth auth = new Auth();
		auth.setStaffEmail((staff.getStaffEmail()));
		auth.setAuth("ROLE_U");
		
		System.out.println("서비스임플"+auth);
		mapper.insertMemberAuth(auth);
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
	public List<Staff> deleteStaff(Staff staff) {
		dao.deleteStaff(staff.getStaffNo());
		return dao.staffSearch(staff);
	}
	//검색된 staff수
	@Override
	public int getStaffCnt(Staff staff) {
		return dao.staffCnt(staff);
	}
	
	

}
