package com.tekglobal.casestudyexample.models;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tithe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

//	@ManyToOne
//	@JoinColumn(name = "id", insertable=false, updatable=false)
//	private ChurchMember member;

	// <This created 3 tables and implements the extra table>
//	@ManyToOne(targetEntity=ChurchMember.class,fetch = FetchType.LAZY)
//	@JoinTable
//	@JoinColumn(name="memberId")
//	private ChurchMember member;

	@ManyToOne(targetEntity=ChurchMember.class,fetch = FetchType.LAZY)
		@JoinTable(name = "member_tithe", joinColumns = {
	@JoinColumn(name = "titheId", referencedColumnName = "id") }, inverseJoinColumns = {
	@JoinColumn(name = "memberId", referencedColumnName = "id") })
	private ChurchMember member;

	private String titheAmount;

//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date dateCollected;

	private String date;

	public Tithe() {

	}

	public Tithe(Long id, ChurchMember member, String titheAmount) {
		super();
		this.id = id;
		this.member = member;
		this.titheAmount = titheAmount;
//		this.dateCollected = dateCollected;
	}



	public String getTitheAmount() {
		return titheAmount;
	}

	public void setTitheAmount(String titheAmount) {
		this.titheAmount = titheAmount;
	}


	public ChurchMember getMember() {
		return member;
	}

	public void setMember(ChurchMember member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Tithe [id=" + id + ", member=" + member + ", titheAmount=" + titheAmount + ", date=" + date + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
//		SimpleDateFormat availDate = new SimpleDateFormat("dd-MM-yyyy");
//		LocalDate newDate = LocalDate.parse(date);
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Tithe))
			return false;
		return id != null && id.equals(((Tithe) o).getId());
	}

}
