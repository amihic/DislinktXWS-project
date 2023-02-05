package com.example.authenticationService.model;

import java.util.List;

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
    private List<String> experience;
    private List<String> education;
    private List<String> interests;
    private List<String> skills;
    private boolean privateProfile;
    private List<User> followers;
    
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(Long id, User user, List<String> experience, List<String> education, List<String> interests,
			List<String> skills, boolean privateProfile, List<User> followers) {
		super();
		this.id = id;
		this.user = user;
		this.experience = experience;
		this.education = education;
		this.interests = interests;
		this.skills = skills;
		this.privateProfile = privateProfile;
		this.followers = followers;
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

	public List<String> getExperience() {
		return experience;
	}

	public void setExperience(List<String> experience) {
		this.experience = experience;
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

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}
    
    
    
    
    
    
    
}
