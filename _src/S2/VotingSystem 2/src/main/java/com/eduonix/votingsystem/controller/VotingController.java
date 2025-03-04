package com.eduonix.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public String doLogin(@RequestParam String name) {
		Citizen citizen = citizenRepo.findByName(name);
		if(!citizen.getHasVoted()) {
			return "/performVote";
		} else {
			return "/alreadyVoted";
		}
	}
	

}
