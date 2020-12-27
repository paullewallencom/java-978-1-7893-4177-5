package com.eduonix.taskmanager.page;

import org.springframework.beans.factory.annotation.Autowired;

import com.eduonix.taskmanager.entity.User;
import com.eduonix.taskmanager.service.UserService;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class RegistrationPage extends VerticalLayout implements View {
	
	public static final String NAME = "register";
	
	@Autowired
	UserService userService;
	
	TextField name;
	TextField password;
	
	public RegistrationPage() {
		addHeader();
		addForm();
	}
	
	public void addHeader() {
		Label title = new Label("Register");
		title.addStyleName("h1");
		
		addComponent(title);
		
	}
	
	public void addForm() {
		VerticalLayout form = new VerticalLayout();
		
		VerticalLayout text = new VerticalLayout();
		HorizontalLayout buttons = new HorizontalLayout();

		name = new TextField();
		password = new TextField();

		Button submit = new Button("submit");
		Button login = new Button("login");
		
		submit.addClickListener(e -> {
			User user = new User();
			
			user.setName(name.getValue());
			user.setPassword(password.getValue());
			
			if(userService.register(user)) {
				Page.getCurrent().setUriFragment("!"+LoginPage.NAME);
			} else {
				Notification.show("Bad User Info",Notification.Type.ERROR_MESSAGE);
			}
		});
		
		login.addClickListener(e -> {
			Page.getCurrent().setUriFragment("!"+LoginPage.NAME);
		});
		
		text.addComponents(name,password);
		buttons.addComponents(submit,login);

		form.addComponents(text,buttons);
		
		addComponent(form);
	}

}
