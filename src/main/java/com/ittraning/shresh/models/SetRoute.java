package com.ittraning.shresh.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "setRoute")
public class SetRoute {
	@Id	
	@GeneratedValue
	@Column(name = "SetRoute_ID")
	private long id;
	@OneToOne
	@JoinColumn(name = "Bus_ID")
	private Bus bus;
	@OneToOne
	@JoinColumn(name = "Location1_ID")
	private Location location1;
	@OneToOne
	@JoinColumn(name = "Location2_ID")
	private Location location2;
	@Column(name = "Date")
	@Type(type = "date")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date date;
	@Column(name = "Time")
	private String time;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public Location getLocation1() {
		return location1;
	}
	public void setLocation1(Location location1) {
		this.location1 = location1;
	}
	public Location getLocation2() {
		return location2;
	}
	public void setLocation2(Location location2) {
		this.location2 = location2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}	
}
