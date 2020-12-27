package com.eduonix.complaintsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "complaints")
public class Complaint {

	@Id
	@GenericGenerator(name="inc",strategy="increment")
	@GeneratedValue(generator="inc")
	@Column(name = "id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	@Column(name = "message")
	private String message;

	@Column(name = "sender_Name")
	private String senderName;

	@Column(name = "sender_email")
	private String senderEmail;

	public Complaint() {
		super();
	}

	public Complaint(String message, String senderName, String senderEmail) {
		super();
		this.message = message;
		this.senderName = senderName;
		this.senderEmail = senderEmail;
	}

}
