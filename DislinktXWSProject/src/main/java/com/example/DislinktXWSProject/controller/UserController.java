package com.example.DislinktXWSProject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.DislinktXWSProject.service.UserService;
import com.example.DislinktXWSProject.model.Profile;
import com.example.DislinktXWSProject.model.User;
import com.example.DislinktXWSProject.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	//pronadji usera po id
	@RequestMapping(value="api/user/{id}",method = RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> getById(@PathVariable Long id){
		User user = this.userService.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	//nadji profil po username-u
	//@PreAuthorize("hasRole('USER')")
	@RequestMapping(value="api/userN/{username}",method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> getByUsername(@PathVariable String username){
		User user = this.userService.getByUsername(username);
		if(user==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);			
	}
	
	
	//pronadji sve usere
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="api/users",method = RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<User>> getAll(){
		List<User> users = this.userRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	//izbrisi usera po id
	@RequestMapping(value = "api/user/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable Long id){
		User user = this.userService.findById(id);
		if(user==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		this.userRepository.delete(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//sacuvaj usera(ID I UNOSENJE POLJA iz body-ja - @RequestBody)
	@RequestMapping(value = "api/user",method=RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> save(@RequestBody User user){
		User newUser = this.userService.save(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	//update usera
	//@PreAuthorize("hasRole('User')")
	@PutMapping(value = "api/user")
	public ResponseEntity<User> update(@RequestBody User user){
		User updatedUser = this.userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	
	
}
