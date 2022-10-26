package com.example.DislinktXWSProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.example.DislinktXWSProject.service.UserService;
import com.example.DislinktXWSProject.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="api/user/{id}",method = RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<User> getById(@PathVariable Long id){
		User user = this.userService.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
}
