package com.example.authenticationService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("followRequests")
public class FollowRequest {
	@Id
    private Long id;
    private Profile username;
    private Profile userWhichWantToFollow;
    private boolean accepted;
	
    public FollowRequest() {

	}

	public FollowRequest(Long id, Profile username, Profile userWhichWantToFollow, boolean accepted) {
		super();
		this.id = id;
		this.username = username;
		this.userWhichWantToFollow = userWhichWantToFollow;
		this.accepted = accepted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profile getUsername() {
		return username;
	}

	public void setUsername(Profile username) {
		this.username = username;
	}

	public Profile getUserWhichWantToFollow() {
		return userWhichWantToFollow;
	}

	public void setUserWhichWantToFollow(Profile userWhichWantToFollow) {
		this.userWhichWantToFollow = userWhichWantToFollow;
	}

	public boolean isFollowRequest() {
		return accepted;
	}

	public void setFollowRequest(boolean accepted) {
		this.accepted = accepted;
	}
    
    
    
    
    
    
}
