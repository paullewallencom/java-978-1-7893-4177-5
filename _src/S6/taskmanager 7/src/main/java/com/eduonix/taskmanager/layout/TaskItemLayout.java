package com.eduonix.taskmanager.layout;

import com.eduonix.taskmanager.entity.User;
import com.eduonix.taskmanager.service.UserService;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class TaskItemLayout extends HorizontalLayout {
	
	public TaskItemLayout(String task,UserService service, User user) {
		addComponent(new Label(task));
		Button remove = new Button("del");
		
		remove.addClickListener(e -> {
			removeAllComponents();
			for(int i = 0; i < user.getTasks().size();i++) {
				if(user.getTasks().get(i).equals(task)) {
					user.getTasks().remove(i);
					break;
				}
			}
			
			service.save(user);
		});
		
		addComponent(remove);
	}

}
