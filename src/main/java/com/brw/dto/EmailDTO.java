package com.brw.dto;

import java.util.List;

/**
 * @author sidpatil
 * 2020
 */

public class EmailDTO {

	private Integer invokerId;
	private String from;
	private List<String> toList;
	private String subject;
	private String content;
	private String emailPurpose;
	
	public Integer getInvokerId() {
		return invokerId;
	}
	public void setInvokerId(Integer invokerId) {
		this.invokerId = invokerId;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public List<String> getToList() {
		return toList;
	}
	public void setToList(List<String> toList) {
		this.toList = toList;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmailPurpose() {
		return emailPurpose;
	}
	public void setEmailPurpose(String emailPurpose) {
		this.emailPurpose = emailPurpose;
	}
}