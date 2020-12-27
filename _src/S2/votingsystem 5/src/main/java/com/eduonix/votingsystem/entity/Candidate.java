package com.eduonix.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="candidates")
@Entity
public class Candidate {
	
	@Id
	@Column(name="id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Candidate() {
		super();
	}
	
	@Column(name="numberOfVotes")
	private Long numberOfVotes;

	public Long getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(Long numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	public Candidate(Long id, Long numberOfVotes, String name) {
		super();
		this.id = id;
		this.numberOfVotes = numberOfVotes;
		this.name = name;
	}

	@Column(name = "candidate_name") 
	private String name;

	public String getName() {
		return name;
	}

	public Candidate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
