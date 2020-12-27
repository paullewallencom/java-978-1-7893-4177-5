package com.eduonix.complaintsystem;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduonix.complaintsystem.dao.ComplaintDao;
import com.eduonix.complaintsystem.entities.Complaint;

@Controller
public class App {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping("/fileComplaint")
	public String fileComplaint() {
		
		Complaint p = new Complaint(1,"Hello","bob","bob@bob.com");
		
		ComplaintDao dao = new ComplaintDao(sessionFactory);
		
		dao.insertComplaint(p);
		
		for(Complaint i : dao.getAllComplaints()) {
			System.out.println(i.getMessage());
		}
		
		return "fileComplaint";
	}
	
	@RequestMapping(name="/submitComplaints",method=RequestMethod.GET)
	public String submitComplaints() {
		return "submitComplaint";
	}
	
	@RequestMapping(name="/submitComplainst",method=RequestMethod.POST)
	public String submitComplaintsPost() {
		return "showEnterPassword";
	}
	
	@RequestMapping("/showComplaints")
	public String showComplaints() {
		return "showComplaints";
	}
	
	

}
