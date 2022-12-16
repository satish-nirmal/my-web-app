package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, unique = true, length=45)
	private String email;
	
	@Column(length=25, nullable = false)
	private String password;
	
	@Column(length = 45 , nullable=false)
	private String firstname;
	
	@Column(length = 45 , nullable=false)
	private String lastname;
	
	private boolean enabled;

	public User() {

	}

	public User(Integer id, String email, String password, String firstname, String lastname, boolean enabled) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.enabled = enabled;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", enabled=" + enabled + "]";
	}

	public void addAttribute(String string, String string2) {
		
	}

	public void addAttribute(String string, List<User> listUsers) {
		
	}

	public void addAttribute(String string, User user2) {
		
	}	
}
