package com.eduonix.jobportal.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduonix.jobportal.dao.JobPostingDAO;
import com.eduonix.jobportal.entity.JobPosting;

@WebServlet("/PostJob")
public class PostJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PostJobServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/postJob.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String messageBody = request.getParameter("messageBody");
		String contactPhone = request.getParameter("contactphone");
		String posterName = request.getParameter("postername");
		String jobName = request.getParameter("jobname");
		String jobPostingPassword = request.getParameter("password");
		
		JobPosting jobPost = new JobPosting();
		
		jobPost.setContactPhone(contactPhone);
		jobPost.setJobName(jobName);
		jobPost.setJobPostingPassword(jobPostingPassword);
		jobPost.setMessageBody(messageBody);
		jobPost.setPosterName(posterName);
		
		JobPostingDAO dao = new JobPostingDAO();
		
		dao.insertJobPosting(jobPost);
		
		RequestDispatcher rd = request.getRequestDispatcher("/postJobSuccess.jsp");
		rd.forward(request, response);
		 

	}

}
