package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import com.codezlabs.Facebook_backend.model.User;

public interface UserDao {
	public boolean createUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(long userID);

	public User getById(long userId);
	public User getByName(String name);

	public List<User> getAll();
	public List<User> getAllExcept(long userId);

	public boolean exists(User auser);
	public boolean authenticate(String username, String password);

	public boolean setOnline(long userId);
	public boolean setOffline(long userId);

}
