package com.example.DislinktXWSProject.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.DislinktXWSProject.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
	
	User getByUsername(String username);
	User getById(Long id);
	
	
}
