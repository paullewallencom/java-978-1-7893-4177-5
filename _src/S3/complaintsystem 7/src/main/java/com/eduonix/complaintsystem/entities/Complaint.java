package com.eduonix.complaintsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="complaints")
public class Complaint {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="message")
	private String message;
	
	public Complaint(Integer id, String message, String senderName, String sernderEmail) {
		super();
		this.id = id;
		this.message = message;
		this.senderName = senderName;
		this.sernderEmail = sernderEmail;
	}

	@Column(name="sender_Name")
	private String senderName;
	
	public Complaint() {
		super();
	}

	@Column(name="sender_email")
	private String sernderEmail;

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

	public String getSernderEmail() {
		return sernderEmail;
	}

	public void setSernderEmail(String sernderEmail) {
		this.sernderEmail = sernderEmail;
	}
	

}
