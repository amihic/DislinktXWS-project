package com.example.DislinktXWSProject.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Image {
	@Id
	private Long id;
	private String name;
    private String type;
    private byte[] picByte;
	
    public Image() {
		
	}

	public Image(Long id, String name, String type, byte[] picByte) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
    

}
