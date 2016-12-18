package com.ittraning.shresh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bus")
public class Bus {
	@Id
	@GeneratedValue
	@Column(name = "Bus_ID")
	private long id;
	@Column(name = "Bus_No")
	private String busNo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}	
}
