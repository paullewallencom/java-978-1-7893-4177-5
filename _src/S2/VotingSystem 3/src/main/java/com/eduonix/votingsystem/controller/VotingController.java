package com.eduonix.votingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eduonix.votingsystem.entity.Candidate;
import com.eduonix.votingsystem.entity.Citizen;
import com.eduonix.votingsystem.repositories.CandidateRepo;
import com.eduonix.votingsystem.repositories.CitizenRepo;

@Controller
public class VotingController {
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@RequestMapping("/")
	public String goToVote() {
		return "vote";
	}
	
	@RequestMapping("/doLogin") 
	public String doLogin(@RequestParam String name,Model model) {
		Citizen citizen = citizenRepo.findByName(name);
		if(!citizen.getHasVoted()) {
			List<Candidate> candidates = candidateRepo.findAll();
			model.addAttribute("candidates",candidates);
			return "/performVoted";
		} else {
			return "/alreadyVoted";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id) {
		Candidate c = candidateRepo.findById((long)id);
		c.setNumberOfVotes(c.getNumberOfVotes()+1);
		candidateRepo.save(c);
		
		return "voted";
		
	}
	

}
