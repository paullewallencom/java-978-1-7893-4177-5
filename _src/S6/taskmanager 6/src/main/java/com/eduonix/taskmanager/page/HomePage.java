package com.eduonix.taskmanager.page;

import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class HomePage extends VerticalLayout implements View {
	
	public static final String NAME = "home";
	TextField task;
	
	public HomePage() {
		addHeader();
		addTaskForm();
		addTaskList();
		addLogout();
		
	}
	
	private void addHeader() {
		Label title = new Label("Home");
		title.setStyleName("h1");
		
		addComponent(title);
	}
	
	private void addTaskForm() {
		HorizontalLayout form = new HorizontalLayout();
		 task = new TextField();
		
		Button add = new Button("add");
		
		form.addComponents(task,add);
		
		add.addClickListener(e -> {
			//TODO: add a task
		});
		
		addComponent(form);
	}
	
	private void addTaskList() {
		
	}
	
	private void addLogout() {
		
		Button logout = new Button("logout");
		
		logout.addClickListener(e -> {
			VaadinSession.getCurrent().setAttribute("user", null);
			getUI().getNavigator().removeView(HomePage.NAME);
			Page.getCurrent().setUriFragment("!"+LoginPage.NAME);
			
		});
		
		addComponent(logout);
		
	}

}
