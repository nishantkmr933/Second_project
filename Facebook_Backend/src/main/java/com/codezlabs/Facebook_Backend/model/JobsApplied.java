package com.codezlabs.Facebook_backend.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.codezlabs.Facebook_backend.model.Job;
import com.codezlabs.Facebook_backend.model.JobStatus;
import com.codezlabs.Facebook_backend.model.User;

@Entity
@Table(name="s_jobApplied")
public class JobsApplied {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="jobsApplied_sequence")
	@SequenceGenerator(sequenceName="jobsApplied_sequence",name="jobsApplied_sequence")
	private long jobAppliedId;
	@ManyToOne()
	@JoinColumn(name="userId")
	private User user;
	@ManyToOne()
	@JoinColumn(name="jobId")
	private Job job;
	@Enumerated(EnumType.STRING)
	private JobStatus status;
	
	public long getJobAppliedId() {
		return jobAppliedId;
	}
	public void setJobAppliedId(long jobAppliedId) {
		this.jobAppliedId = jobAppliedId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public JobStatus getStatus() {
		return status;
	}
	public void setStatus(JobStatus status) {
		this.status = status;
	}
	
}
