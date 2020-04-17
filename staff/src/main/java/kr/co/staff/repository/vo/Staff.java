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
	//사원 비번
	private String password;
	
	
	
	/*
	@NotNull
    @Size(min = 1, message = "이메일을 입력하십시오.")
    @Pattern(regexp = "^([^@\\s])+[@][^@\\s]+[.][^@\\s]+", message = "올바른 이메일 형식이 아닙니다.")
	private String staffEmail;
	
	
	 public String getStaffEmail() {
	        return staffEmail;
	    }
	 
	    public void setStaffEmail(String staffEmail) {
	        this.staffEmail = staffEmail;
	    }
	    
	    */


	
	
}
