package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import com.codezlabs.Facebook_backend.model.Job;
import com.codezlabs.Facebook_backend.model.JobsApplied;

public interface JobDao  {
	
	public boolean create(Job job);
	public boolean update(Job job);
	public Job get(long jobId);
	public List<JobsApplied>getAll();
	public List<JobsApplied> getAll(long userId);
	public boolean saveJobApplied(JobsApplied jobsApplied);
}
