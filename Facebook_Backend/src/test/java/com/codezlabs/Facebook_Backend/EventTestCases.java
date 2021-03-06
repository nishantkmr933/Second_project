package com.codezlabs.Facebook_backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.codezlabs.Facebook_backend.Dao.EventDao;
import com.codezlabs.Facebook_backend.config.AppContextConfig;
import com.codezlabs.Facebook_backend.model.Event;
import com.codezlabs.Facebook_backend.model.EventStatus;

import junit.framework.Assert;

public class EventTestCases {
	
	@Autowired
	static EventDao eventDao;
	@Autowired
	static Event event;	
	
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(AppContextConfig.class);
		context.scan("com.codezlabs.Facebook_backend");
		//context.refresh();
		eventDao = (EventDao) context.getBean("eventDao");
		event=(Event)context.getBean("event");
	}
	
	@Ignore
	@Test
	public void createTestCase() {
		event.setTitle("Hello");
		event.setDescription("Welcome Event");
		event.setStatus(EventStatus.EVENT_NEW); 
		event.setEventDate(new java.util.Date());
		eventDao.create(event);
		Assert.assertEquals("Create Event test case", true);
	}
	
	@Ignore
	@Test
	public void updateTestCase(){
		event.setTitle("Udpate Hello");
		eventDao.update(event);
		Assert.assertEquals("Update Event", true);
	}
	
	@Ignore
	@Test
	public void getByIdTestCase(){
		//eventDao.getById(event.getEventId());
		event.setEventId();
		//eventDao.getById(event.setEventId());	
		Assert.assertEquals("Get the value", true);
	}
	
	@Ignore
	@Test
	public void getAllTestCase(){
		List<Event> event=eventDao.getAll();
		System.out.println(event);
		Assert.assertEquals("All value", true);
	}
}
