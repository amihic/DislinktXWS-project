package com.example.DislinktXWSProject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.DislinktXWSProject.model.Post;
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
	@RequestMapping(value="api/post",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Post> save(@RequestBody Post post){
		Post newPost = this.postService.save(post);
		return new ResponseEntity<>(newPost, HttpStatus.CREATED);
	}
	
	//prikaz svih postova
	@RequestMapping(value = "api/posts", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Post>> getAll(){
		List<Post> posts = this.postRepository.findAll();
		return new ResponseEntity<>(posts, HttpStatus.OK);		
	}
	
	@RequestMapping(value = "api/posts/{username}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Post>> getAll(@PathVariable String username){
		List<Post> posts = this.postService.getAllPostsFromUser(username);
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
