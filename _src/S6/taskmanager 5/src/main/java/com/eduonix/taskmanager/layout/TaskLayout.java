package com.eduonix.taskmanager.layout;

import org.springframework.beans.factory.annotation.Autowired;

import com.eduonix.taskmanager.service.UserService;
import com.vaadin.ui.VerticalLayout;

public class TaskLayout extends VerticalLayout {
	
	@Autowired
	UserService service;
	
	public void setTasks() {
		
	}
	

}
