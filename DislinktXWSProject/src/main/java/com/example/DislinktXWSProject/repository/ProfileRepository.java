package com.example.DislinktXWSProject.repository;
import com.example.DislinktXWSProject.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileRepository extends MongoRepository<Profile, Long> {
	Profile getById(Long id);
}
