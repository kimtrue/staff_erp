package kr.co.staff.main.controller;

public class Test {
	public static void main(String[] args) {
//		String ss = "src="truestaff/img/upload/board/2020/04/07/15/b7c14202-e2a2-4199-8d01-4405f4b1f99e.png\" style=\"width: 142px;\"><br></p>";
//		String[] sass = ss.split(".");
//		
//		System.out.println(ss);
		
		String sd = "src=\"/truestaff/img/upload/board/2020/04/07/14/533695f2-cbbe-4c34-979b-19b3510ee5dd.png\">6666<br></p>";
		
		StringBuffer org = new StringBuffer(sd);
		StringBuffer oo = org.insert(sd.indexOf("src")+4, "\\");
		StringBuffer pat = oo.insert(sd.indexOf("src")+6, "cid:"); 
		System.out.println(pat);

		
		
	}

}
