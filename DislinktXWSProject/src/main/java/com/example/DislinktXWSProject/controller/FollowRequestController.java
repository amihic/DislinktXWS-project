package com.example.DislinktXWSProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DislinktXWSProject.model.FollowRequest;
import com.example.DislinktXWSProject.service.FollowRequestService;

@CrossOrigin("*")
@RestController
public class FollowRequestController {

	@Autowired
	private FollowRequestService followRequestService;
	@PutMapping(value = "/api/followRequest/save")
	public ResponseEntity<FollowRequest> save(FollowRequest followRequest){
		FollowRequest newFollowRequest = this.followRequestService.save(followRequest);
		return new ResponseEntity<>(newFollowRequest, HttpStatus.CREATED);
		
	} 
	
}
