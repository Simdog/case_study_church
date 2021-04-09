package com.tekglobal.casestudyexample.models;




import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "churchmember")
public class ChurchMember {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Column(length=50, nullable=false, name="lastname")
	private String lastName;
	@Column(length=50, nullable=false, unique=true, name="email")
	private String email;
	@Column(length=50, nullable=false, name="phonenumber")
	private String phoneNumber;
	
	
	

	
	@OneToMany(targetEntity=Tithe.class, cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "member")
	private Set<Tithe> tithe;
	

	@OneToMany(targetEntity=Attendance.class, cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "member")
	private Set<Attendance> attendance = new HashSet<>();
	
	
	private ChurchRoles churchRole;
	
    // I also want to track the date of sign up
    // https://www.thecrazyprogrammer.com/2016/02/how-to-insert-date-and-time-in-mysql-using-java.html
	
	@Temporal(TemporalType.DATE)
    private Date date;
    
//	@OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserInfo userInfo;
 
	
	public ChurchMember() {
		this.date = new Date();
		this.churchRole = ChurchRoles.MEMBER;
	}
	
	protected ChurchMember(Long id, String lastName, String email, String phoneNumber) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void addTithe (Tithe tithe) {
		if (tithe != null) {
			if (this.tithe == null) {
				this.tithe = new HashSet<Tithe>();
			}
				this.tithe.add(tithe);
				tithe.setMember(this);
		}
		
	}
	
	public void removeTithe (Tithe tithe) {
		this.tithe.remove(tithe);
		tithe.setMember(null);
	}
	
	public void addAttendance (Attendance attendance) {
		if (attendance != null) {
			if (this.attendance == null) {
				this.attendance = new HashSet<Attendance>();
			}
				this.attendance.add(attendance);
				attendance.setMember(this);

		}
		
	}
	
	public void removeAttendance (Attendance attendance) {
		this.attendance.remove(attendance);
		attendance.setMember(null);
	}
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ChurchRoles getUserRole() {
		return churchRole;
	}

	public void setUserRole(ChurchRoles userRole) {
		this.churchRole = userRole;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}


	public Set<Tithe> getTithe() {
		return tithe;
	}

	public void setTithe(Set<Tithe> tithe) {
		this.tithe = tithe;
	}

	public Set<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(Set<Attendance> attendance) {
		this.attendance = attendance;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		
		if (userInfo == null) {
            if (this.userInfo != null) {
                this.userInfo.setMember(null);
            }
        }
        else {
            userInfo.setMember(this);
        }
        this.userInfo = userInfo;
    }
	
	
	
	
	
	

}
