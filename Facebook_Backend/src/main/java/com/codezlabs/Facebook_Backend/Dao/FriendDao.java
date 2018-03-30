package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import com.codezlabs.Facebook_backend.model.Friend;

public interface FriendDao {

	public boolean create(Friend friend);
	public boolean update(Friend friend);
	Friend get(String userId,String friendId);
	List<Friend> getFriends(String userId);
	List<Friend>getRequest(String userId);
	public boolean setOnLine(String userId);
	public boolean setOffLine(String userId);
}
