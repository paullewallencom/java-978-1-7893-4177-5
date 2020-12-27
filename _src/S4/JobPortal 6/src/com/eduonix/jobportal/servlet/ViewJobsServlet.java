package com.eduonix.jobportal.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduonix.jobportal.dao.JobPostingDAO;
import com.eduonix.jobportal.entity.JobPosting;


@WebServlet("/ViewJobs")
public class ViewJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ViewJobsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobPostingDAO dao = new JobPostingDAO();
		
		List<JobPosting> jobs = dao.getAllJobPostings();
		request.setAttribute("jobs", jobs);
		
		RequestDispatcher rd = request.getRequestDispatcher("/viewJobs.jsp");
		rd.forward(request, response);
	}


}
