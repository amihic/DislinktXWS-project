package com.example.DislinktXWSProject.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.DislinktXWSProject.model.Post;
import com.example.DislinktXWSProject.model.Profile;
import com.example.DislinktXWSProject.model.Role;
import com.example.DislinktXWSProject.model.User;
import com.example.DislinktXWSProject.repository.ProfileRepository;
import com.example.DislinktXWSProject.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	private PasswordEncoder passwordEncoder; 
	
	public UserService() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	
	public User findById (Long id)
    {
        Optional<User> opt=this.userRepository.findById(id);
        if(!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }
	
	public User getByUsername(String username) {
		User user = userRepository.getByUsername(username);
        return  user;
	}
	
	public User save(User user){
		
		List<User> users = this.userRepository.findAll();
		for(User u:users) {
			if(user.getUsername().equals(u.getUsername())) {
				System.out.printf("Username already exists!");
				return null;
			}
		}
		
		String encodedPassword = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
        List<User> listOfAll = this.userRepository.findAll();
        Long id=(long)0;
        for ( User u:listOfAll) {
            id=u.getId();
        }
        id=id+1;
        user.setId(id);
        List<Role> role = new ArrayList<>();
        Role r = new Role((long) 1, "ROLE_USER");
        role.add(r);
        user.setRoles(role);
        user.setEnabled(true);
        System.out.println("User " + user.getUsername() + " uspesno registrovan");
        
        Profile userProfile = new Profile();
        userProfile.setId(user.getId());
        userProfile.setUser(user);
        userProfile.setPosts(null);
        userProfile.setExperience(null);
        userProfile.setEducation(null);
        userProfile.setInterests(null);
        userProfile.setSkills(null);
        userProfile.setPrivateProfile(false);
        userProfile.setFollowers(null);
        userProfile.setFollowings(null);
        
        this.profileRepository.save(userProfile);        
        System.out.println("Useru " + user.getUsername() + " uspesno napravljen profil");
        return this.userRepository.save(user);

    }
	
	public User updateUser(User user) {
		
		User updatedUser = this.userRepository.getByUsername(user.getUsername());
		
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setDateOfBirth(user.getDateOfBirth());
		updatedUser.setUsername(user.getUsername());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setEnabled(user.getEnabled());
		updatedUser.setRoles(user.getRoles());
		updatedUser.setRoleType(user.getRoleType());
		
		return this.userRepository.save(updatedUser);
		
	}
	
	
}
