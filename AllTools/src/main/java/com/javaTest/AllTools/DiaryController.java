package com.javaTest.AllTools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaTest.AllTools.entity.Mail;
import com.javaTest.AllTools.service.EmailService;

@RestController
@RequestMapping("/diary")
public class DiaryController {
	@Autowired
	EmailService service;
	
	@PostMapping("/sent")
	public String sentMail(@RequestBody Mail mail) {
		System.out.println(mail.getTo() +":"+mail.getSubject()+":"+mail.getBody());
		//return "ok";
		return service.sendEmail(mail.getTo(), mail.getSubject(),mail.getBody() );
		
	}

}
