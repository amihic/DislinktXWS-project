package com.example.authenticationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authenticationService.model.Post;

import com.example.authenticationService.repository.PostRepository;


@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	
	public Post save(Post post) {
		return this.postRepository.save(post);
	}
}


