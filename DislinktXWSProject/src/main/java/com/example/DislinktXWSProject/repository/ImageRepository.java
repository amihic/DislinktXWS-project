package com.example.DislinktXWSProject.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.DislinktXWSProject.model.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, Long> {

}
