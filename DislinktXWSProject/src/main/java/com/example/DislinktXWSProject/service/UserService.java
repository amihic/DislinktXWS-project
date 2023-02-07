package com.example.DislinktXWSProject.service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.DislinktXWSProject.model.Post;
import com.example.DislinktXWSProject.model.Profile;
import com.example.DislinktXWSProject.model.Role;
import com.example.DislinktXWSProject.model.User;
import com.example.DislinktXWSProject.repository.PostRepository;
import com.example.DislinktXWSProject.repository.ProfileRepository;
import com.example.DislinktXWSProject.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private PostRepository postRepository;
	
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
        
        
        
        User u = new User((long) 0, "dsadsaadsdas", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra", "dadsa", "dsadsa", "dasdsa@gmail.com", "20.08.1999", true, null, "User");
        this.userRepository.save(u);
        Post po = new Post((long) 0, u, "dobro dosao", null, null, null, null, (long)  0,(long)  0);
        this.postRepository.save(po);
        
        Set<Profile> followings = new HashSet<>();
        Set<Profile> followers = new HashSet<>();
        Set<Post> posts = new HashSet<>();
        
        posts.add(po);
        Profile p = new Profile((long) 0, u, posts, null, null,null,null,null,false, null, null);
        this.profileRepository.save(p);
        followings.add(p);
        followers.add(p);
        
        
        Profile userProfile = new Profile();
        userProfile.setId(user.getId());
        userProfile.setUser(user);
        userProfile.setPosts(posts);
        userProfile.setFollowings(followings);
        userProfile.setFollowers(followers);
        userProfile.setFollowRequests(null);
        userProfile.setExperience(null);
        userProfile.setEducation(null);
        userProfile.setInterests(null);
        userProfile.setSkills(null);
        userProfile.setPrivateProfile(false);

        
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
