package com.codezlabs.Facebook_backend.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="S_Event")
public class Event {
	@Id
	private String eventId;
	private String title;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date eventDate;
	@Enumerated(EnumType.STRING)
	private EventStatus status;
	public String getEventId() {
		return eventId;
	}
	public String setEventId() {
		return this.eventId = UUID.randomUUID().toString().substring(0,10);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public EventStatus getStatus() {
		return status;
	}
	public void setStatus(EventStatus status) {
		this.status = status;
	}

}
