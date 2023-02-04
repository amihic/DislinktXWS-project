package com.example.authenticationService.dto;

import java.util.List;

import com.example.authenticationService.model.Role;

public class AuthenticatedUserDTO {
    private Long id;
    private List<Role> roles;
    private String role;
    private String username;
    private UserTokenState token;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public UserTokenState getToken() {
        return token;
    }
    public void setToken(UserTokenState token) {
        this.token = token;
    }
    public AuthenticatedUserDTO(Long id, String role, String username, UserTokenState token) {
        super();
        this.id = id;
        this.role = role;
        this.username = username;
        this.token = token;
    }

    public AuthenticatedUserDTO() {}
    
	public AuthenticatedUserDTO(Long id, List<Role> roles, String username, UserTokenState token) {
		super();
        this.id = id;
        this.roles = roles;
        this.username = username;
        this.token = token;
	}
}
