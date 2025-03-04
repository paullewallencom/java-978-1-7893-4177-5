package com.eduonix.socialnetwork.action;

import com.eduonix.socialnetwork.model.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.eduonix.socialnetwork.dao.UserDAO;

public class LoginAction extends ActionSupport {

	private User user;

	@Override
	public void validate() {

		if (StringUtils.isEmpty((user.getUserName()))) {
			addFieldError("user.userName", "Username Cannot Be Blank");
			return;
		}

		UserDAO dao = new UserDAO();
		List<User> users = dao.getUserByName(user.getUserName());

		if (users.isEmpty()) {
			addFieldError("user.userName", "No User Found");
			return;
		}

		if (!users.get(0).getPassword().equals(user.getPassword())) {
			addFieldError("user.password", "Incorrect Password");
			return;
		}
		
		this.user = users.get(0);
		

	}

	@Override
	public String execute() {
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());

		return SUCCESS;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
