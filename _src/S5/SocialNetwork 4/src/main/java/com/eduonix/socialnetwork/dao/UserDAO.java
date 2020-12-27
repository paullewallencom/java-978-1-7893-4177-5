package com.eduonix.socialnetwork.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eduonix.socialnetwork.model.User;

public class UserDAO {
	
	private SessionFactory factory;
	private Session session;

	public UserDAO() {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
	}
	
	public void insertUser(User user) {
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	public void close() {
		session.close();
		factory.close();
	}
}
