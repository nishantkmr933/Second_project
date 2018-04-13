package com.codezlabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codezlabs.Facebook_backend.Dao.EventDao;
import com.codezlabs.Facebook_backend.Dao.FriendDao;
import com.codezlabs.Facebook_backend.model.Event;
import com.codezlabs.Facebook_backend.model.Friend;
import com.codezlabs.Facebook_backend.model.User;

@RestController
public class FriendContoller {
	@Autowired
	FriendDao friendDao;

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Friend friend) {
		if (friendDao.create(friend)) {
			return new ResponseEntity<String>("Add Friends", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Unable to Add Friend", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Friend friend) {
		if (friendDao.update(friend)) {
			return new ResponseEntity<String>("Update Friend", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("unable to update Friend", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// @GetMapping("/get/{friendId}")
	// public ResponseEntity<String>get(@RequestBody User user,Friend friend){
	// Friend friends= friendDao.get(user, friend);
	// if(friends!=null){
	// return new ResponseEntity<String>(friend,HttpStatus.OK);
	// }else{
	// return new
	// ResponseEntity<String>(friend,HttpStatus.INTERNAL_SERVER_ERROR);
	// }
	//
	// }

	@GetMapping("/getFriends/{friendId}")
	public ResponseEntity<List<Friend>> getFriends(@PathVariable("friendId") String friendId) {
		List<Friend> listFriend = friendDao.getFriends(friendId);
		if (listFriend != null) {
			return new ResponseEntity<List<Friend>>(listFriend, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Friend>>(listFriend, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getRequest/{friendId}")
	public ResponseEntity<List<Friend>>getRequest(@PathVariable("friendId") String friendId){
		List<Friend> listFriend=friendDao.getRequest(friendId);
		if(listFriend!=null){
			return new ResponseEntity<List<Friend>>(listFriend,HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Friend>>(listFriend,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/setOnLine/{friendId}")
	public ResponseEntity setOnLine(@PathVariable("friendId") String friendId){
		boolean friends=friendDao.setOnLine(friendId);
		return new ResponseEntity<Friend>(HttpStatus.OK);
	}
	
	@GetMapping("/setOffLine/{friendId}")
	public ResponseEntity setOffLine(@PathVariable("friendId") String friendId){
		boolean friends=friendDao.setOnLine(friendId);
		return new ResponseEntity<Friend>(HttpStatus.OK);
	}
	
}
