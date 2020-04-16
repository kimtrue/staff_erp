package kr.co.staff.main.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.staff.repository.dao.StaffDAO;
import kr.co.staff.repository.vo.Staff;


@Service("kr.co.staff.login.main.service.LoginServiceImpl")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private StaffDAO dao;
	//사원등록

	@Override
	public Staff selectStaff(Staff staff) {
		return dao.selectLoginStaff(staff);
	}
	
	

}
