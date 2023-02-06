package com.example.authenticationService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.authenticationService.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, Long>{

}
