package kr.co.staff.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailSender")
public class MailServiceImpl implements MailService {
	@Autowired
	JavaMailSender mail;
	
	public void sendEmail(String content) {
		// TODO Auto-generated method stub
		
	}

}
