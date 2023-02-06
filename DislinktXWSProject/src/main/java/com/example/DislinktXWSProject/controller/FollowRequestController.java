package com.example.DislinktXWSProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.DislinktXWSProject.model.FollowRequest;
import com.example.DislinktXWSProject.service.FollowRequestService;

@CrossOrigin("*")
@RestController
public class FollowRequestController {

	@Autowired
	private FollowRequestService followRequestService;
	
	public ResponseEntity<FollowRequest> save(){
		FollowRequest followRequest = this.followRequestService.save();
		return new ResponseEntity<>(followRequest, HttpStatus.CREATED);
		
	} 
	
}
