package kr.co.staff.repository.vo;

import lombok.Data;

@Data
public class Staff extends Pagination {
	public Staff() {
		super();
	}
	
	public Staff(int pageNo, int listSize) {
		super(pageNo, listSize);
	}
	
	//사원번호
	private int staffNo;
	//사원이름
	private String staffName;
	//사원직급
	private String staffRank;
	//사원이메일
	private String staffEmail;	
	//사원전화번호
	private String staffPh;
	
	private String password;
}
