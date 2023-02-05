package com.example.authenticationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authenticationService.model.Profile;
import com.example.authenticationService.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	
	public Profile save(Profile profile) {
		return this.profileRepository.save(profile);
	}
}
