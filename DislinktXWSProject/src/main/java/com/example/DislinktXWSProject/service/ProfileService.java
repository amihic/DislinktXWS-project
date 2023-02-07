package com.example.DislinktXWSProject.service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DislinktXWSProject.model.FollowRequest;
import com.example.DislinktXWSProject.model.Profile;
import com.example.DislinktXWSProject.model.User;
import com.example.DislinktXWSProject.repository.FollowRequestRepository;
import com.example.DislinktXWSProject.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private FollowRequestRepository followRequestRepository;
	
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
	
	public Profile addingFollower(String username, Long id) {
		List<Profile> profiles = this.profileRepository.findAll();
		Profile profileWhoFollows = this.profileRepository.getById(id);
		Profile profileWhichIsFollowed = new Profile();
		Set<Profile> followers = new HashSet<>();
		for(Profile prof: profiles) {
			if(prof.getUser().getUsername().equals(username)) {
				profileWhichIsFollowed = prof;
				followers = profileWhichIsFollowed.getFollowers();
				followers.add(profileWhoFollows);
				profileWhichIsFollowed.setFollowers(followers);
				
				System.out.println("User " + profileWhoFollows.getUser().getUsername() + " je dodat u followerse profila " + prof.getUser().getUsername());

			}
		}
		return this.profileRepository.save(profileWhichIsFollowed);
	}
	
	public boolean checkIfFollowing(String username, Long id) {
		Profile profileWhoFollows = this.profileRepository.getById(id);
		Set<Profile> followings = new HashSet<>();
		followings = profileWhoFollows.getFollowings();
		
		for(Profile prof : followings) {
			if(prof.getUser().getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
		
	public Profile ifPrivateProfile(String username,Long id) {
		try {
		List<Profile> profiles = this.profileRepository.findAll();
		FollowRequest followRequest = new FollowRequest();
		Set<FollowRequest> followRequests = new HashSet<>();
		Profile following = this.profileRepository.getById(id);
		Profile followed = new Profile();
		for(Profile p : profiles) {
			if(p.getUser().getUsername().equals(username)) {
				followed = p;
			}
		}
		followRequests = followed.getFollowRequests();
		
		followRequest.setUsername(followed);
		followRequest.setId(id);
		followRequest.setFollowRequest(false);
		followRequest.setUserWhichWantToFollow(following);
		
		/*for(FollowRequest fr : followRequests) {
			if(followRequests.contains(followRequest)) {
				System.out.println("Nije smesten u listu follow requestsa jer ga vec sadrzi");
				return null;
			}
		}*/
		followRequests.add(followRequest);
		
		followed.setFollowRequests(followRequests);
		return this.profileRepository.save(followed);
		} catch(Exception e) {
			System.out.println("Exception");
			return null;

		}	
	}
	


	public Profile follow(String username, Long id) {
		List<Profile> profiles = this.profileRepository.findAll();
		Profile profileWhoFollows = this.profileRepository.getById(id);
		Set<Profile> followings = new HashSet<>();

		followings = profileWhoFollows.getFollowings();
		
		for(Profile p : profiles) {
			if(p.getUser().getUsername().equals(username)) {
				followings.add(p);								
				profileWhoFollows.setFollowings(followings);
				
				if(checkIfFollowing(username, id)) {
					System.out.println("User " + profileWhoFollows.getUser().getUsername() + " vec prati usera " + p.getUser().getUsername());
					return null;
				}
				/*if(p.isPrivateProfile()) {
					ifPrivateProfile(username, id);
					return null;
				}*/
				System.out.println("User " + profileWhoFollows.getUser().getUsername() + " je zapratio usera " + p.getUser().getUsername());
				
				addingFollower(username, id);
				return this.profileRepository.save(profileWhoFollows);
			}
		}				
		return null;
	}
	
}
