package com.eduonix.complaintsystem;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class App {
	
	@RequestMapping("/fileComplaint")
	public String fileComplaint() {
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
