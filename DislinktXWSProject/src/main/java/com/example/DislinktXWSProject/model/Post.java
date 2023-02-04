package com.example.DislinktXWSProject.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.DislinktXWSProject.model.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "posts")
public class Post {
	@Id
	private Long id;
	private User owner;
	private String text;
	private List<Long> userIdWhoLikes;
	private List<Comment> comments;
	private String picture;
	private Long numberOfLikes;
	//private Long numberOfDislikes;
	
	public Post() {

	}
	
	public Post(Long id, User owner, String text, List<Long> userIdWhoLikes, List<Comment> comments, String picture, Long numberOfLikes) {

		this.id = id;
		this.owner = owner;
		this.text = text;
		this.userIdWhoLikes = userIdWhoLikes;
		this.comments = comments;
		this.picture = picture;
		this.numberOfLikes = numberOfLikes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getOwnerId() {
		return owner;
	}
	public void setOwnerId(User owner) {
		this.owner = owner;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Long> getUserIdWhoLikes() {
		return userIdWhoLikes;
	}
	public void setUserIdWhoLikes(List<Long> userIdWhoLikes) {
		this.userIdWhoLikes = userIdWhoLikes;
	}

	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Long getNumberOfLikes() {
		return numberOfLikes;
	}
	public void setNumberOfLikes(Long numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}


	
	
	
		
}
