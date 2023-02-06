package com.example.DislinktXWSProject.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DislinktXWSProject.model.Post;
import com.example.DislinktXWSProject.model.Profile;
import com.example.DislinktXWSProject.model.User;
import com.example.DislinktXWSProject.repository.PostRepository;
import com.example.DislinktXWSProject.repository.ProfileRepository;
import com.example.DislinktXWSProject.repository.UserRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public Post save(Post post) {
		List<Post> posts = this.postRepository.findAll();
		Long id = (long) 0;
		
		for(Post p:posts) {
			id = p.getId();
		}
		id = id+1;
		post.setId(id);
		
		return this.postRepository.save(post);
	}
	
	
	public Post findById(Long id) {
		Optional<Post> post = this.postRepository.findById(id);
		if(!post.isPresent()) {
            return null;
        }
        return post.get();
	}


	public Set<Post> getAllPostsFromUser(String username) {
		List<Profile> profiles = this.profileRepository.findAll(); 
		Set<Post> userPosts = new HashSet<>();
		for(Profile p : profiles) {
			if(p.getUser().getUsername().equals(username)) {
				userPosts = p.getPosts();
			}
		}
		
		//userPosts = (Set<Post>) profile.getPosts();
		
		if(userPosts.isEmpty()) {
			System.out.println("User nema postove");
			return null;
		}
		return userPosts;
	}


	public Set<Post> findAllPostsFromUsersHeFollows(Long id) {
		Set<Post> followingPosts = new HashSet<Post>();
		Set<Profile> followingProfiles = new HashSet<>();
		Profile profile = this.profileRepository.getById(id);
		followingProfiles = profile.getFollowings();
		System.out.println(followingProfiles);
		for(Profile prof: followingProfiles) {
			for(Post post: prof.getPosts()) {
				followingPosts.add(post);
			}
		}
		
		if(followingPosts.isEmpty()) {
			System.out.println("Njegovi pratioci nemaju postove ili ne prati nikoga");
		}
		return followingPosts;
	}
	/*
	for(Profile prof:followingProfiles) {
		followingPostssss = prof.getPosts();
		for(Post post: followingPostssss) {
			followingPosts.add(post);
		}*/
	
	
}
