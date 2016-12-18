package com.ittraning.shresh.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@JoinColumn(name = "Location_ID")
	private Location location;
	@Column(name = "Date")
	private Date date;
	@Column(name = "Time")
	private String time;
	
}
