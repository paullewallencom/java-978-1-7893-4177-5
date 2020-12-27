package com.eduonix.taskmanager.service;

import com.eduonix.taskmanager.entity.User;

public interface UserService {
	
	public void save(User user);
	
	public User getUser(String name);
	
	public boolean register(User user);
	
	

}
