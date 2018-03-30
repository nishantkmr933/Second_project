package com.codezlabs.Facebook_backend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codezlabs.Facebook_backend.Dao.UserDao;
import com.codezlabs.Facebook_backend.config.AppContextConfig;
import com.codezlabs.Facebook_backend.model.User;

import junit.framework.Assert;

public class UserTestCases {

	
	static AnnotationConfigApplicationContext context;	
	static UserDao userDao;	
	static User user;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext(AppContextConfig.class);
		context.scan("com.codezlabs.Facebook_backend");
		//context.refresh();
		userDao = (UserDao) context.getBean("userDao");
		user=(User) context.getBean("user");
	}

	@Ignore
	@Test
	public void createTestCase() {
		user.setUserName("rahul");
		user.setEnabled(false);
		user.setOnline(false);
		userDao.create(user);
		Assert.assertEquals(user, true);
	}
	
	@Ignore
	@Test
	public void updateTestCase(){
		user.setUserName("Nishant");
		user.setEnabled(true);
		user.setOnline(true);
		userDao.update(user);
		Assert.assertEquals(user, true);
	}
	
	@Ignore
	@Test
	public void deleteTestCase(){
		user.setUserId();
		userDao.delete(user);
		Assert.assertEquals(user, true);
	}
	
	@Ignore
	@Test
	public void getByNameTestCase(){		
		user.setUserName("Nishant");
		//userDao.getByName();
		Assert.assertEquals("user", true);
	}
	
	@Ignore
	@Test
	public void authenticateTestCase(){
		user.setUserName("Nishant");
		user.setPassword("Nishant");
		//userDao.authenticate();
	}
}
