package com.eduonix.taskmanager.layout;

import org.springframework.beans.factory.annotation.Autowired;

import com.eduonix.taskmanager.entity.User;
import com.eduonix.taskmanager.service.UserService;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;

@SpringComponent
public class TaskLayout extends VerticalLayout {
	
	@Autowired
	UserService service;
	
	public void setTasks(User user) {
		removeAllComponents();
		user.getTasks().forEach(task -> addComponent(new TaskItemLayout(task,service,user)));
		
	}
	

}
