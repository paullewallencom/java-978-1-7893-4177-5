package com.eduonix.taskmanager.page;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class LoginPage extends VerticalLayout implements View {
	
	public static final String NAME = "login";
	
	public LoginPage() {
		addComponent(new Label("Login Page"));
	}

}
