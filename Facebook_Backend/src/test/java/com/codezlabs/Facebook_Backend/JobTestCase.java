package com.codezlabs.Facebook_backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codezlabs.Facebook_backend.Dao.JobDao;
import com.codezlabs.Facebook_backend.model.Job;
import com.codezlabs.Facebook_backend.model.JobStatus;
import com.codezlabs.Facebook_backend.model.JobsApplied;

public class JobTestCase {

	static AnnotationConfigApplicationContext context;
	static Job job;
	static JobDao jobDao;
	static JobsApplied jobsApplied;
	
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.codezlabs");
		context.refresh();
		jobDao=(JobDao) context.getBean("jobDao");
		job= (Job) context.getBean("job");
		
	}
	
	@Ignore
	@Test
	public void createTestCase(){
		job.setJobDescription("Welcome to Job");
		job.setJobTitle("Welcome");
		//job.setPostDate(java.time.format.DateTimeFormatter.ISO_ORDINAL_DATE);
		job.setStatus(JobStatus.JOB_NEW);
		jobDao.create(job);
		Assert.assertEquals("Create Job test case", true);
	}
	
	@Ignore
	@Test
	public void updateTestCase(){
		job.setJobDescription("Welcome to update job");
		job.setJobTitle("Update to Welcome");
		job.setStatus(JobStatus.JOB_APPLIED);
		jobDao.update(job);
		Assert.assertEquals("Updade Job test case", true);
	}
	
	@Ignore
	@Test
	public void getByIdTestCase(){
		job.setJobId(1);
		jobDao.get(job.getJobId());
		Assert.assertEquals("Get by id", true);		
	}
	
	@Ignore
	@Test
	public void getAllByTestCase(){
		List<JobsApplied> jobsapplied= jobDao.getAll();
		System.out.println(jobsapplied);
		Assert.assertEquals("Element containt in List", true);
	}
	
	@Ignore
	@Test
	public void saveJobAppliedTestCase(){
		jobsApplied.setJob(job);
		jobDao.saveJobApplied(jobsApplied);
		Assert.assertEquals("Save job Appiled", true);
	}
}
	
	