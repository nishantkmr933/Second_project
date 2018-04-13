package com.codezlabs.Facebook_backend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "s_User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="user_sequence")
	@SequenceGenerator(sequenceName="user_sequence", name = "user_sequence")
	private long userId;
	private String userName;
	private String password;
	private String email;
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
	private boolean isOnline;

	public long getUserId() {
		return userId;
	}

	public long setUserId() {
		//this.userId = UUID.randomUUID().toString().substring(0,10);
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

}
