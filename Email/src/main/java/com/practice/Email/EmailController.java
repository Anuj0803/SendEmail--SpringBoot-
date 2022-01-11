package com.practice.Email;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class EmailController {

	@Autowired
	private JavaMailSender js;
	
	@RequestMapping("/index")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/email")
        public String sendSimpleEmail(Email e) {
		SimpleMailMessage message= new SimpleMailMessage();
		message.setTo(e.getEmail());
		message.setSubject(e.getSubject());
		message.setText(e.getBody());
		
		js.send(message);
		System.out.println("Mail sent");
		return "index.jsp";
	}
	@PostMapping("/email1")
	public String sendEmailWithAttachment(Email e1 ,@RequestParam("img") MultipartFile file) throws MessagingException {
        MimeMessage mimeMessage = js.createMimeMessage();

        MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(e1.getEmail());
        mimeMessageHelper.setText(e1.getBody());
        mimeMessageHelper.setSubject(e1.getSubject());
       if(!file.isEmpty()) {
    	   String filename = StringUtils.cleanPath(file.getOriginalFilename());
    	   
    	   InputStreamSource source = new InputStreamSource() {
			
			@Override
			public InputStream getInputStream() throws IOException {
				return file.getInputStream();
			}
		};
		mimeMessageHelper.addAttachment(filename, source);
       }
        js.send(mimeMessage);
        System.out.println("Mail with attachment sent successfully..");

       return "index.jsp";

  }
}
