package com.codezlabs.Facebook_backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codezlabs.Facebook_backend.Dao.BlogDao;
import com.codezlabs.Facebook_backend.Dao.EventDaoImpl;
import com.codezlabs.Facebook_backend.config.AppContextConfig;
import com.codezlabs.Facebook_backend.model.Blog;
import com.codezlabs.Facebook_backend.model.Event;

import junit.framework.Assert;

public class EventTestCases {
	@Autowired
	static EventDaoImpl eventDao;

	@Autowired
	static Event event;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(AppContextConfig.class);
		context.scan("com.codezlabs.Facebook_backend");
		//context.refresh();
		eventDao = (EventDaoImpl) context.getBean("eventDao");
		event=(Event)context.getBean("event");
	}
	
	@Ignore
	@Test
	public void createTestCase() {
		event.setTitle("Hello");
		event.setDescription("Welcome Event");
		//event.setStatus();
		Assert.assertEquals("Create Event test case", true);
	}
	
	@Ignore
	@Test
	public void updateTestCase(){
		event.setTitle("Udpate Hello");
		Assert.assertEquals("Update Event", true);
	}
	
	@Ignore
	@Test
	public void getTestCase(){
	
		Assert.assertEquals("Get the value", true);
	}
}
