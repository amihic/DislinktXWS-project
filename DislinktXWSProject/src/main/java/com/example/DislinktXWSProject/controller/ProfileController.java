package com.example.DislinktXWSProject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.DislinktXWSProject.model.Post;
import com.example.DislinktXWSProject.model.Profile;
import com.example.DislinktXWSProject.repository.ProfileRepository;
import com.example.DislinktXWSProject.service.ProfileService;

@CrossOrigin("*")
@RestController
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	//nadji jedan profil
	/*@RequestMapping(value = "api/profile/{id}",method = RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Profile> getProfileById(@PathVariable Long id){
		Profile profile = this.profileService.findById(id);
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}*/
	
	//nadji sve profile
	@RequestMapping(value = "api/profileId/{id}",method = RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Profile> getProfile(@PathVariable Long id){
		Profile profile = this.profileRepository.getById(id);
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}
	
	
	//nadji profil po username-u
	@RequestMapping(value="api/profile/{username}",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Profile> getByUsername(@PathVariable String username){
		Profile profile = this.profileService.getByUsername(username);
		return new ResponseEntity<>(profile, HttpStatus.OK);
		
	}
	
	@PutMapping(value="api/follow/{username}/{id}")
	public ResponseEntity<Profile> follow(@PathVariable String username, @PathVariable Long id){
		Profile profile = this.profileService.follow(username, id);
		return new ResponseEntity<>(profile, HttpStatus.OK);
		
	}
	
	
	//izbrisi profil po id
	@RequestMapping(value = "api/profile/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Profile> delete(@PathVariable Long id){
		Profile profile = this.profileService.findById(id);
		if(profile==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.profileRepository.delete(profile);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//kreiranje novog profila
	@RequestMapping(value = "api/profile", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profile> save(@RequestBody Profile profile){
		Profile newProfile = this.profileService.save(profile);
		return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
	}
	
	//update profila
	@PutMapping(value="api/profileEdit/{id}")
	public ResponseEntity<Profile> update(@RequestBody Profile profile){
		Profile updatedProfile = this.profileService.update(profile);
		return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
	}	
	
}
