package com.example.DislinktXWSProject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DislinktXWSProject.model.FollowRequest;
import com.example.DislinktXWSProject.repository.FollowRequestRepository;

@Service
public class FollowRequestService {

	@Autowired
	private FollowRequestRepository followRequestRepository;
	
	public FollowRequest save(FollowRequest followRequest) {		
		return followRequestRepository.save(followRequest);
	}

}
