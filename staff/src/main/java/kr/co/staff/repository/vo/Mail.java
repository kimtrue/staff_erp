package kr.co.staff.repository.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Mail {
	private String mailFrom;
	 
    private String mailTo;
 
    private String mailCc;
 
    private String mailBcc;
 
    private String mailSubject;
 
    private String mailContent;
 
    private String contentType;
    
    private Date mailSendDate;
    
    private String editordata;
 
    public Mail() {
        contentType = "text/plain";
    }

}
