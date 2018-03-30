package com.codezlabs.Facebook_backend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="s_Friend")
public class Friend {

	@Id
	private String friendId;
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	@Enumerated(EnumType.STRING)
	private RequestStatus status;
	private boolean isOnline;
	public String getId() {
		return friendId;
	}
	public void setId(long id) {
		this.friendId = UUID.randomUUID().toString().substring(0,10);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public RequestStatus getStatus() {
		return status;
	}
	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	
}
