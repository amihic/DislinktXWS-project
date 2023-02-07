package com.example.authenticationService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.authenticationService.model.FollowRequest;

@Repository
public interface FollowRequestRepository extends MongoRepository<FollowRequest, Long>{

}
