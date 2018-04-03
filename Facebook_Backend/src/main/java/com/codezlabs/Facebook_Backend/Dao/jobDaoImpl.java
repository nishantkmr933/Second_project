package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codezlabs.Facebook_backend.model.Job;
import com.codezlabs.Facebook_backend.model.JobsApplied;

@Repository("jobDao")
@Transactional
public class jobDaoImpl implements JobDao{
	static SessionFactory sessionFactory;

	public boolean create(Job job) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public boolean update(Job job) {
		try{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public Job get(long jobId) {
		String hql="from s_job where jobId=? ";
		Job job=null;
		try{
			job=(Job)sessionFactory.getCurrentSession().createQuery(hql).getResultList(); 	
			return job;
		}catch (Exception e) {
			return null;
		}
	}

	public List<JobsApplied> getAll(long userId) {
		String hql="from s_job where jobId=?";
		List<JobsApplied>jobsApplieds=sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return jobsApplieds;
	}

	public boolean saveJobApplied(JobsApplied jobsApplied) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(jobsApplied);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public List<JobsApplied> getAll() {
		String hql="from s_job";
		List<JobsApplied>jobsApplieds=sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return jobsApplieds;
	}
	
}
