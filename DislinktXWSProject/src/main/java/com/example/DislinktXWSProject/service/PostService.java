package com.example.DislinktXWSProject.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DislinktXWSProject.model.Post;
import com.example.DislinktXWSProject.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
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
	
	
}
