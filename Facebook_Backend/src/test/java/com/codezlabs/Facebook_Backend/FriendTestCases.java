package com.codezlabs.Facebook_backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codezlabs.Facebook_backend.Dao.FriendDao;
import com.codezlabs.Facebook_backend.model.Friend;
import com.codezlabs.Facebook_backend.model.RequestStatus;

import junit.framework.Assert;

public class FriendTestCases {

	static AnnotationConfigApplicationContext context;
	static Friend friend;
	static FriendDao friendDao;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.codezlabs");
		// context.refresh();
		friendDao = (FriendDao) context.getBean("friendDao");
		friend = (Friend) context.getBean("friend");
	}

	@Ignore
	@Test
	public void createTestCase() {
		friend.setOnline(false);
		friend.setStatus(RequestStatus.REQ_NEW);
		friendDao.create(friend);
		Assert.assertEquals("Create a friend", true);
	}

	@Ignore
	@Test
	public void updateTestcase() {
		friend.setOnline(true);
		friend.setStatus(RequestStatus.REQ_ACCEPTED);
		friendDao.update(friend);
		Assert.assertEquals("Aftre update", true);
	}
	@Ignore
	@Test
	public void getFriendsTestCase() {
		friendDao.getFriends("friend");
		Assert.assertEquals("get the user", true);
	}
	@Ignore
	@Test
	public void getRequestTestCase(){
		List<Friend>friend=friendDao.getRequest("0");
		System.out.println(friend);
		Assert.assertEquals("Get Request", true);
	}
}
