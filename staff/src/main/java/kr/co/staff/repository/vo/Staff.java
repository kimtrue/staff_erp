package kr.co.staff.repository.vo;

import lombok.Data;

@Data
public class Staff {
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
}
