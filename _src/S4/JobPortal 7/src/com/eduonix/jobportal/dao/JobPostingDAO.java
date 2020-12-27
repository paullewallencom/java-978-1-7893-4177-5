package com.eduonix.jobportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			this.conn = DriverManager.getConnection(Database_URL, Database_USER, Database_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public JobPosting getJobPostingById(int id) {
		Statement st;

		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from jobPostings where id = " + id);

			if (rs.next()) {
				JobPosting jobPostToReturn = new JobPosting();

				jobPostToReturn.setContactPhone(rs.getString("contactPhone"));
				jobPostToReturn.setJobName(rs.getString("jobName"));
				jobPostToReturn.setPosterName(rs.getString("posterName"));
				jobPostToReturn.setMessageBody(rs.getString("messageBody"));
				jobPostToReturn.setId(rs.getInt("id"));
				jobPostToReturn.setJobPostingPassword(rs.getString("jobPostingPassword"));

				return jobPostToReturn;
			}
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}

		return null;

	}

	public void insertJobPosting(JobPosting posting) {
		String sep = "','";
		try {
			Statement st = conn.createStatement();
			String sqlQuery = "insert into jobPostings(messageBody,jobName,posterName,contactPhone,jobPostingPassword) values('"
					+ posting.getMessageBody() + sep + posting.getJobName() + sep + posting.getPosterName() + sep
					+ posting.getContactPhone() + sep + posting.getJobPostingPassword() + "')";
			System.out.println(sqlQuery);
			st.executeUpdate(sqlQuery);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void removeJobPosting(int jobPostId) {
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate("DELETE FROM JOBPOSTINGS WHERE ID = " + jobPostId);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<JobPosting> getAllJobPostings() {
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from jobPostings limit 200");
			List<JobPosting> jobs = new ArrayList<JobPosting>();
			while (rs.next()) {

				JobPosting jobPostToAdd = new JobPosting();

				jobPostToAdd.setContactPhone(rs.getString("contactPhone"));
				jobPostToAdd.setJobName(rs.getString("jobName"));
				jobPostToAdd.setPosterName(rs.getString("posterName"));
				jobPostToAdd.setMessageBody(rs.getString("messageBody"));
				jobPostToAdd.setId(rs.getInt("id"));

				jobs.add(jobPostToAdd);

			}

			st.close();
			rs.close();
			return jobs;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
