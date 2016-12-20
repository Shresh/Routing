package com.ittraning.shresh.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Users")
public class Users {
	@Id
	@GeneratedValue
	@Column(name = "User_ID")
	private long id;
	@Column(name = "First_Name")
	private String firstName;
	@Column(name = "Last_Name")
	private String lastName;
	@Column(name = "Date_Of_Birth")
	@Type(type = "date")
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	private Date dateOfBirth;
	@Column(name = "Gender")
	private String gender;
	@Column(name = "Contact_No")
	private String contactNo;
	@Column(name = "Username")
	private String username;
	@Column(name = "Password")
	private String password;
	@Column(name = "Role", nullable = false, columnDefinition = "enum('Admin','User') default 'User'")
	@Enumerated(EnumType.STRING)	
	private Role role = Role.User;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public enum Role{
		Admin, User
	}
}
