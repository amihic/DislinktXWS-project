package com.example.DislinktXWSProject.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.DislinktXWSProject.model.FollowRequest;


@Repository
public interface FollowRequestRepository extends MongoRepository<FollowRequest, Long> {

	

}
