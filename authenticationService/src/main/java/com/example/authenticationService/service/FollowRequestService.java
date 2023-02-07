package com.example.authenticationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authenticationService.model.FollowRequest;
import com.example.authenticationService.repository.FollowRequestRepository;

@Service
public class FollowRequestService {
	
	@Autowired
	private FollowRequestRepository followRequestRepository;
	
	public FollowRequest save (FollowRequest followRequest) {
		return this.followRequestRepository.save(followRequest);
	}
}
