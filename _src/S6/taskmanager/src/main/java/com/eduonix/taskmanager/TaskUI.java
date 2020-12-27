package com.eduonix.taskmanager;

import com.eduonix.taskmanager.page.LoginPage;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SpringUI
public class TaskUI extends UI {
  
	@Override
	protected void init(VaadinRequest request) {
		new Navigator(this,this);
		
		getNavigator().addView(LoginPage.NAME, LoginPage.class);
		
		Page.getCurrent().addPopStateListener(e -> {
			route(e.getUri());
		});
		
		route("");
		
	}
	
	public void route(String uri) {
		if(VaadinSession.getCurrent().getAttribute("user") != null) {
			//TODO: route to home
		} else {
			getNavigator().navigateTo(LoginPage.NAME);
		}
	}
	
}
