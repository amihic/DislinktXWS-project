package com.example.authenticationService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.authenticationService.model.Profile;


@Repository
public interface ProfileRepository extends MongoRepository<Profile, Long>{

}
