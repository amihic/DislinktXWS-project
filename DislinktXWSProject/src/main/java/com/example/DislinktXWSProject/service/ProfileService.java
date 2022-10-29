package com.example.DislinktXWSProject.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DislinktXWSProject.model.Profile;
import com.example.DislinktXWSProject.model.User;
import com.example.DislinktXWSProject.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	
	public Profile findById(Long id) {
		Optional<Profile> profile = this.profileRepository.findById(id);
		if(!profile.isPresent()) {
			return null;
		}
		return profile.get();
	}
	
	public Profile getByUsername(String username) {
		List<Profile> profiles = this.profileRepository.findAll();
		for(Profile p:profiles) {
			if(username.equals(p.getUser().getUsername())) {
				return p;
			}			
		}
		return null;
	}
	
	public Profile save(Profile profile) {
		List<Profile> profiles = this.profileRepository.findAll();
		Long id = (long) 0;
		for(Profile p:profiles) {
			id = p.getId();
		}
		id=id+1;
		profile.setId(id);
		return this.profileRepository.save(profile);
	}
	
	public Profile update(Profile profile) {
		Profile updatedProfile = this.profileRepository.getById(profile.getId());
		
		updatedProfile.setUser(profile.getUser());
		updatedProfile.setSkills(profile.getSkills());
		updatedProfile.setPrivateProfile(profile.isPrivateProfile());
		updatedProfile.setInterests(profile.getInterests());
		updatedProfile.setFollowers(profile.getFollowers());
		updatedProfile.setExperience(profile.getExperience());
		updatedProfile.setEducation(profile.getEducation());
		
		return this.profileRepository.save(updatedProfile);
	}
	
}
