package com.eduonix.taskmanager.page;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class RegistrationPage extends VerticalLayout implements View {
	
	public static final String NAME = "register";
	
	public RegistrationPage() {
		addHeader();
	}
	
	public void addHeader() {
		Label title = new Label("Register");
		
		title.addStyleName("h1");
		
		addComponent(title);
		
	}

}
