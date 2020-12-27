package com.eduonix.complaintsystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.eduonix.complaintsystem.entities.Complaint;

public class ComplaintDao {

	private Session session;

	public ComplaintDao(SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
	}

	public void insertComplaint(Complaint complaint) {
		session.save(complaint);
		session.flush();
	}

	public List<Complaint> getAllComplaints() {
		Query q = session.createQuery("from Complaint");
		List<Complaint> toReturn = q.list();

		return toReturn;

	}

	public void deleteComplaint(Integer complaintID) {
		Query q = session.createQuery("delete from Complaint where id = " + complaintID);
		q.executeUpdate();

	}
	
	public void close() {
		session.close();
	}

}
