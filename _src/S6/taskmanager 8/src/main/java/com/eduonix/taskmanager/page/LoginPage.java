package com.eduonix.taskmanager.page;

import com.eduonix.taskmanager.ApplicationContextUtils;
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

public class LoginPage extends VerticalLayout implements View {

	public static final String NAME = "login";
	
	public UserService userService;
	
	TextField name;
	TextField password;

	public LoginPage() {
		userService = ApplicationContextUtils.getApplicationContext().getBean(UserService.class);
		addHeader();
		addForm();
	}

	public void addHeader() {
		Label title = new Label("Login");
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
		Button register = new Button("register");
		
		submit.addClickListener(e -> {
			User user = new User();
			
			user.setName(name.getValue());
			user.setPassword(password.getValue());
			
			User gottenUser = userService.getUser(user.getName());
			
			if(gottenUser == null || !gottenUser.getPassword().equals(user.getPassword())) {
				Notification.show("Invalid User Credentials",Notification.Type.ERROR_MESSAGE);
				
			} else {
				//TODO: Login
			}
			
			
		});
		
		register.addClickListener(e -> {
			Page.getCurrent().setUriFragment("!"+RegistrationPage.NAME);
		});
		
		text.addComponents(name,password);
		buttons.addComponents(submit,register);

		form.addComponents(text,buttons);

		addComponent(form);
	}

}
