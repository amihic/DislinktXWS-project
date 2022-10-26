package com.example.DislinktXWSProject.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.DislinktXWSProject.model.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Long> {

}
