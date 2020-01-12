package com.brw.service.impl;

/**
 * @author sidpatil
 * 2020
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.UserDAO;
import com.brw.dto.EmailDTO;
import com.brw.exceptions.EmailException;

@Component
public class EmailServiceImpl implements com.brw.service.EmailService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public EmailDTO sendEmail(EmailDTO emailDTO) throws EmailException, AddressException, MessagingException, IOException{
		System.out.println("**** 222 Inside EmailServiceImpl.sendEmail()");
		
		EmailDTO returnEmailDTO = new EmailDTO();
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtpout.secureserver.net");
		props.put("mail.smtp.port", "80");
		   
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("admin@bizrealworth.com", "Admin$123");
		      }
		   });
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("admin@bizrealworth.com", false));
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sp@proswift.com"));
		msg.setSubject("Tutorials point email");
		msg.setContent("Tutorials point email", "text/html");
		msg.setSentDate(new Date());
		
		/*
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Tutorials point email", "text/html");
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		MimeBodyPart attachPart = new MimeBodyPart();
		
		attachPart.attachFile("/var/tmp/image19.png");
		multipart.addBodyPart(attachPart);
		msg.setContent(multipart);
		*/
		  
		try {
			Transport.send(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return returnEmailDTO;
	}
}