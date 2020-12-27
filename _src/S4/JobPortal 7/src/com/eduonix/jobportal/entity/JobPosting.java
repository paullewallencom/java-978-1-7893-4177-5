package com.eduonix.jobportal.entity;

public class JobPosting {
	private int id;
	
	private String messageBody;
	
	private String jobName;
	
	private String posterName;
	
	private String contactPhone;
	
	private String jobPostingPassword;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the messageBody
	 */
	public String getMessageBody() {
		return messageBody;
	}

	/**
	 * @param messageBody the messageBody to set
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the posterName
	 */
	public String getPosterName() {
		return posterName;
	}

	/**
	 * @param posterName the posterName to set
	 */
	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	/**
	 * @return the contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * @param contactPhone the contactPhone to set
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * @return the jobPostingPassword
	 */
	public String getJobPostingPassword() {
		return jobPostingPassword;
	}

	/**
	 * @param jobPostingPassword the jobPostingPassword to set
	 */
	public void setJobPostingPassword(String jobPostingPassword) {
		this.jobPostingPassword = jobPostingPassword;
	}
	
	
}
