package com.example.DislinktXWSProject.controller;

import java.util.Set;

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
import com.example.DislinktXWSProject.repository.PostRepository;
import com.example.DislinktXWSProject.service.PostService;

@CrossOrigin("*")
@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private PostRepository postRepository;
	
	//postavljanje posta
	@PutMapping(value="api/addPost/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Profile> save(@PathVariable Long id, @RequestBody Post post){
		Profile profil = this.postService.save(id, post);
		return new ResponseEntity<>(profil, HttpStatus.OK);
	}
	
	//prikaz svih postova
	@RequestMapping(value = "api/postsFromUserHeFollows/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Set<Post>> getAllPostsFromUsersHeFollows(@PathVariable Long id){
		Set<Post> posts = this.postService.findAllPostsFromUsersHeFollows(id);
		if(!posts.isEmpty()) {
			return new ResponseEntity<>(posts, HttpStatus.OK);		
		}
		return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "api/posts/{username}/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Set<Post>> getAllPostsFromUser(@PathVariable String username, @PathVariable Long id){
		Set<Post> posts = this.postService.getAllPostsFromUser(username,id);
		return new ResponseEntity<>(posts, HttpStatus.OK);		
	}
	
	
	//nadji post po id
	@RequestMapping(value = "api/post/{id}", method = RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Post> getById(@PathVariable Long id){
		Post post = this.postService.findById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
	//brisanje posta 
	@RequestMapping(value = "api/post/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Post> delete(@PathVariable Long id){
		Post post = this.postService.findById(id);
		if(post == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.postRepository.delete(post);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}
