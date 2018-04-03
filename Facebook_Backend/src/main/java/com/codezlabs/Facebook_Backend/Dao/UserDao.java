package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import com.codezlabs.Facebook_backend.model.User;

public interface UserDao {
	public boolean create(User user);
	public boolean update(User user);
	public boolean delete(String userID);

	public User getById(String userId);
	public User getByName(String name);

	public List<User> getAll();
	public List<User> getAllExcept(long userId);

	public boolean exists(User auser);
	public boolean authenticate(String username, String password);

	public boolean setOnline(String userId);
	public boolean setOffline(String userId);

}
