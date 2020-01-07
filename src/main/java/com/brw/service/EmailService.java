package com.brw.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.brw.dto.EmailDTO;
import com.brw.exceptions.EmailException;

public interface EmailService {
	public EmailDTO sendEmail(EmailDTO emailDTO) throws EmailException, AddressException, MessagingException, IOException;
}
