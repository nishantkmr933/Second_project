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
import com.codezlabs.Facebook_backend.model.Event;

@RestController
public class EventController {
	
	@Autowired
	EventDao eventDao;
	
	@PostMapping("/create")
	public ResponseEntity<String>create(@RequestBody Event event){
		if(event !=null){
			return new ResponseEntity<String>("Created Event",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("Unable to Create Event",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String>update(@RequestBody Event event){
		if(event!=null){
			return new ResponseEntity<String>("updated Event",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Unable to Update",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getById/{eventId}")
	public ResponseEntity getById(@PathVariable("eventId") long eventId){
		Event event = eventDao.getById(eventId);
		if(eventDao!=null){
			return new ResponseEntity(eventId,HttpStatus.OK);
		}else{
			return new ResponseEntity(eventId,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
//	@GetMapping("/getAll")
//	public ResponseEntity<List<Event>>getAll(@RequestBody Event event){
//		List<Event> listBlogs11=eventDao.getAll();
//		if(listBlogs11 != null){
//			return new ResponseEntity<List<Event>>(listBlogs11,HttpStatus.OK);
//		}else {
//			return new ResponseEntity<List<Event>>(listBlogs11,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//	}

}
