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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codezlabs.Facebook_backend.Dao.JobDao;
import com.codezlabs.Facebook_backend.model.Blog;
import com.codezlabs.Facebook_backend.model.Job;
import com.codezlabs.Facebook_backend.model.JobsApplied;

@RestController
public class JobController {

	@Autowired
	JobDao jobDao;

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Job job) {
		if (jobDao.create(job)) {
			return new ResponseEntity<String>("Added Job", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateBlog")
	public ResponseEntity<String> updateBlog(@RequestBody Job job) {
		if (jobDao.update(job)) {
			return new ResponseEntity<String>("Blog Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/{jobId}")
	public ResponseEntity getbyId(@PathVariable("jobId") long jobId) {
		Job listBlog = jobDao.get(jobId);
		if (listBlog != null) {
			return new ResponseEntity(jobId, HttpStatus.OK);
		} else {
			return new ResponseEntity(jobId, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAll/{jobId}")
	public ResponseEntity<List<JobsApplied>> getAll(@PathVariable("jobId") long jobId) {
		List<JobsApplied> listBlog = jobDao.getAll(jobId);
		if (listBlog != null) {
			return new ResponseEntity<List<JobsApplied>>(listBlog, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<JobsApplied>>(listBlog, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/saveJobApplied")
	public ResponseEntity<String> saveJobApplied(@RequestBody JobsApplied job) {
		if (jobDao.saveJobApplied(job)) {
			return new ResponseEntity<String>("Savejob", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("unsaved job", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<JobsApplied>>getAll(){	
		List<JobsApplied> listBlogs = jobDao.getAll();
		if (listBlogs != null) {
			return new ResponseEntity<List<JobsApplied>>(listBlogs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<JobsApplied>>(listBlogs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
