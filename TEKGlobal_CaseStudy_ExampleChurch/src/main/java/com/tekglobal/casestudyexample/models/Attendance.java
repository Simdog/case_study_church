package com.tekglobal.casestudyexample.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ManyToOne
	@ManyToOne(targetEntity=ChurchMember.class,fetch = FetchType.LAZY)
	@JoinTable(name = "member_attendance", joinColumns = {
@JoinColumn(name = "attendanceId", referencedColumnName = "id") }, inverseJoinColumns = {
@JoinColumn(name = "memberId", referencedColumnName = "id") })
	private ChurchMember member;
	private boolean isPresent;
	
	private String date;
	
//	@Temporal(TemporalType.DATE)
//	private Date dateOfAttendance;

	public Attendance() {
		
	}
	
	public Attendance(Long id, ChurchMember member, Boolean isPresent, String date) {
		super();
		this.id = id;
		this.member = member;
		this.isPresent = isPresent;
		this.date = date;
	}

	public Long getAttendanceId() {
		return id;
	}

	public void setAttendanceId(Long id) {
		this.id = id;
	}

	public ChurchMember getUserId() {
		return member;
	}

	public void setUserId(ChurchMember member) {
		this.member = member;
	}

	public Boolean getIsPresent() {
		return isPresent;
	}

	public void setIsPresent(Boolean isPresent) {
		this.isPresent = isPresent;
	}

//	public Date getDateOfAttendance() {
//		return dateOfAttendance;
//	}
//
//	public void setDateOfAttendance(Date dateOfAttendance) {
//		this.dateOfAttendance = dateOfAttendance;
//	}
	
	

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", member=" + member + ", isPresent=" + isPresent + ", dateOfAttendance="
				+ date + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ChurchMember getMember() {
		return member;
	}

	public void setMember(ChurchMember member) {
		this.member = member;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isPresent ? 1231 : 1237);
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isPresent != other.isPresent)
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		return true;
	}

	
	
	
	
}

