package kr.co.staff.repository.vo;

import lombok.Data;

@Data
public class File {
	private int fileNo;
	private int fileGroupCode;
	private String orgName;
	private String sysName;
	private String path;
	private String extension;
	private String mailFrom;
	private int count;
	@Override
	public String toString() {
		return "FileVO [fileNo=" + fileNo + ", fileGroupCode=" + fileGroupCode + ", orgName=" + orgName + ", sysName="
				+ sysName + ", path=" + path + ", extension=" + extension + ", count=" + count
				+ "]";
	}
	
}
