package com.example.authenticationService.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("profiles")
public class Profile {

	@Id
	private Long id;
    private User user;
    private Set<Post> posts;
    private Set<FollowRequest> followRequests;
    private Set<String> experiences;
    private List<String> education;
    private List<String> interests;
    private List<String> skills;
    private boolean privateProfile;
    private Set<Profile> followers;
    private Set<Profile> followings;
    
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(Long id, User user, Set<Post> posts, Set<FollowRequest> followRequests, Set<String> experiences, List<String> education, List<String> interests,
			List<String> skills, boolean privateProfile, Set<Profile> followers, Set<Profile> followings) {
		super();
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

	public Set<String> getExperience() {
		return experiences;
	}

	public void setExperience(Set<String> experiences) {
		this.experiences = experiences;
	}

	public List<String> getEducation() {
		return education;
	}

	public void setEducation(List<String> education) {
		this.education = education;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
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
