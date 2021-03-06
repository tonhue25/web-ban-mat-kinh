package com.webbanmatkinh.dto;

public class MailDTO {
	// người gửi, người nhận, nội dung, chủ đề.
	private String fullName;
	private String subject;
	private String content;
	private String email;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public MailDTO(String email) {
		super();
		this.email = email;
	}

	public String getMail() {
		return email;
	}

	public void setMail(String email) {
		this.email = email;
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

	public MailDTO(String fullName, String email) {
		super();
		this.fullName = fullName;
		this.email = email;
	}

	public MailDTO() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
