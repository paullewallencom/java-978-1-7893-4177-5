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

	public Candidate() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="candidate_name")
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
	
	private Integer numberOfVotes;

	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	
	
	
	
}
