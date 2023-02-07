package com.example.DislinktXWSProject.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.DislinktXWSProject.model.User;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "profiles")
public class Profile {
	@Id
	private Long id;
    private User user;
    private Set<Post> posts;
    private Set<FollowRequest> followRequests;
    private String experiences;
    private String education;
    private String interests;
    private String skills;
    private boolean privateProfile;
    private Set<Profile> followers;
    private Set<Profile> followings;
    
    public Profile() {

	}
    
	public Profile(Long id, User user, Set<Post> posts, Set<FollowRequest> followRequests, String experiences, String education, String interests, String skills, boolean privateProfile, Set<Profile> followers, Set<Profile> followings) {
		
		this.id = id;
		this.user = user;
		this.posts = posts;
		this.followRequests = followRequests;
		this.experiences = experiences;
		this.education = education;
		this.interests = interests;
		this.skills = skills;
		this.privateProfile = privateProfile;
		this.followers = followers;
		this.followings = followings;
	}
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<FollowRequest> getFollowRequests() {
		return followRequests;
	}

	public void setFollowRequests(Set<FollowRequest> followRequests) {
		this.followRequests = followRequests;
	}

	public String getExperience() {
		return experiences;
	}
	public void setExperience(String experiences) {
		this.experiences = experiences;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public boolean isPrivateProfile() {
		return privateProfile;
	}
	public void setPrivateProfile(boolean privateProfile) {
		this.privateProfile = privateProfile;
	}
	public Set<Profile> getFollowers() {
		return followers;
	}
	public void setFollowers(Set<Profile> followers) {
		this.followers = followers;
	}

	public Set<Profile> getFollowings() {
		return followings;
	}

	public void setFollowings(Set<Profile> followings) {
		this.followings = followings;
	}

    
}
