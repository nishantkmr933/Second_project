package com.codezlabs.Facebook_backend.Dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codezlabs.Facebook_backend.model.User;

@Repository("userDao")

@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean create(User user) {
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}catch(HibernateException e){
			return false;
		}
	}

	public boolean update(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean delete(String userId) {
		try{
			sessionFactory.getCurrentSession().delete(getById(userId));
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public User getById(String userId) {
		String hql="from User where userId"+userId;
		User user=null;
		try{
			user=(User) sessionFactory.getCurrentSession().createQuery(hql).getResultList();
			return user;
		}catch(Exception e){
		return null;
		}
	}

	public User getByName(String name) {
		String hql="from User where userName"+name;
		User user= null;
		try{
			user=(User)sessionFactory.getCurrentSession().createQuery(hql).getResultList();
			return user;
		}catch(Exception e){
			return null;
		}
	}

	public List<User> getAll() {
		String hql="from User";
		List<User> user=sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return user;
	}

	public List<User> getAllExcept(long userId) {
		String hql="from User where userId"+userId;
		List<User> user=sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return user;
	}

	public boolean exists(User auser) {
		User user=getByName(auser.getUserName());
		return(user!=null);
	}

	public boolean authenticate(String username, String password) {
		String hql="from User where userName'"+username+"' and password='"+password+"'";
		User user= null;
		try{
			user=(User)sessionFactory.getCurrentSession().createQuery(hql).getResultList();			
		}catch(NoResultException e){
			e.printStackTrace(System.err);
		}
		return (user!=null);
	}

	public boolean setOnline(String userId) {
		String hql="from User set isOnline= true where userId"+userId;
		int result=sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		System.out.println(result+"Record updated!!");
		return true;
		
	}

	public boolean setOffline(String userId) {
		String hql="from User set isOnline= true where userId"+userId;
		int result=sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		System.out.println(result+"Record updated!!");
		return true;
	}
	
}
