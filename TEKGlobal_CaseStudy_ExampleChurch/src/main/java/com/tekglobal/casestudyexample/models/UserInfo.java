package com.tekglobal.casestudyexample.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserInfo {

	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Column(length=50, nullable=false, unique=true, name="email")
	private String email;


//	@Column(length=50, nullable=false, name="firstname")
	private String firstName;
//	@Column(length=50, nullable=false, name="lastname")
	private String lastName;
//	@Column(length=75, nullable=false, name="address")
	private String address;
//	@Column(length=50, nullable=false, name="phonenumber")
	private String phoneNumber;
//	@Column(length=15, nullable=false, name="date")
	@Temporal(TemporalType.DATE)
	private Date dateJoined;
	
//	@OneToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "id", nullable = false)
//	@PrimaryKeyJoinColumn
	
	@OneToOne(mappedBy = "userInfo")
	private ChurchMember member;
	
	public UserInfo () {
		
	}
	
	public UserInfo( String firstName, String lastName, String address, String email, String phoneNumber
			) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		dateJoined = new Date();
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Date getDateJoined() {
		return dateJoined;
	}


	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public ChurchMember getMember() {
		return member;
	}

	public void setMember(ChurchMember member) {
		this.member = member;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	
	
	 

}
