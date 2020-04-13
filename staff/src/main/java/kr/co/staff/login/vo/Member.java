package kr.co.staff.login.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String staffEmail;
	private String password;
	private String staffName;
	private Date regDate;
	private List<Auth> authList;
	private int staffNo;
	private String staffRank;
	private String staffPh;
}
