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
    private Profile user;
    private Profile userWhichWantToFollow;
    private boolean accepted;
	
    public FollowRequest() {

	}

	public FollowRequest(Long id, Profile user, Profile userWhichWantToFollow, boolean accepted) {
		super();
		this.id = id;
		this.user = user;
		this.userWhichWantToFollow = userWhichWantToFollow;
		this.accepted = accepted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profile getUser() {
		return user;
	}

	public void setUser(Profile user) {
		this.user = user;
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
