package com.example.authenticationService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "experiences")
public class Experience {

	@Id
	private Long id;
	private String expirience;
	public Experience() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Experience(Long id, String expirience) {
		super();
		this.id = id;
		this.expirience = expirience;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpirience() {
		return expirience;
	}
	public void setExpirience(String expirience) {
		this.expirience = expirience;
	}
	
	
}

