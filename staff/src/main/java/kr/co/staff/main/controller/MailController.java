package kr.co.staff.main.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import kr.co.staff.main.service.StaffService;
import kr.co.staff.repository.vo.Mail;

@Controller
@RequestMapping("/mail")
public class MailController {
	@Autowired
	private StaffService service;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/mailform.do")
	public void sendMail() {}
	
	
	
	//썸머노트 이미지 업로드
	@RequestMapping("/imagesave.do")
	@ResponseBody
	public void imageSave(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 날짜형식으로 폴더를 생성하기위해
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/HH");
		// 파일이 생성되는 경로명
		String path = "/img/upload/board" + sdf.format(new Date());
		// UUID로 생성된 파일명을 저장
		String fname="";
		// 파일이 저장될 실제 경로명
		String local = req.getSession().getServletContext().getRealPath("/");
		
	// 실제경로명 + 파일생성경로			
	File file = new File(local + path);
	// 경로명가 없으면 경로생성
	if (file.exists() == false)file.mkdirs();
	
	
	// 메모리와 임시저장에 대한 옵션을 설정
	DiskFileItemFactory disk = new DiskFileItemFactory();
	disk.setRepository(new File(local + "/img/temp"));
	disk.setSizeThreshold(1024 * 1024);
		
	// 사용자가 보내준 request의 정보를 파싱 처리하는 클래스(cos.jar에서 MultipartRequest의 역할) 
	ServletFileUpload upload = new ServletFileUpload(disk);
			
	List<String> list = new ArrayList<>();
	try {
		List<FileItem> lists = upload.parseRequest(req);
	
		for (FileItem item : lists) {
			// input 태그의 name 속성의 값을 반환
//			System.out.println(item.getFieldName());
			// type이 file 인지 아니면 일반 폼 타입인지 확인
			if (item.isFormField()) { // 타입이 파일 아닌 경우 true
				// input 속성에 입력한 값을 반환
//				System.out.println(item.getString());
				
			} else { // 타입이 파일인 경우
				// 원본파일명, 파일의 크기
				String name = item.getName();
				long size = item.getSize();
				String contentType = item.getContentType();
				
				// 실제 저정하는 파일의 이름(직접 - UUID 활용)
				String ext = "";
				int index = name.lastIndexOf(".");
				if (index != -1) ext = name.substring(index);
				File f = new File(file, UUID.randomUUID().toString() + ext);
				item.write(f);
				// UUID 경로명 저장
				fname = f.getName();
				String spath = printtest(item);
				list.add(spath);
			}
			
		}

		// 프로젝트경로명 + 파일생성경로 + UUID이름
		String uploadPath = req.getContextPath() + path+"/" + fname;
		String up = uploadPath +"^"+ list;
		System.out.println("업로드"+up);
		// 이미지타입으로 전달
		res.setContentType("image/pjpeg");
		PrintWriter pw = res.getWriter();
		pw.write(up);
		pw.flush();
		pw.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	@RequestMapping("/sendmail.do")
	@ResponseBody
	public String mailSending(HttpServletRequest req, Mail mail) {
		String setfrom = "kjs3597@gmail.com";
		String tomail = mail.getMailTo();
		String title = mail.getMailSubject();// 제목
		String content = mail.getEditordata();// 내용
		String fileName = mail.getFileName();
		
		
      
		try {
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			
			int numb = content.indexOf("src=");
			String sname = content.substring(numb+4);
			int la = sname.indexOf("style");
			String save = sname.substring(0, la);
			
			System.out.println(":::content:::"+content);
			System.out.println(":::save:::"+save);
			
			String rename = "\"cid:"+fileName+"\" ";
			
			String saveContent = content.replace(save, rename);
			
//			System.out.println("::::"+saveContent);

//			StringBuffer org = new StringBuffer(content);
//			StringBuffer oo = org.insert(content.indexOf("src")+3, "\\");
//			StringBuffer pat = oo.insert(content.indexOf("src")+6, "cid:"); 
//		    StringBuffer simage = pat.
//			String contents = pat.toString(); 
			
			
			messageHelper.setText(saveContent, true); // 메일 내용
			FileSystemResource file = new FileSystemResource(new File(mail.getSavePath()));
			messageHelper.addInline(fileName, file);
			

			mailSender.send(message);
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:main.do";
	}
	
	
	
	public String printtest(FileItem file) {
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/HH");
		String ipath = "c:/sumnote" + sdf.format(new Date());
		String fname="";
		
		File f = new File(ipath);
		if (!f.exists()) {
    		f.mkdirs();
    	}
		if (file.isFormField()) { // 타입이 파일 아닌 경우 true
			// input 속성에 입력한 값을 반환
//			System.out.println(item.getString());
			
		} else { // 타입이 파일인 경우
			// 원본파일명, 파일의 크기
			String name = file.getName();
			long size = file.getSize();
			String contentType = file.getContentType();
			
			// 실제 저정하는 파일의 이름(직접 - UUID 활용)
			String ext = "";
			int index = name.lastIndexOf(".");
			if (index != -1) ext = name.substring(index);
			File imgf = new File(f, UUID.randomUUID().toString() + ext);
			try {
				file.write(imgf);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// UUID 경로명 저장
			fname = imgf.getName();
			System.out.println("fname"+ fname);

		}
		// 프로젝트경로명 + 파일생성경로 + UUID이름
		String uploadPath = ipath+"/" + fname;
		System.out.println("경로는?" + uploadPath);
		
		return uploadPath;
		
		
	}

		

	

}
