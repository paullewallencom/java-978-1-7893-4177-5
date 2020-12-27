package com.eduonix.socialnetwork.action;

import com.eduonix.socialnetwork.model.User;
import com.opensymphony.xwork2.ActionSupport;

import com.eduonix.socialnetwork.dao.UserDAO;

public class LoginAction extends ActionSupport {
	
	private User user;
	@Override 
	public void validate() {
		
	}
	
	@Override
	public String execute() {
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		
		UserDAO dao = new UserDAO();
		
		dao.insertUser(user);
		
		return SUCCESS;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
