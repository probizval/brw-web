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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.common.constants.Constants;
import com.brw.dao.UserDAO;
import com.brw.dto.EmailDTO;
import com.brw.dto.UserBusinessDTO;
import com.brw.entities.UserBusiness;
import com.brw.exceptions.EmailException;

@Component
public class EmailServiceImpl implements com.brw.service.EmailService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public EmailDTO sendEmail(EmailDTO emailDTO) throws EmailException, AddressException, MessagingException, IOException {
		long start = System.currentTimeMillis();
		
		logger.info("**** 222 Inside EmailServiceImpl.sendEmail()" + emailDTO.getToList().toString());

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
		
		String emailToList = Constants.EMPTY_STRING;
		int i = 0;
		for (String email: emailDTO.getToList()) {
			logger.info("**** 222 Inside EmailServiceImpl.sendEmail() i: "+i);
			logger.info("**** 222 Inside EmailServiceImpl.sendEmail() email: "+email);

			if(i != 0) {
				emailToList = emailToList.concat(Constants.COMMA);
			}
			emailToList = emailToList.concat(email);
			logger.info("**** 222 Inside EmailServiceImpl.sendEmail() emailToList: "+emailToList);

			i++;
		}
		logger.info("**** 222 Inside EmailServiceImpl.sendEmail() emailToList: "+emailToList);

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailToList));
		msg.setSubject(emailDTO.getSubject());
		msg.setContent("Email from "+emailDTO.getFrom()+": "+emailDTO.getContent(), "text/html");
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
			sendAcknowledgementEmail(emailDTO.getFrom());
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		logger.info("Elapsed time in sendEmail(): " + (System.currentTimeMillis() - start));
		return returnEmailDTO;
	}
	
	
	private void sendAcknowledgementEmail(String email) throws EmailException, AddressException, MessagingException, IOException{
		logger.info("**** 222 Inside EmailServiceImpl.sendAcknowledgementEmail()");
		
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
		
		String emailToList = Constants.EMPTY_STRING;
		emailToList = emailToList.concat(email);

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailToList));
		msg.setSubject("Your email is received at www.BizRealWorth.com");
		msg.setContent("<P><B>Thank You for contacting us!</B></P><P>We at www.BizRealWorth.com will respond to your inquiry as soon as we can.</P><P>Meanwhile, for faster response you can also contact us by calling 1-855-522-5579.</P>", "text/html");
		msg.setSentDate(new Date());
		  
		try {
			Transport.send(msg);
			logger.info("**** 222 Inside EmailServiceImpl.sendAcknowledgementEmail() TO: "+email);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}