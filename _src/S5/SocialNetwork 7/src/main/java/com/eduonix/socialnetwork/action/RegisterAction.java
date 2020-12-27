package com.eduonix.socialnetwork.action;

import org.apache.commons.lang3.StringUtils;

import com.eduonix.socialnetwork.dao.UserDAO;
import com.eduonix.socialnetwork.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	
	private User user;
	
	@Override
	public void validate() {
		if(StringUtils.isEmpty(user.getUserName())) {
			addFieldError("user.userName","Username Cannot Be Empty");
			return;
		}
		
		if(user.getUserName().length() > 64) {
			addFieldError("user.userName", "Username too long");
			return;
		}
		
		UserDAO dao = new UserDAO();
		
		if(!dao.getUserByName(user.getUserName()).isEmpty()) {
			addFieldError("user.userName", "User Already Exists");
			return;
		}
		
		if(user.getPassword().length() > 64 ) {
			addFieldError("user.password","Password too long");
			return;
		}
		
		dao.close();
		
	}
	
	@Override
	public String execute() {
		UserDAO dao = new UserDAO();
		dao.insertUser(user);
		dao.close();
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
