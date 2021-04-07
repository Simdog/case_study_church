package com.tekglobal.casestudyexample.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=2, max=25)
	private String username;
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	
	@Temporal(TemporalType.DATE)
    private Date dateJoined;

	
	public User () {
		this.dateJoined = new Date();

	}
	
	public User (String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ "]";
	}

	
	

}
