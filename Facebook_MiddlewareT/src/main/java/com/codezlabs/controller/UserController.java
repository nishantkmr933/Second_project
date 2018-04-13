package com.codezlabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codezlabs.Facebook_backend.Dao.UserDao;
import com.codezlabs.Facebook_backend.model.User;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;
	
	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		if (userDao.createUser(user)) {
			System.out.println("yo");
			return new ResponseEntity<String>("User created", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
		
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		if (userDao.updateUser(user)) {
			return new ResponseEntity<String>("User Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") long userId) {
		if (userDao.deleteUser(userId)) {
			return new ResponseEntity<String>("Delete user", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("unable to delete", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getById/{userId}")
	public ResponseEntity getById(@PathVariable("userId") long userId) {
		User listBlog = userDao.getById(userId);
		if (listBlog != null) {
			return new ResponseEntity(listBlog, HttpStatus.OK);
		} else {
			return new ResponseEntity(listBlog, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getByName/{userName}")
	public ResponseEntity getByName(@PathVariable("userName") String userName) {
		User listBlog = userDao.getByName(userName);
		if (listBlog != null) {
			return new ResponseEntity(listBlog, HttpStatus.OK);
		} else {
			return new ResponseEntity(listBlog, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll() {
		List<User> listBlogs = userDao.getAll();
		if (listBlogs != null) {
			return new ResponseEntity<List<User>>(listBlogs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(listBlogs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
