package com.eduonix.taskmanager;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {
	
	public static ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
		
	}
	
	public static ApplicationContext getApplicationContext () {
		return ctx;
	}

}
