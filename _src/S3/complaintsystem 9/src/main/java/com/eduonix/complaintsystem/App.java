package com.eduonix.complaintsystem;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eduonix.complaintsystem.dao.ComplaintDao;
import com.eduonix.complaintsystem.entities.Complaint;

@Controller
@PropertySource({ "classpath:admin-properties.properties" })
public class App {

	@Autowired
	private Environment env;

	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping("/")
	public String fileComplaint() {
		return "fileComplaint";
	}

	@RequestMapping("/submitComplaint")
	public String submitComplaint(@RequestParam("complaint") String complaint, @RequestParam("name") String name,
			@RequestParam("email") String email) {

		ComplaintDao dao = new ComplaintDao(sessionFactory);

		Complaint d = new Complaint(complaint, name, email);

		dao.insertComplaint(d);

		System.out.println("Inserted Complaint");
		return "submitcomplaint";
	}

	@RequestMapping(name = "/showComplaints", method = RequestMethod.GET)
	public String showComplaints() {
		return "showEnterPassword";
	}

	@RequestMapping(name = "/showComplaints", method = RequestMethod.POST)
	public ModelAndView showComplaintsPost(@RequestParam("pass") String pass, ModelAndView modelAndView) {

		if (pass.equals(env.getProperty("admin.password"))) {

			ComplaintDao dao = new ComplaintDao(sessionFactory);
			List<Complaint> complaints = dao.getAllComplaints();

			modelAndView.addObject("complaints", complaints);
			modelAndView.setViewName("showComplaints");

		} else {
			modelAndView.setViewName("showEnterPassword");
		}
		return modelAndView;
	}

}
