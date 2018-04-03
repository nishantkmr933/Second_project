package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import com.codezlabs.Facebook_backend.model.Event;

public interface EventDao {
	public boolean create(Event event); 
	public boolean update(Event event);
	public Event getById(long eventId);
	public List<Event> getAll();
}
