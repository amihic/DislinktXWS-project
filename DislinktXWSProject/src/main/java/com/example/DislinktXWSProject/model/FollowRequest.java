package com.example.DislinktXWSProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Document(collection = "followRequests")
public class FollowRequest {
	@Id
    private Long id;
    private String username;
    private String usernameWhichWantToFollow;
    private boolean followRequest;
	
    public FollowRequest() {

	}

	public FollowRequest(Long id, String username, String usernameWhichWantToFollow, boolean followRequest) {
		super();
		this.id = id;
		this.username = username;
		this.usernameWhichWantToFollow = usernameWhichWantToFollow;
		this.followRequest = followRequest;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernameWhichWantToFollow() {
		return usernameWhichWantToFollow;
	}

	public void setUsernameWhichWantToFollow(String usernameWhichWantToFollow) {
		this.usernameWhichWantToFollow = usernameWhichWantToFollow;
	}

	public boolean isFollowRequest() {
		return followRequest;
	}

	public void setFollowRequest(boolean followRequest) {
		this.followRequest = followRequest;
	}
    
    
    
    
    
    
}
