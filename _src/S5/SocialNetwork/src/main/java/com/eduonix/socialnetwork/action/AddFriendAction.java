package com.eduonix.socialnetwork.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.eduonix.socialnetwork.dao.UserDAO;
import com.eduonix.socialnetwork.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class AddFriendAction extends ActionSupport implements SessionAware {

	private String name;
	private Map<String, Object> userSession;

	public void validate() {
		if (StringUtils.isEmpty(name)) {
			addFieldError("name", "Name Cannot Be Empty");
			return;
		}
		UserDAO dao = new UserDAO();
		List<User> users = dao.getUserByName(name);
		User currentUser = (User) userSession.get("user");
		System.out.println(users.size());
		if (users.isEmpty()) {
			addFieldError("name", "User Does Not Exist");
			return;
		}

		if (currentUser.getUserName().equals(users.get(0).getUserName())) {
			addFieldError("name", "You Cannot Add Yourself");
			return;
		}

		for (User u : currentUser.getFriends()) {
			if (u.getUserName().equals(users.get(0).getUserName())) {
				addFieldError("name", "Already your friend");
				return;
			}
		}

		dao.close();
	}

	public String execute() {
		UserDAO dao = new UserDAO();

		List<User> users = dao.getUserByName(name);

		User currentUser = (User) userSession.get("user");
		Set<User> friends = currentUser.getFriends();
		friends.add(users.get(0));
		currentUser.setFriends(friends);

		dao.update(currentUser);
		dao.close();
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;

	}

}
