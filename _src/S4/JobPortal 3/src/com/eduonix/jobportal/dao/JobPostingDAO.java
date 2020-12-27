package com.eduonix.jobportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.eduonix.jobportal.entity.JobPosting;

public class JobPostingDAO {
	
	private Connection conn;

	public JobPostingDAO() {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String Database_URL = "jdbc:mysql://localhost/jobPortal";
		
		final String Database_USER = "root";
		final String Database_PASS = "";
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			this.conn = DriverManager.getConnection(Database_URL,Database_USER,Database_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public JobPosting getJobPostingById(int id) {
		return null;
		
	}
	
	public void insertJobPosting(JobPosting posting) {
		
	}
	
	public void removeJobPosting(int jobPostId) {
		
	}
	
	public List<JobPosting> getAllJobPostings() {
		return null;
		
	}
	
	
	
	
}
